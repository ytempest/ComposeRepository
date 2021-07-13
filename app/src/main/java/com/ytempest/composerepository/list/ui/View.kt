package com.ytempest.composerepository.list.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.coil.rememberCoilPainter
import com.ytempest.composerepository.Entity
import com.ytempest.composerepository.list.DataHelper
import com.ytempest.composerepository.list.ListViewModel
import com.ytempest.composerepository.list.observeAsState
import com.ytempest.composerepository.list.ui.theme.ComposeRepositoryTheme

/**
 * @author qiduhe
 * @since 2021/7/13
 */

@Composable
fun MainContent(listVM: ListViewModel) {
    Column() {
        Header(listVM)
        FeedFlow(click = {

        })
    }
}

@Composable
fun Header(viewModel: ListViewModel) {
    val name: String by viewModel.name.observeAsState("")
    InputUI(name = name, onNameChanged = { viewModel.onNameChanged(it) })
}

@Composable
private fun InputUI(name: String, onNameChanged: (String) -> Unit) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        if (name.isNotEmpty()) {
            Text(
                text = "Hello,${name}",
                fontWeight = FontWeight(100),
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .wrapContentHeight(),
                style = MaterialTheme.typography.h5
            )
        }
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            value = name,
            onValueChange = onNameChanged,
            label = { Text("name") }
        )
    }
}

@Composable
fun FeedFlow(list: List<Entity> = DataHelper.createList(), click: (Entity) -> Unit) {
    LazyColumn {
        items(list, key = { it.pid }) {
            FeedItem(data = it, click = click)
        }

    }
}

@Composable
fun FeedItem(data: Entity, click: (Entity) -> Unit) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 5.dp,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(5.dp)
            .clickable {
                click.invoke(data)
            }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            Column() {
                Text(text = data.projName)
                Text(text = data.marketingInfo)
            }
            Spacer(modifier = Modifier.weight(1F))
            Image(
                painter = rememberCoilPainter(request = data.url),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(60.dp)
                    .height(60.dp)
                    .clip(shape = RoundedCornerShape(8.dp))
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewMainContent() {
    ComposeRepositoryTheme {
        MainContent(listVM = ListViewModel())
    }
}