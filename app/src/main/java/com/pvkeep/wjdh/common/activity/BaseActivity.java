package com.pvkeep.wjdh.common.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.pvkeep.wjdh.activity.R;
import com.pvkeep.wjdh.utils.tools.Mlog;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;

/**
 * Created by Xiexr
 */
public abstract class BaseActivity extends AppCompatActivity {

    public static final int MODE_NONE = 0;
    public static final int MODE_BACK = 1;
    public static final int MODE_ADD = 2;
    public static final int MODE_BACK_ADD = 3;
    public static final int MODE_HOME = 4;

    protected TextView texTitle;
    protected ImageButton iBtnBack;
    protected ImageView iBtnAdd;
    protected Intent intent;

    public Activity mActivity;

    public ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUpContentView();
        ButterKnife.bind(this);
        mActivity = this;
        intent = getIntent();
        EventBus.getDefault().register(BaseActivity.this);
        setUpView();
        setUpData(savedInstanceState);
    }

    public void setContentView(int layoutResID) {
        setContentView(layoutResID, -1, -1, MODE_BACK);
    }

    public void setContentView(int layoutResID, int titleID) {
        setContentView(layoutResID, titleID, -1, MODE_BACK);
    }

    public void setContentView(int layoutResID, int titleID, int mode, int btnID) {
        setContentView(layoutResID, titleID, -1, mode, btnID);
    }

    public void setContentView(int layoutResID, int titleID, int menuId, int mode, int btnID) {
        super.setContentView(layoutResID);
        setUpToolbar(titleID, -1, mode, btnID);
    }

    private void setUpToolbar(int titleID, int menuID, int mode, int btnID) {
        if (mode != MODE_NONE) {

            texTitle = (TextView) findViewById(R.id.title);
            setUpTitle(titleID);

            if (mode != MODE_HOME) {

                switch (mode) {
                    case MODE_BACK:
                        setUpBack();
                        break;
                    case MODE_BACK_ADD:
                        setUpBack();
                        setUpAdd(btnID);
                        break;
                    case MODE_ADD:
                        setUpAdd(btnID);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private void setUpAdd(int btnID) {
        iBtnAdd = (ImageView) findViewById(R.id.ibt_add);
        iBtnAdd.setImageResource(btnID);
        iBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doAdd();
            }
        });
    }

    protected abstract void doAdd();

    private void setUpBack() {
        iBtnBack = (ImageButton) findViewById(R.id.ibt_back);
        iBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackClicked();
            }
        });
    }

    private void onBackClicked() {
        finish();
    }

    private void setUpTitle(int titleID) {
        if (titleID > 0 && texTitle != null) {
            texTitle.setText(titleID);
        }
    }

    /**
     * 设置布局的id
     * @return
     */
    public abstract int setUpContentView();

    /**
     *
     */
    public abstract void setUpView();

    /**
     *
     * @param savedInstanceState
     */
    protected abstract void setUpData(Bundle savedInstanceState);

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(BaseActivity.this);
        ButterKnife.unbind(this);
        super.onDestroy();
    }

    public void toastShow(int resId) {
        Toast.makeText(mActivity, resId, Toast.LENGTH_SHORT).show();
    }

    public void toastShow(String resId) {
        Toast.makeText(mActivity, resId, Toast.LENGTH_SHORT).show();
    }

    public void mLog(String log){
        Mlog.i(mActivity.getClass().toString(), log);
    }

    public ProgressDialog showProgressDialog() {
        progressDialog = new ProgressDialog(mActivity);
        progressDialog.setMessage("加载中");
        progressDialog.show();
        return progressDialog;
    }

    public ProgressDialog showProgressDialog(CharSequence message) {
        progressDialog = new ProgressDialog(mActivity);
        progressDialog.setMessage(message);
        progressDialog.show();
        return progressDialog;
    }

    public void dismissProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            // progressDialog.hide();会导致android.view.WindowLeaked
            progressDialog.dismiss();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onFinish(String s){
        if(s.equals("finish")){
            finish();
        }
    }

}
