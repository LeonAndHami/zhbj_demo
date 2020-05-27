package com.example.zhihuibeijing.ui.activity

import android.widget.ImageView
import com.example.zhihuibeijing.R
import com.example.zhihuibeijing.adapter.GuideAdapter
import com.example.zhihuibeijing.base.BaseActivity
import kotlinx.android.synthetic.main.activity_guide.*
import org.jetbrains.anko.backgroundResource

class GuideActivity : BaseActivity() {
    private val adapter by lazy { GuideAdapter() }
    private val imgIds = intArrayOf(R.mipmap.guide_1, R.mipmap.guide_2, R.mipmap.guide_3)
    private val imageViewList = ArrayList<ImageView>()

    override fun getLayoutId(): Int {
        return R.layout.activity_guide
    }

    override fun initData() {
        //安卓4.0后，titlebar  叫actionbar

        //如果继承Activity，
        // 代码中去actionbar requestWindowFeature(Window.FEATURE_NO_TITLE)，且要在setContentView()方法【前】执行
        //manifest中去actionbar   android:theme="@android:style/Theme.NoTitleBar"

        //如果继承 AppCompatActivity
        //代码中去actionbar  getSupportActionBar().hide()，且要在setContentView()方法【后】执行
        //manifest中去actionbar  android:theme="@style/Theme.AppCompat.Light.NoActionBar"

        imgIds.forEach {
            val imgView = ImageView(this)
            imgView.backgroundResource = it
            imageViewList.add(imgView)
        }
        adapter.datas = imageViewList
        vp_guide.adapter = adapter


    }
}