package com.example.zhihuibeijing.util

import android.content.Context

/**
 * sharedPreferences帮助类
 */
class PrefUtil {
    companion object {
        fun getBoolean(context: Context, key: String, defValue: Boolean = false): Boolean {
            var sharedPreferences = context.getSharedPreferences("config", Context.MODE_PRIVATE)
            return sharedPreferences.getBoolean(key, defValue)
        }

        fun setBoolean(context: Context, key: String, value: Boolean) {
            var sharedPreferences = context.getSharedPreferences("config", Context.MODE_PRIVATE)
            sharedPreferences.edit().putBoolean(key, value).commit()

        }

        fun getInt(context: Context, key: String, defValue: Int = 0): Int {
            var sharedPreferences = context.getSharedPreferences("config", Context.MODE_PRIVATE)
            return sharedPreferences.getInt(key, defValue)
        }

        fun setInt(context: Context, key: String, value: Int) {
            var sharedPreferences = context.getSharedPreferences("config", Context.MODE_PRIVATE)
            sharedPreferences.edit().putInt(key, value).commit()
        }

        fun getString(context: Context, key: String, defValue: String = ""): String? {
            var sharedPreferences = context.getSharedPreferences("config", Context.MODE_PRIVATE)
            return sharedPreferences.getString(key, defValue)
        }

        fun setString(context: Context, key: String, value: String) {
            var sharedPreferences = context.getSharedPreferences("config", Context.MODE_PRIVATE)
            sharedPreferences.edit().putString(key, value).commit()
        }
    }
}