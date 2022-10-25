package com.oldspeccy.composetest

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class TestViewModel: ViewModel() {

    val data = mutableStateListOf("A","B")
    val count = mutableStateOf(0)

}
