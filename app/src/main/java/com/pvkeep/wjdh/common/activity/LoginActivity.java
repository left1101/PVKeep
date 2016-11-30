package com.pvkeep.wjdh.common.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.pvkeep.wjdh.activity.R;
import com.pvkeep.wjdh.common.View.LoginView;
import com.pvkeep.wjdh.common.entity.UserVo;
import com.pvkeep.wjdh.common.presenter.LoginPresenter;
import com.pvkeep.wjdh.mine.entity.User;
import com.pvkeep.wjdh.network.HttpResult;
import com.pvkeep.wjdh.network.NetFactory;
import com.pvkeep.wjdh.network.NetService;
import com.pvkeep.wjdh.network.TransformUtils;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.OnClick;
import rx.Subscriber;

/**
 * Created by Admin on 2016/10/15.
 */
public class LoginActivity extends MvpActivity<LoginPresenter> implements LoginView {

    @Bind(R.id.textview)
    TextView tv;
    private HttpResult<UserVo> user;

    @Override
    public int getContentViewId() {
        return R.layout.login_layout;
    }

    @Override
    protected void initAllMembersView(Bundle savedInstanceState) {
        mvpPresenter.attachView(this);
    }

    @OnClick(R.id.button)
    public void mLogin(View view){
        mvpPresenter.login();
    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter(this);
    }

    @Override
    public void getDataSuccess(UserVo result) {
        tv.setText(result.toString());
        toastShow("登录成功");
    }

    @Override
    public Map<String, String> getUserVo() {
        Map<String, String> map = new HashMap<>();
        map.put("phoneType", "Android");
        map.put("username", "xiexiru");
        map.put("password", "123456");
        map.put("deviceToken", "864264022521097");
        map.put("userId", "");
        return map;
    }

    @Override
    public void getDataFail(String result) {
        toastShow("有问题:" + result);
    }

    @Override
    public void showLoading() {
        showProgressDialog();
    }

    @Override
    public void hideLoading() {
        dismissProgressDialog();
    }

}
