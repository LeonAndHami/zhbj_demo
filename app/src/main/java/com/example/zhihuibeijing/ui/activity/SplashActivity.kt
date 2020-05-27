package com.example.zhihuibeijing.ui.activity

import android.view.animation.*
import com.example.zhihuibeijing.R
import com.example.zhihuibeijing.base.BaseActivity
import com.example.zhihuibeijing.util.PrefUtil
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : BaseActivity() {

    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }

    override fun initData() {

        //ViewCompat 实现动画，目前没有发现设置开始值，需要在布局文件中设置各种属性开始值，简单但不灵活
        //ViewCompat.animate(rl_root).rotation(360f).scaleX(1f).scaleY(1f).alpha(1f).duration = 2000
        animations()


    }

    fun animations() {
        //代码量多但容易操作
        //旋转动画
        var rotateAni = RotateAnimation(
            0f,
            360f,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        )
        rotateAni.duration = 1000 //时间
        rotateAni.fillAfter = true //保留动画效果

        //缩放动画
        var scaleAni = ScaleAnimation(
            0f,
            1f,
            0f,
            1f,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        )
        scaleAni.duration = 1000
        scaleAni.fillAfter = true

        //渐变动画
        var alphaAni = AlphaAnimation(0f, 1f)
        alphaAni.duration = 2000
        alphaAni.fillAfter = true;

        var set = AnimationSet(true) //插补器是否共享加速度
        set.addAnimation(rotateAni)
        set.addAnimation(scaleAni)
        set.addAnimation(alphaAni)

        //监听动画事件
        set.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                //跳转，如果首次，跳引导界面，否则跳首页

                var isFirstEnter = PrefUtil.getBoolean(applicationContext, "is_first_enter", true)
                when (isFirstEnter) {
                    true -> {
                        startActivityAndFinish<GuideActivity>()
                        PrefUtil.setBoolean(applicationContext, "is_first_enter", true)
                    }
                    else -> startActivityAndFinish<MainActivity>()
                }
            }

            override fun onAnimationStart(animation: Animation?) {

            }
        })
        //启动
        rl_root.startAnimation(set)

    }


}
