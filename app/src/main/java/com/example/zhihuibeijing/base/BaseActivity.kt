package com.example.zhihuibeijing.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

abstract class BaseActivity : AppCompatActivity(), AnkoLogger {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initListener()
        initData()
    }

    /**
     * 初始化数据
     */
    protected open fun initData() {

    }

    /**
     * 初始化listener
     */
    protected open fun initListener() {

    }

    protected fun myToast(msg: String) {
        runOnUiThread { toast(msg) }
    }


    abstract fun getLayoutId(): Int

    /**
     * 跳转页面并关闭当前页
     */
    inline fun <reified T : BaseActivity> startActivityAndFinish() {
        startActivity<T>()
        finish()
    }


}