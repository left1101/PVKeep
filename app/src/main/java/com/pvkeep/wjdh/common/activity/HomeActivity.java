package com.pvkeep.wjdh.common.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;

import com.pvkeep.wjdh.activity.R;
import com.pvkeep.wjdh.home.fragment.HomeFragment;
import com.pvkeep.wjdh.mine.fragment.MineFragment;
import com.pvkeep.wjdh.position.fragment.PositionFragment;
import com.pvkeep.wjdh.worker.fragment.WorkerFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by Admin on 2016/10/15.
 */
public class HomeActivity extends FragmentActivity implements View.OnClickListener {

    private HomeFragment homeFragment;
    private PositionFragment positionFragment;
    private MineFragment mineFragment;
    private WorkerFragment workerFragment;
    private FrameLayout homeLayout;

    private RadioButton rbHome;
    private RadioButton rbPosition;
    private RadioButton rbWork;
    private RadioButton rbMine;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        EventBus.getDefault().register(this);
        initView();
        initFragment();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    private void initView (){
        homeLayout = (FrameLayout) findViewById(R.id.viewpager);
        rbHome = (RadioButton) findViewById(R.id.home_lin);
        rbPosition = (RadioButton) findViewById(R.id.project_lin);
        rbWork = (RadioButton) findViewById(R.id.powerstation_lin);
        rbMine = (RadioButton) findViewById(R.id.my_lin);

        rbHome.setOnClickListener(this);
        rbPosition.setOnClickListener(this);
        rbWork.setOnClickListener(this);
        rbMine.setOnClickListener(this);
    }

    //初始化fragment
    private void initFragment(){
        FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        homeFragment = new HomeFragment();
        positionFragment = new PositionFragment();
        mineFragment = new MineFragment();
        workerFragment = new WorkerFragment();
        t = getSupportFragmentManager().beginTransaction();
        t.add(R.id.viewpager, homeFragment);
        t.add(R.id.viewpager, positionFragment);
        t.add(R.id.viewpager, mineFragment);
        t.add(R.id.viewpager, workerFragment);
        showFagment(1);
        t.commit();

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.home_lin:
                showFagment(1);
                break;
            case R.id.powerstation_lin:
                showFagment(3);
                break;
            case R.id.project_lin:
                showFagment(2);
                break;
            case R.id.my_lin:
                showFagment(4);
                break;
        }
    }

    //选择显示的fragment
    private void showFagment(int page){
        FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        switch (page){
            case 1:
                t.show(homeFragment);
                t.hide(positionFragment);
                t.hide(workerFragment);
                t.hide(mineFragment);
                break;
            case 2:
                t.hide(homeFragment);
                t.show(positionFragment);
                t.hide(workerFragment);
                t.hide(mineFragment);
                break;
            case 3:
                t.hide(homeFragment);
                t.hide(positionFragment);
                t.show(workerFragment);
                t.hide(mineFragment);
                break;
            case 4:
                t.hide(homeFragment);
                t.hide(positionFragment);
                t.hide(workerFragment);
                t.show(mineFragment);
                break;
        }
        t.commit();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onFinish(String s){
        if(s.equals("finish")){
            finish();
        }
    }
}
