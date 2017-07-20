package com.jia.push.newpush.httpdata;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.jia.push.constants.Constants;
import com.jia.push.newpush.bean.CmsNewsInfoTufa;
import com.jia.push.newpush.bean.SendHuoDongEntity;
import com.jia.push.util.HttpUtils;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 2017/3/17.
 */
public class HttpDataGet {

    public static String getWirelessUrl(String result)
    {
        JSONObject object = null;
        String ret = null;
        try {
            object = JSON.parseObject(result);
            JSONArray resluts = object.getJSONArray("result");
            if (resluts == null || resluts.size() <= 0)
            {
                return null;
            }
            for (int i = 0;i < resluts.size();i++)
            {
                JSONObject tmp = resluts.getJSONObject(i);
                JSONObject normalColumnData = tmp.getJSONObject("normalColumnData");
                String url = normalColumnData.getString("wirelessUrl");
                String wirelessImg = normalColumnData.getString("wirelessImg");
                if (!Strings.isNullOrEmpty(url))
                {
                    normalColumnData.put("url",url);
                    normalColumnData.remove("wirelessUrl");
                }
                if (!Strings.isNullOrEmpty(wirelessImg))
                {
                    normalColumnData.put("imagePath",wirelessImg);
                    normalColumnData.remove("wirelessImg");
                }


            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        if (object != null)
        {
            ret = JSON.toJSONString(object);
        }
        return ret;
    }
    public static CmsNewsInfoTufa getJishiNews(final String startDay, final String endDay, String url) {
        String responseBody = HttpUtils.doGet(url,new HashMap<String, String>(){
            {
                put("startTime",startDay);
                put("endTime",endDay);
            }
        },"utf-8");
        CmsNewsInfoTufa ret = null;
        if (responseBody != null) {
            responseBody = getWirelessUrl(responseBody);
            ret = JSON.parseObject(responseBody, new TypeReference<CmsNewsInfoTufa>() {
            });
        }
        return ret;
    }

    public static List<SendHuoDongEntity> getSendHuoDongWithUniqNewsID(List<SendHuoDongEntity> list)
    {
        Map<String,SendHuoDongEntity> uniqNewsInfo = new LinkedHashMap<String,SendHuoDongEntity>();
        for (SendHuoDongEntity tmp : list)
        {
            tmp.setCity(tmp.getCity());
            SendHuoDongEntity exist = uniqNewsInfo.get(tmp.getId());
            if (exist != null)
            {
                exist.setCity(exist.getCity()+Constants.CITYS_SEPERATOR+ tmp.getCity());
            }else
            {
                uniqNewsInfo.put(String.valueOf(tmp.getId()),tmp);
            }
        }
        return Lists.newArrayList(uniqNewsInfo.values());
    }



}