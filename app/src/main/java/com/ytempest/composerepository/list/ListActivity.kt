package com.ytempest.composerepository.list

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.lifecycle.ViewModelProvider
import com.ytempest.composerepository.list.ui.MainContent
import com.ytempest.composerepository.list.ui.theme.ComposeRepositoryTheme

class ListActivity : ComponentActivity() {

    private val listVM by lazy { ViewModelProvider(this).get(ListViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeRepositoryTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MainContent(listVM)
                }
            }
        }
    }
}