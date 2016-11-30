package com.pvkeep.wjdh.common.View;

/**
 * Created by Admin on 2016/11/30.
 */
public interface BaseNetView<T extends Object> extends BaseView {

    void getDataSuccess(T result);
    void getDataFail(String result);
    void showLoading();
    void hideLoading();
}
