package com.trungthanh.example.ithong.ui.models

import com.trungthanh.example.ithong.repository.Violation

class ViolationUI (
    val violation: Violation,
    val onClick:() -> Unit
)