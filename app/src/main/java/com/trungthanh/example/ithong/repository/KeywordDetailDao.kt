package com.trungthanh.example.ithong.repository

import androidx.room.Dao
import androidx.room.Query

@Dao
interface KeywordDetailDao {
    @Query("SELECT * FROM TABLE_KEYWORD_DETAIL")
    fun getAllKeywordDetail(): List<KeywordDetail>
}