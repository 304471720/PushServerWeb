package com.jia.push.newpush.httpdata;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Joiner;
import com.google.common.base.Strings;
import com.google.common.collect.Sets;
import com.jia.push.constants.Constants;
import com.jia.push.newpush.bean.CmsNewsInfoTufa;
import com.jia.push.newpush.bean.SendHuoDongEntity;
import com.jia.push.util.BeanMapConvert;
import com.jia.push.util.DaoUtil;
import com.jia.push.util.JdbcUtil;
import org.apache.log4j.Logger;

import java.util.*;

/**
 * Created by user on 2017/3/23.
 */
public class TufaProcessor extends DaoUtil{
    private static Logger logger = Logger.getLogger(TufaProcessor.class);

    private List<SendHuoDongEntity> getTufaFromHttp(String startTime, String endTime, String newsId, String YYWID, String baseurl) {
        List<SendHuoDongEntity> ret = new LinkedList<SendHuoDongEntity>();
        CmsNewsInfoTufa test = HttpDataGet.getJishiNews(startTime,endTime,baseurl);
        Map<String,List<CmsNewsInfoTufa>> result  =  new LinkedHashMap<String, List<CmsNewsInfoTufa>>();
        logger.info(JSON.toJSONString(test));
        for (int i=0;i<test.getTotal();i++)
        {
            CmsNewsInfoTufa.ResultBean bean = test.getResult().get(i);
            String title = bean.getNormalColumnData().getTitle();
            String url = bean.getNormalColumnData().getUrl();
            String picurl = bean.getNormalColumnData().getImagePath();
            String tmp= bean.getCustomColumnData().getCustomColumn2();
            if (Strings.isNullOrEmpty(tmp))
            {
                tmp = "全国";
            }
            String citys = tmp;
            String type = bean.getCustomColumnData().getCustomColumn1();
            String role = bean.getCustomColumnData().getCustomColumn3();
            int id =  bean.getId();
            Map<String,Object> pushinfo = new HashMap<String,Object>();
            pushinfo.put("title",title);
            pushinfo.put("url",url);
            pushinfo.put("picurl",picurl);
            pushinfo.put("city",citys);
            pushinfo.put("type",type);
            pushinfo.put("role",role);
            pushinfo.put("id",YYWID+id);
            pushinfo.put("flag",0);
            SendHuoDongEntity timlynewspushinfoEntity = BeanMapConvert.map2Bean(pushinfo,SendHuoDongEntity.class);
            //只要指定id的新闻
            logger.info(newsId);
            logger.info(id);
            if (newsId.equals(String.valueOf(id)))
            {
                ret.add(timlynewspushinfoEntity);
            }
        }
        logger.info(JSON.toJSONString(ret));
        return ret;
    }

    public String getCitys(String citys)
    {
        Set<String> retSet = new LinkedHashSet<String>();
        String ret =null;
        for (String city1 : Constants.citySets)
        {
            if (citys.contains(city1))
            {
                retSet.add("'"+city1+"'");
            }
        }
        if (retSet.size() > 0 )
        {
            ret =  Joiner.on(",").skipNulls().join(retSet);
        }
        return ret;
    }


    public List<SendHuoDongEntity> getTufaNews(String startTime, String endTime, String newsId, String YYWID, String url) {
        //从接口获取数据
        List<SendHuoDongEntity> list = HttpDataGet.getSendHuoDongWithUniqNewsID(getTufaFromHttp(startTime,endTime,newsId,YYWID,url));
        if (list == null || list.size() == 0)
        {
            return  null;
        }
        List<String> idFromHttp = get1ColumnFromList(list,"id");
        logger.info(JSON.toJSONString(idFromHttp));
        String sql=" select id from new_sendHuoDong  where id in (:ids) ";//使用命名参数，推荐使用，易读。
        sql = JdbcUtil.setParam(sql,"ids", idFromHttp);
        logger.info(sql);
        //查询数据库，看这次接口获取的数据是否已经存在数据库中。存在就过滤掉
        List<SendHuoDongEntity> existList =  getList(sql,SendHuoDongEntity.class);
        logger.info(JSON.toJSONString(existList));
        if (existList == null)
        {
            String title  = "  查询数据库失败 ";
            String message = JSON.toJSONString(list);
            String mailsendto = "lijiajia@fang.com";
            logger.info("继续进行");
        }
        //处理一下，得到在数据库中存在的 id列表
        List<String> idExistList = get1ColumnFromList(existList,"id");
        logger.info(idExistList);
        HashSet<String> existIdSets = Sets.newHashSet(idExistList);
        List<SendHuoDongEntity> ret = new ArrayList<SendHuoDongEntity>();
        for (SendHuoDongEntity tmp: list)
        {
            if (!existIdSets.contains(tmp.getId()))
            {
                ret.add(tmp);
            }
        }
        //查询数据库，过滤掉在数据库中已经存在的
        logger.info(ret);
        return ret;
    }

}
