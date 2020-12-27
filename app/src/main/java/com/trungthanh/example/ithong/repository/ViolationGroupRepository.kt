package com.trungthanh.example.ithong.repository

import androidx.lifecycle.LiveData

class ViolationGroupRepository(private val violationGroupDao: ViolationGroupDao) {
    fun getAllViolationGroupUI(): LiveData<List<ViolationGroup>> = violationGroupDao.getAllViolationGroup()
    fun getViolationGroupFromGroupID(groupID : Int) : LiveData<ViolationGroup> = violationGroupDao.getViolationGroupID(groupID)
}