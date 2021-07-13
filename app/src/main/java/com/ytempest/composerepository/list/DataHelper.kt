package com.ytempest.composerepository.list

import com.ytempest.composerepository.Entity

/**
 * @author qiduhe
 * @since 2021/7/13
 */
object DataHelper {
    fun createList(): MutableList<Entity> {
        val list = mutableListOf<Entity>()
        for (idx in 1..100) {
            val data = Entity().apply {
                pid = idx
                projName = "projName-${idx}"
                marketingInfo = "marketingInfo-${idx}"
                url =
                    "https://img0.baidu.com/it/u=1207346838,1773850188&fm=26&fmt=auto&gp=0.jpg"
            }
            list.add(data)
        }
        return list
    }
}