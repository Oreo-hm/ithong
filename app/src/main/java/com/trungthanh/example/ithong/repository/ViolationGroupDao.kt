package com.trungthanh.example.ithong.repository

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
interface ViolationGroupDao {
   @Query("SELECT * FROM TABLE_VIOLATION_GROUP")
    fun getAllViolationGroup(): LiveData<List<ViolationGroup>>

    @Query("SELECT * FROM TABLE_VIOLATION_GROUP WHERE Group_ID = :groupID ")
    fun getViolationGroupID(groupID: Int) : LiveData<ViolationGroup>
}