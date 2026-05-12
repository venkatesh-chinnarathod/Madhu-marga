package com.example.madhu_marga.models

data class HiveLog(
    val hiveId: String = "",
    val location: String = "",
    val queenPresent: Boolean = false,
    val activityLevel: String = "",
    val pestsSeen: Boolean = false,
    val honeyQty: Double = 0.0,
    val timestamp: Long = System.currentTimeMillis()
)