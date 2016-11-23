package com.pvkeep.wjdh.common.impl;

import com.pvkeep.wjdh.common.entity.UserVo;

import java.util.Map;

/**
 * Created by Xiexr on 2016/10/17.
 */
public interface LoginImpl {
    void getDataSuccess(UserVo User);
    void getDataFail(String msg);
    void showLoading();
    void hideLoading();
    Map<String, String> getUserVo();
}
