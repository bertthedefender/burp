package com.oldspeccy.composetest

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.oldspeccy.composetest.model.DataItem
import com.oldspeccy.composetest.model.DemoDatabase
import com.oldspeccy.composetest.model.DemoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TestViewModel(application: Application) : AndroidViewModel(application) {

    val allData: LiveData<List<DataItem>>
    private val repository: DemoRepository

    init {
        val dao = DemoDatabase.getInstance(application).dataItemDao()
        repository = DemoRepository(dao)
        allData = repository.allData
    }

    fun insert(dataItem: DataItem) {
        viewModelScope.launch(Dispatchers.IO)
        {
            repository.insert(dataItem)
        }
    }

}
