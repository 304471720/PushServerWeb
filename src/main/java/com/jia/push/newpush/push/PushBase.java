package com.jia.push.newpush.push;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;

import java.util.Map;

/**
 * Created by user on 2017/3/23.
 */
public class PushBase {
    private static Logger logger = Logger.getLogger(PushBase.class);
    public static void sendMsg(String product, String isTest, String token, String payload, String os, String callback)
    {
            logger.debug(String.format("%s,%s,%s,%s,%s,%s",product,isTest,token,payload,os,callback));
    }
    public static void sendMsg(String tokens, String product, String message, String isTest, String os, String command, int type, String username){

            logger.debug(String.format("%s,%s,%s,%s,%s,%s,%s,%s",tokens,product,message,isTest,os,command,type,username));
    }

    public static void send(String quene, Map<String,Object> map){

        logger.debug(String.format(JSON.toJSONString(map)));
    }

}
