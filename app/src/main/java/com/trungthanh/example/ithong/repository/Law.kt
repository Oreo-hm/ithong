package com.trungthanh.example.ithong.repository

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "TABLE_LAW", primaryKeys = ["Law_ID"])
data class Law(
    @ColumnInfo(name ="Law_ID") val lawID: Int?,
    @ColumnInfo(name ="Law_Name") val lawName: String?,
    @ColumnInfo(name ="Law_Url") val lawUrl: String?,
    @ColumnInfo(name ="Law_Content") val lawContent: String?,
    @ColumnInfo(name ="UpdateDay") val updateDay: String?,
    @ColumnInfo(name = "IsDelete") val isDelete: Int?
)