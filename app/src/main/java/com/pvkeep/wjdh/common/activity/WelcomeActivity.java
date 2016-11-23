package com.pvkeep.wjdh.common.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.pvkeep.wjdh.activity.R;
import com.pvkeep.wjdh.adapter.WelcomeAdapter;

/**
 * Created by Xiexr on 2016/10/18.
 */
public class WelcomeActivity extends Activity {

    private ViewPager mViewPager;
    private int[] images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_layout);

        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        images[0] = R.mipmap.welcom_icon1;
        images[1] = R.mipmap.welcom_icon2;
        images[2] = R.mipmap.welcom_icon3;

        mViewPager.setAdapter(new WelcomeAdapter(this, images));
    }
}
