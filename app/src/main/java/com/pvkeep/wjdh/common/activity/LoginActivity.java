package com.pvkeep.wjdh.common.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.pvkeep.wjdh.activity.R;
import com.pvkeep.wjdh.common.entity.UserVo;
import com.pvkeep.wjdh.common.impl.LoginImpl;
import com.pvkeep.wjdh.common.presenter.LoginPresenter;
import com.pvkeep.wjdh.network.HttpResult;
import com.pvkeep.wjdh.network.HttpResultSubscriber;
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
public class LoginActivity extends MvpActivity<LoginPresenter> implements LoginImpl {

    @Bind(R.id.textview)
    TextView tv;
    private HttpResult<UserVo> user;

    @Override
    public int getContentViewId() {
        return R.layout.login_layout;
    }

    @Override
    protected void initAllMembersView(Bundle savedInstanceState) {

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
    public void getDataSuccess(UserVo User) {
        tv.setText(User.toString());
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
    public void getDataFail(String msg) {
        toastShow("有问题");
    }

    @Override
    public void showLoading() {
        showProgressDialog();
    }

    @Override
    public void hideLoading() {
        dismissProgressDialog();
    }

    private void login(){
        Map<String, String> map = new HashMap<>();
        NetService service = NetFactory.getInstance().createService(NetService.class);
        service.login(map).compose(TransformUtils.<UserVo>defaultSchedulers())
                .subscribe(new Subscriber<UserVo>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(UserVo userVo) {

                    }
                });
    }
}
