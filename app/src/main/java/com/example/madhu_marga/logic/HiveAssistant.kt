package com.example.madhu_marga.logic

class HiveAssistant {
    // Generates an "Intervention Alert" based on logs
    fun getIntervention(activity: String, pests: Boolean): String {
        return when {
            pests -> "ALERT: Mites/Pests detected! Treat immediately."
            activity.equals("Low", true) -> "INTERVENTION ALERT: Low Activity. Check Queen health."
            else -> "Hive status is healthy."
        }
    }
}