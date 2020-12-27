package com.trungthanh.example.ithong.repository

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "TABLE_NOTICE_BOARD_TYPE", primaryKeys = ["Type_ID"])
data class NoticeBoardType(
    @ColumnInfo(name ="Type_ID") val typeID: Int?,
    @ColumnInfo(name ="Type_Name") val typeName : String?,
    @ColumnInfo(name ="Icon") val icon: String?,
    @ColumnInfo(name ="IsDelete") val isDelete : Int?
)