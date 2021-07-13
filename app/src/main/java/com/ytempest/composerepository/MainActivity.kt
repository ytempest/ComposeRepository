package com.ytempest.composerepository

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ytempest.composerepository.list.ListActivity
import com.ytempest.composerepository.ui.theme.ComposeRepositoryTheme
import com.ytempest.composerepository.utils.ActivityUtils

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeRepositoryTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MainContent(MainActivity@ this)
                }
            }
        }
    }
}

@Composable
private fun MainContent(activity: MainActivity) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ListContent(activity)
        }
    }
}

@Composable
private fun ListContent(activity: MainActivity) {
    Button("List") { ActivityUtils.startActivity(activity, ListActivity::class) }
}

@Composable
private fun Button(text: String, onClick: () -> Unit) {
    Button(
        modifier = Modifier
            .padding(horizontal = 50.dp, vertical = 5.dp)
            .fillMaxWidth()
            .height(60.dp),
        onClick = onClick
    ) {
        Text(text = text)
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
}
