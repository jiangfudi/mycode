package com.qianfeng.zhushou.gift.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qianfeng.zhushou.R;
import com.qianfeng.zhushou.gift.adapter.GiftPagerAdapter;
import com.qianfeng.zhushou.other.ui.BaseFragment;
import com.qianfeng.zhushou.other.utils.ZhuShouHttpUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 礼包页面
 *
 * Created by Liu Jianping
 *
 * @date : 16/1/12.
 */
public class GiftFragment extends BaseFragment
{

    private ViewPager vpContent;
    private GiftPagerAdapter pagerAdapter;

    @Override
    protected int getLayout()
    {
        return R.layout.fragment_gift;
    }

    @Override
    protected void initViews()
    {
        vpContent = (ViewPager) root.findViewById(R.id.gift_type_vp);
    }

    @Override
    protected void initEvents()
    {

    }

    @Override
    protected void initData()
    {

        GiftListFragment mobileListFragment = new GiftListFragment();
        List<Fragment> list = new ArrayList<>();
        list.add(mobileListFragment);
        pagerAdapter = new GiftPagerAdapter(getFragmentManager(), list);

        vpContent.setAdapter(pagerAdapter);

    }
}
