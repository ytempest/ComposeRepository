package com.ytempest.composerepository.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import kotlin.reflect.KClass

/**
 * @author qiduhe
 * @since 2021/7/13
 */
object ActivityUtils {
    fun startActivity(context: Context, clazz: KClass<out Activity>) {
        val intent = Intent(context, clazz.java)
        context.startActivity(intent)
    }
}