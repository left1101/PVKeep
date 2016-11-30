package com.pvkeep.wjdh.common.Model;

import com.pvkeep.wjdh.common.presenter.BasePresenter;
import com.pvkeep.wjdh.retrofit.ApiStores;
import com.pvkeep.wjdh.retrofit.AppClient;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Admin on 2016/11/30.
 */
public class BaseNetModel<P extends BasePresenter> extends BaseModel {

    protected ApiStores apiStores;
    private CompositeSubscription mCompositeSubscription;

    public BaseNetModel(){
        super();
        apiStores = AppClient.retrofit().create(ApiStores.class);
    }

    //RXjava取消注册，以避免内存泄露
    public void onUnsubscribe() {
        if (mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()) {
            mCompositeSubscription.unsubscribe();
        }
    }

    public void addSubscription(Observable observable, Subscriber subscriber) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber));
    }
}
