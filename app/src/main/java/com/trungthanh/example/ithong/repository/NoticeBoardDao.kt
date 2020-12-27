package com.trungthanh.example.ithong.repository

import androidx.room.Dao
import androidx.room.Query

@Dao
interface NoticeBoardDao {
    @Query("SELECT * FROM TABLE_NOTICE_BOARD")
    fun getAllNoticeBoard(): List<NoticeBoard>
}