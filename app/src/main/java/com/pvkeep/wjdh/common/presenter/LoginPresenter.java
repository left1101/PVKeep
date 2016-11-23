package com.pvkeep.wjdh.common.presenter;

import com.pvkeep.wjdh.common.entity.UserVo;
import com.pvkeep.wjdh.common.impl.LoginImpl;
import com.pvkeep.wjdh.retrofit.ApiCallback;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Admin on 2016/10/17.
 */
public class LoginPresenter extends BasePresenter<LoginImpl> {

    public LoginPresenter(LoginImpl impl){
        attachView(impl);
    }

    public void login(){
        mvpView.showLoading();
        addSubscription(apiStores.login(mvpView.getUserVo()), new ApiCallback<UserVo>(){

            @Override
            public void onSuccess(UserVo model) {
                mvpView.getDataSuccess(model);
            }

            @Override
            public void onFailure(String msg) {
                mvpView.getDataFail(msg);
            }

            @Override
            public void onFinish() {
                mvpView.hideLoading();
            }
        });
    }

    public void logout(){

    }
}
