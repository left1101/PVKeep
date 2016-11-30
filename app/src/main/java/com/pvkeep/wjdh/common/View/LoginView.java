package com.pvkeep.wjdh.common.View;

import com.pvkeep.wjdh.common.entity.UserVo;

import java.util.Map;

/**
 * Created by Admin on 2016/11/30.
 */
public interface LoginView extends BaseNetView<UserVo> {

    Map<String, String> getUserVo();
}
