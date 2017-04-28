package com.xiaoming.slience.fragment;

import android.view.View;
import android.widget.TextView;

import com.xiaoming.slience.base.BaseFragment;

/**
 * @author Slience_Manager
 * @time 2017/4/28 9:59
 */

public class HotNewsFragment extends BaseFragment {

    @Override
    public View initView() {
        TextView tv= new TextView(mActivity);
        tv.setText("热点新闻");
        return tv;
    }

    @Override
    public void initData() {

    }
}
