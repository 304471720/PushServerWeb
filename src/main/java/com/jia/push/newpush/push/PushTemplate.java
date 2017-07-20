package com.jia.push.newpush.push;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Strings;
import com.jia.push.constants.Constants;
import com.jia.push.newpush.bean.Processor;
import com.jia.push.newpush.bean.SendUser;
import com.jia.push.util.DaoUtil;
import org.apache.log4j.Logger;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by user on 2017/7/12.
 */
// T SendHuoDongEntity
public abstract class PushTemplate<T>  extends DaoUtil {
    private  Logger logger = Logger.getLogger(PushTemplate.class);
    private AtomicInteger sendCount = new AtomicInteger(0);
    private Integer pagesize =Constants.PAGE_SIZE;
    private String fromContent;
    private  T entity;

    public T getEntity() {
        return entity;
    }

    public PushTemplate setEntity(T entity) {
        this.entity = entity;
        return this;
    }

    public String getFromContent() {
        return fromContent;
    }

    public PushTemplate setFromContent(String fromContent) {
        this.fromContent = fromContent;
        return  this;
    }

    public abstract void  push(final T entity, List<String> tokenList);
    public abstract String getSql(final T entity);
    public abstract boolean saveEntity(final T entity ,final String typeName) ;
    public abstract void notify(final T entity, Integer sendCount, String sql);

    public Integer getPagesize() {
        return pagesize;
    }

    public PushTemplate setPagesize(Integer pagesize) {
        this.pagesize = pagesize;
        return this;
    }

    public boolean start(final String typeName)
    {
        if (entity == null && Strings.isNullOrEmpty(fromContent))
        {
            return false;
        }
        if (entity == null)
        {
            entity= JSON.parseObject(fromContent, (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
        }
        logger.info(" before go "+JSON.toJSONString(entity));
        go(entity,typeName);
        return true;
    }

    private final void go(final T entity, final String typeName){
        //保存发送记录
        if (!saveEntity(entity,typeName))
        {
            logger.info(" save false "+typeName);
            return;
        }
        String sql  = getSql(entity);
        final List<String> tokenList = new ArrayList<String>(pagesize);
        getList(sql, SendUser.class, new Processor<SendUser>() {
            @Override
            public void run(SendUser sendUser) {
                sendCount.getAndIncrement();
                tokenList.add(sendUser.getToken());
                if (tokenList.size() % pagesize == 0)
                {
                    logger.info(typeName+ "  sendCount "+ sendCount.get()  );
                    push(entity,tokenList);
                    tokenList.clear();
                }
            }
        });
        if (tokenList.size() > 0 )
        {
            push(entity,tokenList);
        }
        notify(entity,sendCount.get(),sql);
    }
}
