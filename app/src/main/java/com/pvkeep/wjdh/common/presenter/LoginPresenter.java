package com.pvkeep.wjdh.common.presenter;

import com.pvkeep.wjdh.common.Impl.LoadDataListener;
import com.pvkeep.wjdh.common.Model.LoginModel;
import com.pvkeep.wjdh.common.View.LoginView;
import com.pvkeep.wjdh.common.entity.UserVo;
import com.pvkeep.wjdh.retrofit.ApiCallback;

import java.util.Map;

/**
 * Created by Admin on 2016/10/17.
 */
public class LoginPresenter extends BasePresenter<LoginView> implements LoadDataListener<UserVo> {

    private LoginModel model;

    public LoginPresenter(LoginView view){
        attachView(view);
        model = new LoginModel(this);
        model.attath(this);
    }

    public void login(){
        Map<String, String> info = mvpView.getUserVo();
        model.login(info);
    }

    public void logout(){

    }

    @Override
    public void onLoadStartedListener() {
        mvpView.showLoading();
    }

    @Override
    public void onLoadNullListener() {
        mvpView.hideLoading();
    }

    @Override
    public void onLoadErrorListener(String result) {
        mvpView.hideLoading();
        mvpView.getDataFail(result);
    }

    @Override
    public void onLoadCompletedListener(UserVo result) {
        mvpView.hideLoading();
        mvpView.getDataSuccess(result);
    }
}
