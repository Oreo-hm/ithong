package com.trungthanh.example.ithong.repository

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "TABLE_VIOLATION_RELATION", primaryKeys = ["ID"])
data class ViolationRelation(
    @ColumnInfo(name ="ID") val id: Int?,
    @ColumnInfo(name ="Violation_ID") val violationID: Long?,
    @ColumnInfo(name ="R_Violation_ID") val rViolationID: Long?,
    @ColumnInfo(name ="Relation_Type") val relationType: Int?,
    @ColumnInfo(name ="UpdateDay") val updateDay: String?,
    @ColumnInfo(name ="IsDelete") val isDelete: Int?
)