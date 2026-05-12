package com.example.madhu_marga.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hives")
data class Hive(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val hiveId: String, // Tag ID 
    val location: String, // Location 
    val queenPresent: Boolean, // Inspection Log
    val activityLevel: String, // "Low", "Medium", "High"
    val honeyQuantity: Double, // Harvest Tracker
    val pestsSeen: Boolean, // Hive Health
    val timestamp: Long = System.currentTimeMillis()
)
