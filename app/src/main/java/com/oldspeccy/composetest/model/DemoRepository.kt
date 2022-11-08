package com.oldspeccy.composetest.model

import androidx.lifecycle.LiveData

class DemoRepository(private val dataItemDao: DataItemDao) {
    suspend fun insert(dataItem: DataItem) {
        dataItemDao.insertItem(dataItem)
    }

    val allData: LiveData<List<DataItem>> = dataItemDao.getItemList()
}
