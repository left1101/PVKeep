package com.pvkeep.wjdh.common.presenter;

import com.pvkeep.wjdh.common.Model.BaseModel;
import com.pvkeep.wjdh.common.View.BaseView;

/**
 * Created by Xiexr
 */
public class BasePresenter<V extends BaseView> {

    public V mvpView;

    public void attachView(V mvpView) {
        this.mvpView = mvpView;
    }

    public void detachView() {
        this.mvpView = null;
    }

}
