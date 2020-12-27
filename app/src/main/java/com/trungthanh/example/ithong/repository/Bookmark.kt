package com.trungthanh.example.ithong.repository

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "TABLE_BOOKMARK", primaryKeys = ["ID"])
data class Bookmark(
    @ColumnInfo(name = "ID") val id : Int?,
    @ColumnInfo(name = "Type_ID") val typeId : Int?,
    @ColumnInfo(name = "Violation_ID") val violationID: Int?,
    @ColumnInfo(name = "Bookmark_ID") val bookmarkID: Int?,
    @ColumnInfo(name = "Bookmark_Code") val bookmarkCode: String?,
    @ColumnInfo(name = "Bookmark_Name") val bookmarkName: String?,
    @ColumnInfo(name = "Law_ID") val lawID: Int?,
    @ColumnInfo(name = "UpdateDay") val UpdateDay: String?,
    @ColumnInfo(name = "IsDelete") val isDelete: Int?
)