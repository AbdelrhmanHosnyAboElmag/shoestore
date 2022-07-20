package com.example.shoestore.cachememory

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

private const val KEY_LOGIN = "LOGIN"

class Cahce(context: Context) {
    private val context = context.applicationContext
    private val preference: SharedPreferences
        get() = PreferenceManager.getDefaultSharedPreferences(
            context
        )
    fun checkLog(check:Boolean){
        preference.edit().putBoolean(KEY_LOGIN,check).apply()
    }

    fun getCheckLog():Boolean?{
        return preference.getBoolean(KEY_LOGIN,false)
    }
}