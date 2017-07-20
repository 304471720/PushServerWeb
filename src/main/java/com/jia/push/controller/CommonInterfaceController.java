package com.jia.push.controller;

import com.alibaba.fastjson.JSON;
import com.jia.push.constants.Constants;
import com.jia.push.newpush.bean.SendHuoDongEntity;
import com.jia.push.newpush.httpdata.TufaProcessor;
import com.jia.push.newpush.push.JiaJuPush;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by sf on 2015/2/9.
 */

@Controller
@RequestMapping("/notifyservice")
public class CommonInterfaceController {
	@Autowired
	ThreadPoolTaskExecutor threadPool;
    private Logger logger = Logger.getLogger(CommonInterfaceController.class);

    @RequestMapping(value = "/jiajutuisong"/*, method = RequestMethod.POST*/)
    public void jiajutuisong(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/json; charset=UTF-8");
        try {
            StringBuffer sb = new StringBuffer();
            final String starttime = request.getParameter("effectiveTime");
            final String newsId = request.getParameter("newsId");
            final String endtime = starttime;
            logger.info(newsId);
            logger.info(starttime);
            sb.append(JSON.toJSONString(request.getParameterMap()));
            List<SendHuoDongEntity> list =  new TufaProcessor().getTufaNews(starttime,endtime,newsId,Constants.JIAJU_YYW_ID, Constants.JIAJU_YYW_URL);
            for (SendHuoDongEntity shde: list)
            {
                sb.append(JSON.toJSONString(shde));
                new JiaJuPush().setEntity(shde).start(JiaJuPush.class.getName());
            }
            PrintWriter out;
            out = response.getWriter();
            out.print(sb.toString());
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
