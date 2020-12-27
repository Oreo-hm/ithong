package com.trungthanh.example.ithong.repository

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "TABLE_TRANSPORT_TYPE", primaryKeys = ["Type_ID"])
data class TransportType(
    @ColumnInfo(name ="Type_ID") val typeID: Int?,
    @ColumnInfo(name ="Type_Name") val typeName: String?,
    @ColumnInfo(name ="Type_Sort") val typeSort: Int?,
    @ColumnInfo(name ="Type_Value") val typeValue: Int?,
    @ColumnInfo(name ="Icon") val icon : String?,
    @ColumnInfo(name = "IsDelete") val isDelete: Int?
)