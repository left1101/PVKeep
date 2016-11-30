package com.pvkeep.wjdh.common.Model;

import com.pvkeep.wjdh.common.presenter.BasePresenter;
import com.pvkeep.wjdh.retrofit.ApiStores;
import com.pvkeep.wjdh.retrofit.AppClient;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public abstract class BaseModel<P extends BasePresenter> {

    P mPresenter;

    public BaseModel(){
    }

    public void attath(P presenter) {
        mPresenter = presenter;
    }

    public void detach() {
        mPresenter = null;
    }

}
