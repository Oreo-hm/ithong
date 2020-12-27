package com.trungthanh.example.ithong.repository

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
interface NoticeBoardTypeDao {
    @Query("SELECT * FROM TABLE_NOTICE_BOARD_TYPE")
    fun  getALlNoticeBoardType(): List<NoticeBoardType>

    @Query("SELECT * FROM TABLE_NOTICE_BOARD_TYPE WHERE Type_ID = :typeID")
    fun getNoticeBoardTypeFromID(typeID: Int): LiveData<NoticeBoardType>
}