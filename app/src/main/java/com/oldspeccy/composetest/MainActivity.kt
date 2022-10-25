package com.oldspeccy.composetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainScreen()
        }
    }
}


@Composable
fun MainScreen(vm: TestViewModel = viewModel()) {

    var v:Int by vm.count

    Column{
        LazyColumn {
            items(items = vm.data) {
                DataItem(it)
            }
        }
        Button(onClick = {
            v = v.inc()
            vm.data.add("XX $v")
        }) {
            Text(text = "Click")
        }
    }

}

@Composable
fun DataItem(data:String) {
    Text(text = data)
}