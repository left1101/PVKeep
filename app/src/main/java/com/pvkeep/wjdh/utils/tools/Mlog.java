package com.pvkeep.wjdh.utils.tools;

import android.util.Log;

/**
 * Created by Admin on 2016/10/15.
 */
public class Mlog {

    private static boolean flag = true;//是否打印的标志，APP发布时改为false
    //打印正常的信息
    public static void i(String TAG, String s){
        if (flag){
            Log.i(TAG, s);
        }
    }

    //打印错误信息
    public static void e(String TAG, String s){
        if (flag){
            Log.e(TAG, s);
        }
    }
}
