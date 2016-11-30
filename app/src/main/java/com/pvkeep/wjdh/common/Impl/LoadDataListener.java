package com.pvkeep.wjdh.common.Impl;

/**
 * Created by Admin on 2016/11/30.
 */
public interface LoadDataListener<T> extends BaseListener {

    void onLoadCompletedListener(T result);
    void onLoadStartedListener();
    void onLoadErrorListener(String result);
    void onLoadNullListener();
}
