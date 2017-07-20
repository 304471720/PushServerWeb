package com.jia.push.newpush.push;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.jia.push.constants.Constants;
import com.jia.push.newpush.bean.SendHuoDongEntity;
import com.jia.push.util.JdbcUtil;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 2017/7/12.
 */
public class JiaJuPush  extends PushTemplate<SendHuoDongEntity> {
    private static Logger logger = Logger.getLogger(JiaJuPush.class);

    @Override
    public void push(SendHuoDongEntity newInfo, List<String> tokenList) {
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("product", "soufun");
        param.put("os", "iphone");
        param.put("isProduct", "1");
        param.put("payload", "{\"aps\":{\"sound\":\"default\",\"alert\":\"" + newInfo.getTitle().replace("\"","\\u201c") + "\",\"badge\":1},\"id\":\"2\",\"d\":\""+ Constants.PLAYLOAD_DESC.PAYLOAD_DESC_TUFA_JIAJU.ordinal()+"\",\"url\":\"" + newInfo.getUrl() + "\"}");
        param.put("token", Joiner.on(',').skipNulls().join(tokenList));
        //PushBase.send("testsfsecretary",param);
        logger.info(param);
    }

    @Override
    public String getSql(SendHuoDongEntity newInfo) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT   token FROM sendUser  WHERE imei7 in (");
        sb.append(" SELECT imei FROM homepush_App");
        String cityCaluse=null;
        String roleCaluse = null;
        if (!newInfo.getCity().equals("全国"))
        {
            Iterable<String> citys  = Splitter.onPattern(Constants.CITYS_FROMHTTP_SEPERATOR).trimResults().omitEmptyStrings().split(newInfo.getCity());
            cityCaluse  = JdbcUtil.setParam(" WHERE  city in (:citys)","citys",citys);
            sb.append(cityCaluse);
        }
        if (!newInfo.getRole().equals("全部"))
        {
            Iterable<String> roles  = Splitter.onPattern(Constants.CITYS_FROMHTTP_SEPERATOR).trimResults().omitEmptyStrings().split(newInfo.getRole());
            if (!Strings.isNullOrEmpty(cityCaluse))
            {
                sb.append(" AND ");
            }else
            {
                sb.append(" WHERE ");
            }
            roleCaluse  = JdbcUtil.setParam(" role in (:roles)","roles",roles);
            sb.append(roleCaluse);
        }
        sb.append(" ) ");
        return sb.toString();
    }

    @Override
    public boolean saveEntity(SendHuoDongEntity entity, String typeName) {
        return true;
    }

    @Override
    public void notify(SendHuoDongEntity sendHuoDongEntity, Integer sendCount, String sql) {
    }
}
