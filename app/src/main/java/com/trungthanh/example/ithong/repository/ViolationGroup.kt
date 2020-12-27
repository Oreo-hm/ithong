package com.trungthanh.example.ithong.repository

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "TABLE_VIOLATION_GROUP", primaryKeys = ["Group_ID"])
data class ViolationGroup(
    @ColumnInfo(name ="Group_ID") val groupID: Int?,
    @ColumnInfo(name ="Group_Name") val groupName: String?,
    @ColumnInfo(name ="Group_Sort") val  groupSort: Int?,
    @ColumnInfo(name ="Type_Value") val typeValue :Int?,
    @ColumnInfo(name ="Icon") val icon: String?,
    @ColumnInfo(name ="IsDelete") val isDelete: Int?,
    @ColumnInfo(name ="Tag") val tag: String?
)