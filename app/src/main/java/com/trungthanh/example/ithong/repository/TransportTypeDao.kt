package com.trungthanh.example.ithong.repository

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
interface TransportTypeDao {
    @Query("SELECT * FROM TABLE_TRANSPORT_TYPE")
    fun getAllTransportType(): LiveData<List<TransportType>>

    @Query("SELECT * FROM TABLE_TRANSPORT_TYPE WHERE Type_ID = :typeID")
    fun getTransportTypeFromId(typeID: Int): LiveData<TransportType>
}