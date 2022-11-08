package com.oldspeccy.composetest.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DataItemDao {
    @Query("SELECT * FROM SampleData")
    fun getItemList(): LiveData<List<DataItem>>

    @Insert
    suspend fun insertItem(dataItem: DataItem)
}