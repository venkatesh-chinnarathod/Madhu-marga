package com.example.madhumarga.models

data class HiveLog(
    val hiveId: String = "",         // Hive Register [cite: 15]
    val location: String = "",       // Hive Register [cite: 15]
    val queenPresent: Boolean = false, // Inspection Log [cite: 16]
    val activityLevel: String = "",  // "Low", "Medium", "High" [cite: 29]
    val pestsSeen: Boolean = false,  // Hive Health [cite: 7]
    val honeyQty: Double = 0.0,      // Harvest Tracker [cite: 17]
    val timestamp: Long = System.currentTimeMillis()
)