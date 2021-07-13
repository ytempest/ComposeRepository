package com.ytempest.composerepository.banner

import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

/**
 * @author qiduhe
 * @since 2021/7/8
 */

@Composable
fun <T : BaseBannerBean> BannerCard(
    bean: T,
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(10.dp),
    onBannerClick: () -> Unit,
) {

    if (bean.data == null) {
        throw NullPointerException("Url or imgRes or filePath must have a not for empty")
    }

    Card(
        shape = shape,
        modifier = modifier
    ) {
        val imgModifier = Modifier.clickable(onClick = onBannerClick)
        when (bean.data) {
            is String -> {
                val img = bean.data as String
                if (img.contains("https://") || img.contains("http://")) {

                }
            }
        }
    }
}