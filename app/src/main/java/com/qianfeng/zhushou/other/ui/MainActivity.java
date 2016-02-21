package com.qianfeng.zhushou.other.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.qianfeng.zhushou.R;
import com.qianfeng.zhushou.other.utils.JumpManager;
import com.qianfeng.zhushou.other.utils.ZhuShouContants;

/**
 * 主页面
 */
public class MainActivity extends Activity
{

    private ImageView ivIcon, ivLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // 如果是第一次使用该应用，那么跳转到引导页
        if (isFirstUsed())
        {
            Intent intent = new Intent(this, GuideActivity.class);
            startActivity(intent);
            finish();
        }
        // 否则进到主页面
        else
        {
            setContentView(R.layout.activity_main);

            ivIcon = (ImageView) findViewById(R.id.main_icon_iv);
            ivLabel = (ImageView) findViewById(R.id.main_label_iv);

            // 初始化label和icon的动画
            Animation labelAnim = AnimationUtils.loadAnimation(this,
                    R.anim.anim_main_label_in);
            final Animation iconAnim = AnimationUtils.loadAnimation(this,
                    R.anim.anim_main_icon_in);

            // 分别设置动画的监听
            labelAnim.setAnimationListener(new Animation.AnimationListener()
            {
                @Override
                public void onAnimationStart(Animation animation)
                {

                }

                @Override
                public void onAnimationEnd(Animation animation)
                {
                    // 在label动画结束后再执行icon的动画
                    ivIcon.startAnimation(iconAnim);
                }

                @Override
                public void onAnimationRepeat(Animation animation)
                {

                }
            });

            iconAnim.setAnimationListener(new Animation.AnimationListener()
            {
                @Override
                public void onAnimationStart(Animation animation)
                {

                }

                @Override
                public void onAnimationEnd(Animation animation)
                {
                    // 在icon动画结束后显示icon
                    ivIcon.setVisibility(View.VISIBLE);
                    //跳转到主页面
                    JumpManager.jumpToHome(MainActivity.this);
                    //当前页面已经不需要了
                    finish();
                }

                @Override
                public void onAnimationRepeat(Animation animation)
                {

                }
            });
            ivLabel.startAnimation(labelAnim);
        }

    }

    private boolean isFirstUsed()
    {
        SharedPreferences preferences = getSharedPreferences(
                ZhuShouContants.PERFERENCE_FIRST_USED, Context.MODE_PRIVATE);
        return preferences.getBoolean(ZhuShouContants.PERFERENCE_FLAG_USED,
                true);
    }

}
