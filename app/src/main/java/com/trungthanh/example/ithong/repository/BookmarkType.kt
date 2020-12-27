package com.trungthanh.example.ithong.repository

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "TABLE_BOOKMARK_TYPE", primaryKeys = ["Type_ID"])
data class BookmarkType(
    @ColumnInfo(name ="Type_ID") val typeID: Int?,
    @ColumnInfo(name ="Type_Name") val typeName : String?,
    @ColumnInfo(name ="IsDelete") val isDelete: Int?
)