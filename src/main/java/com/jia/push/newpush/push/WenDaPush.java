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
public class WenDaPush  extends PushTemplate<SendHuoDongEntity> {
	 private Logger logger = Logger.getLogger(WenDaPush.class);
    @Override
    public void push(SendHuoDongEntity newInfo, List<String> tokenList) {
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("product", "soufun");
        param.put("os", "iphone");
        param.put("isProduct", "1");
        param.put("payload", "{\"aps\":{\"sound\":\"default\",\"alert\":\"" + newInfo.getTitle().replace("\"","\\u201c") + "\",\"badge\":1},\"id\":\"2\",\"d\":\""+ Constants.PLAYLOAD_DESC.PAYLOAD_DESC_TUFA_WENDA.ordinal()+"\",\"url\":\"" + newInfo.getUrl() + "\"}");
        param.put("token", Joiner.on(',').skipNulls().join(tokenList));
        /*PushRequestInfo pushRequestInfo = BeanMapConvert.map2Bean(param,PushRequestInfo.class);
        PushBase.sendMsg(pushRequestInfo.getProduct(),
                pushRequestInfo.getIsProduct(), pushRequestInfo.getToken(),
                pushRequestInfo.getPayload(), pushRequestInfo.getOs(),
                pushRequestInfo.getCallback());*/
//        PushBase.send("testsfsecretary", param);
        logger.info(param);
    }

    @Override
    public String getSql(SendHuoDongEntity newInfo) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT   token FROM sendUser_xiaomishu");
        String cityCaluse=null;
        String roleCaluse = null;
        String role = null;
        if (!newInfo.getCity().equals("全国"))
        {
            Iterable<String> citys  = Splitter.onPattern(Constants.CITYS_FROMHTTP_SEPERATOR).trimResults().omitEmptyStrings().split(newInfo.getCity());
            cityCaluse  = JdbcUtil.setParam(" WHERE  city in (:citys)","citys",citys);
            sb.append(cityCaluse);
        }
        if (!newInfo.getRole().equals("全部"))
        {
        	 role = newInfo.getRole();
        	 if (null!=role) {
     			if (role.contains("新房")) {
     			    role = role.replace("新房", "N_BUY");
     			} 
     			if (role.contains("二手房买房")) {
     			    role = role.replace("二手房买房","E_BUY");
     			}
     			if (role.contains("二手房卖房")) {
     			    role = role.replace("二手房卖房","E_SALE");
     			} 
     			if (role.contains("租房房客")) {
     			    role = role.replace("租房房客","R_BUY");
     			} 
     			if (role.contains("租房房东")) {
     			    role = role.replace("租房房东","R_SALE");
     			}
     			if (role.contains("家居") || role.contains("装修")) {
     			    role = role.replace("家居","H_BUY");
     			   role = role.replace("装修","H_BUY");
     			}
     		}
            Iterable<String> roles  = Splitter.onPattern(Constants.CITYS_FROMHTTP_SEPERATOR).trimResults().omitEmptyStrings().split(role);
            if (!Strings.isNullOrEmpty(cityCaluse))
            {
                sb.append(" AND ");
            }else
            {
                sb.append(" WHERE ");
            }
            cityCaluse  = JdbcUtil.setParam(" imei7 IN (SELECT imei  FROM SouFangUserRole WHERE main_role in (:roles)","roles",roles);
            sb.append(cityCaluse);
            sb.append(")");
        }
        String sql=sb.toString();
        logger.info("sql:"+sb.toString());
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
