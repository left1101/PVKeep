package com.pvkeep.wjdh.common.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.pvkeep.wjdh.utils.tools.Mlog;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Xiexr
 */
public abstract class BaseFragment extends Fragment {

    protected Context mActivity;
    protected View mRootView;
    private CompositeSubscription mCompositeSubscription;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(getContentViewId(), container, false);
        this.mActivity = getActivity();
        EventBus.getDefault().register(BaseFragment.this);
        ButterKnife.bind(mRootView);
        initAllMembersView(savedInstanceState);
        return mRootView;
    }

    public abstract int getContentViewId();

    protected abstract void initAllMembersView(Bundle savedInstanceState);

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(mRootView);//解绑
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

    @Override
    public void onDestroy() {
        super.onDestroy();
        onUnsubscribe();
        EventBus.getDefault().unregister(BaseFragment.this);
    }

    public void onUnsubscribe() {
        //取消注册，以避免内存泄露
        if (mCompositeSubscription != null) {
            mCompositeSubscription.unsubscribe();
        }
    }

    public void addSubscription(Subscription subscription) {
//      if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
//      }
        mCompositeSubscription.add(subscription);
    }
}
