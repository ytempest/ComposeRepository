package com.ytempest.composerepository.banner

/**
 * @author qiduhe
 * @since 2021/7/8
 */
data class BannerBean(
    override val data: Any?
) : BaseBannerBean()

abstract class BaseBannerBean {
    // 图片资源 可以是：url、文件路径或者是 drawable id
    abstract val data: Any?
}