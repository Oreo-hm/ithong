package com.trungthanh.example.ithong.repository

import androidx.room.Dao
import androidx.room.Query

@Dao
interface BookmarkTypeDao {
    @Query("SELECT * FROM TABLE_BOOKMARK_TYPE")
    fun getAllBookmarkType(): List<BookmarkType>
}