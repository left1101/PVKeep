package com.pvkeep.wjdh.common.Model;

import com.pvkeep.wjdh.common.Impl.LoadDataListener;
import com.pvkeep.wjdh.common.entity.UserVo;
import com.pvkeep.wjdh.common.presenter.LoginPresenter;
import com.pvkeep.wjdh.retrofit.ApiCallback;

import java.util.Map;

/**
 * Created by Admin on 2016/11/30.
 */
public class LoginModel extends BaseNetModel<LoginPresenter> {

    private LoadDataListener listener;

    public LoginModel(LoadDataListener listener){
        super();
        this.listener = listener;
    }

    public void login(Map<String, String> info){
        addSubscription(apiStores.login(info), new ApiCallback<UserVo>(){

            @Override
            public void onSuccess(UserVo model) {
                listener.onLoadCompletedListener(model);
            }

            @Override
            public void onFailure(String msg) {
                listener.onLoadErrorListener(msg);
            }

            @Override
            public void onFinish() {

            }
        });
    }
}
