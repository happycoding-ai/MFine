package com.ayurva.mfineapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ayurva.mfineapplication.databinding.ActivityAppointmentConfirmationBinding

class AppointmentConfirmationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAppointmentConfirmationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppointmentConfirmationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvPatientName.text = intent.getStringExtra("name")
        binding.tvPatientEmail.text = intent.getStringExtra("address")
        binding.tvPatientContactNo.text = intent.getStringExtra("mobile")

        binding.btnOk.setOnClickListener {
            Toast.makeText(this, "Your application received", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
