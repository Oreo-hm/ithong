package com.trungthanh.example.ithong.repository

import androidx.lifecycle.LiveData

class ViolationRepository (private val violationDao: ViolationDao) {
    fun getAllViolation(): LiveData<List<Violation>> = violationDao.getALlViolation()
    fun getAllViolationWithId(groupId: Int) : LiveData<List<Violation>> = violationDao.getViolationFromId(groupId)
    fun getViolation(id: Int): LiveData<Violation> = violationDao.getViolation(id)

}