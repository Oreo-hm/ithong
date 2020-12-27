package com.trungthanh.example.ithong.repository

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
interface BookmarkDao {
    @Query("SELECT * FROM TABLE_BOOKMARK")
    fun getAllBookmark():
            List<Bookmark>
    @Query("SELECT * FROM TABLE_BOOKMARK WHERE ID = :BookmarkID")
    fun getBookmarkFromID(BookmarkID : Int): LiveData<Bookmark>
}