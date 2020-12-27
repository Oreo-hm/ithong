package com.trungthanh.example.ithong.repository

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "TABLE_KEYWORD", primaryKeys = ["ID"])
data class Keyword(
    @ColumnInfo(name = "ID") val id: Int?,
    @ColumnInfo(name = "Name") val name: String?,
    @ColumnInfo(name = "NameEN") val nameEn: String?,
    @ColumnInfo(name = "UpdateDay") val updateDay: String?,
    @ColumnInfo(name = "IsDelete") val isDelete: Int?
)