package com.oldspeccy.composetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import com.oldspeccy.composetest.model.DataItem
import com.oldspeccy.composetest.viewmodel.TestViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val vm: TestViewModel by viewModels()

        setContent {
            MainScreen(vm)
        }
    }
}


@Composable
fun MainScreen(vm: TestViewModel) {

    val dataItems = vm.allData.observeAsState(listOf()).value

    Column {
        LazyColumn {
            items(items = dataItems) { dataItem ->
                DataDetailItem(data = dataItem.name)
            }
        }
        Button(onClick = {
            var v: Int = dataItems.size
            v = v.inc()
            vm.insert(DataItem(0, "XX $v", v))
        }) {
            Text(text = "Click")
        }
    }

}

@Composable
fun DataDetailItem(data: String) {
    Text(text = data)
}