package com.trungthanh.example.ithong.repository

import androidx.room.Dao
import androidx.room.Query

@Dao
interface KeywordDao {

    @Query("SELECT * FROM TABLE_KEYWORD")
    fun getAllKeyWord(): List<Keyword>
}