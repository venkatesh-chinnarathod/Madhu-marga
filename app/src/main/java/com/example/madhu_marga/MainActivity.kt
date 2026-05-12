package com.example.madhu_marga

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.madhu_marga.models.HiveLog
import com.example.madhu_marga.logic.HiveAssistant
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {
    private val db by lazy { FirebaseFirestore.getInstance() }
    private val assistant by lazy { HiveAssistant() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSave = findViewById<Button>(R.id.btnSave)
        val tvAlert = findViewById<TextView>(R.id.tvAlert)

        btnSave.setOnClickListener {
            val log = HiveLog(
                hiveId = findViewById<EditText>(R.id.etHiveId).text.toString(),
                location = findViewById<EditText>(R.id.etLocation).text.toString(),
                activityLevel = findViewById<EditText>(R.id.etActivity).text.toString(),
                pestsSeen = findViewById<CheckBox>(R.id.cbPestsSeen).isChecked,
                queenPresent = findViewById<CheckBox>(R.id.cbQueenPresent).isChecked,
                honeyQty = findViewById<EditText>(R.id.etHoneyQty).text.toString().toDoubleOrNull() ?: 0.0
            )

            // Save to Firebase Firestore
            db.collection("inspections").add(log)
                .addOnSuccessListener {
                    // Trigger Intervention Alert
                    tvAlert.text = assistant.getIntervention(log.activityLevel, log.pestsSeen)
                    Toast.makeText(this, "Diary Updated!", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener { e ->
                    Toast.makeText(this, "Error saving log: ${e.message}", Toast.LENGTH_LONG).show()
                }
        }
    }
}