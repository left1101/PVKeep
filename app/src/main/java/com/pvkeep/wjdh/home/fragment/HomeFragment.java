package com.pvkeep.wjdh.home.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.pvkeep.wjdh.activity.R;
import com.pvkeep.wjdh.common.activity.LoginActivity;
import com.pvkeep.wjdh.common.fragment.BaseFragment;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by Admin on 2016/10/15.
 */
public class HomeFragment extends BaseFragment {

    @Bind(R.id.tex_title)
    TextView tv;

    @Override
    public int getContentViewId() {
        return R.layout.home_fragment;
    }

    @Override
    protected void initAllMembersView(Bundle savedInstanceState) {
        tv.setText("首页");
    }

    @OnClick(R.id.login)
    public void intent(){
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }
}
