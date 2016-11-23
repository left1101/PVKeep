package com.pvkeep.wjdh.network;

import com.pvkeep.wjdh.utils.tools.Mlog;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;

/**
 * Created by Admin on 2016/10/15.
 */
public abstract class HttpResultSubscriber<T> extends Subscriber<HttpResult<T>> {

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        Mlog.e(this.getClass().toString(),e.getMessage());
        e.printStackTrace();
        //在这里做全局的错误处理
        if (e instanceof HttpException) {
            //Mlog.e("TAG", e.getMessage());
        }
        _onError(e);
    }

    @Override
    public void onNext(HttpResult<T> t) {
        if (!t.error)
            onSuccess(t.results);
        else
            _onError(new Throwable("error=" + t.error));
    }

    public abstract void onSuccess(T t);

    public abstract void _onError(Throwable e);
}
