package com.pvkeep.wjdh.worker.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pvkeep.wjdh.activity.R;

/**
 * Created by Admin on 2016/10/15.
 */
public class WorkerFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.work_fragment, null, false);
        TextView tv = (TextView) view.findViewById(R.id.tex_title);
        tv.setText("工作台");
        return view;
    }
}
