package com.trungthanh.example.ithong.repository

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
interface LawDao {
    @Query("SELECT * FROM TABLE_LAW")
    fun getAllLaws(): List<Law>

    @Query("SELECT * FROM TABLE_LAW WHERE Law_ID= :lawID")
    fun getLawFromID(lawID: Int): LiveData<Law>
}