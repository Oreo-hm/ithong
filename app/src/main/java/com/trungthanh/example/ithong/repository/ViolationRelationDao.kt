package com.trungthanh.example.ithong.repository

import androidx.room.Dao
import androidx.room.Query

@Dao
interface ViolationRelationDao {
    @Query("SELECT * FROM TABLE_VIOLATION_RELATION")
    fun getAllViolationRelation(): List<ViolationRelation>
}