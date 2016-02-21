package com.qianfeng.zhushou.other.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

import com.qianfeng.zhushou.R;
import com.qianfeng.zhushou.active.ui.ActiveFragment;
import com.qianfeng.zhushou.exchange.ui.ExchangeFragment;
import com.qianfeng.zhushou.gift.ui.GiftFragment;
import com.qianfeng.zhushou.my.ui.MyFragment;
import com.qianfeng.zhushou.profit.ui.ProfitFragment;

/**
 * 
 * 主页面
 * 
 * Created by Liu Jianping
 *
 * @date : 16/1/11.
 */
public class HomeActivity extends FragmentActivity
{
    private Fragment[] fragments;

    private FrameLayout flContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);

        fragments = new Fragment[]{
                new ProfitFragment(),
                new GiftFragment(),
                new ActiveFragment(),
                new ExchangeFragment(),
                new MyFragment()
        };

        flContent = (FrameLayout) findViewById(R.id.home_content_fl);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        for(int i = 0; i < fragments.length; i++)
        {
            Fragment fragment = fragments[i];
            transaction.add(R.id.home_content_fl, fragment);
            transaction.hide(fragment);
        }

        transaction.show(fragments[1]);
        transaction.commit();
    }
}
