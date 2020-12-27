package com.trungthanh.example.ithong.repository

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
interface ViolationDao {

    @Query("SELECT * FROM TABLE_VIOLATION")
    fun getALlViolation(): LiveData<List<Violation>>

    @Query("SELECT * FROM TABLE_VIOLATION WHERE ID = :id")
    fun getViolation(id: Int) : LiveData<Violation>

    @Query("SELECT * FROM TABLE_VIOLATION WHERE Group_ID LIKE :groupID")
    fun getViolationFromId(groupID :Int): LiveData<List<Violation>>

}