package com.example.zhihuibeijing.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter

class GuideAdapter() : PagerAdapter() {
    lateinit var datas: ArrayList<ImageView>


// PagerAdapter 一般不需要更新数据，需要更新数据的adapter再考虑用此方法
//    fun updateData(list: ArrayList<ImageView>) {
//        this.list.clear()
//        this.list.addAll(list)
//        notifyDataSetChanged()
//    }

    override fun isViewFromObject(view: View, `object`: Any) = view == `object`  //返回值固定写法

    override fun getCount() = datas.size

    /**
     * 初始化item
     */
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        container.addView(datas[position])
        return datas[position]
    }

    /**
     * 销毁item
     */
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

}