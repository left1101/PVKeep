package com.pvkeep.wjdh.app;

import android.app.Application;

/**
 * Created by Admin on 2016/10/15.
 */
public class MyApplication extends Application {

    public static MyApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        firstCreateInstance();
    }

    private void firstCreateInstance(){
        if (application == null){
            application = this;
        }
    }

    //获取application
    public static MyApplication getInstance(){
        return application;
    }

}
