package com.jia.push.newpush.bean;

/**
 * Created by user on 2015/12/17.
 */
public interface Processor<T> {
    public void run(T t);
}
