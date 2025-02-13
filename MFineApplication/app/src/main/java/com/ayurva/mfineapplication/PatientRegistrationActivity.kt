package com.ayurva.mfineapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ayurva.mfineapplication.databinding.ActivityOrderMedicineBinding
import com.ayurva.mfineapplication.databinding.ActivityPatientRegistrationBinding

class PatientRegistrationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPatientRegistrationBinding

    var isNameValid = false
    var isEmailValid = false
    var isPhoneValid = false
    var isPasswordValid = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPatientRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.register.setOnClickListener {
            launchConfirmation()
        }
    }

//    private fun SetValidation(): Boolean {
//        // Check for a valid name
//        if (name?.text.toString().isEmpty()) {
//            name.error = "Enter name"
//            isNameValid = false
//        } else {
//            isNameValid = true
//           name.isEnabled = false
//        }
//
//
//        // Check for a valid phone number
//        if (phone?.text.toString().isEmpty()) {
//            phone.error = "Enter Phone"
//            isPhoneValid = false
//        } else {
//            isPhoneValid = true
//            phone.isEnabled = false
//        }
//
//        // Check for a valid password
//        if (address?.text.toString().isEmpty()) {
//            address.error = "Enter address"
//            isPasswordValid = false
//        } else {
//            isPasswordValid = true
//            address.isEnabled = false
//        }
//
//        return false
//    }
    private fun launchConfirmation(){
                Toast.makeText(applicationContext, "Your Appointment Booked", Toast.LENGTH_SHORT).show()
                val intent1 = Intent(this,AppointmentConfirmationActivity::class.java)
                intent1.putExtra("name", binding.etAppointName.text.toString())
                intent1.putExtra("address", binding.etAppointAddress.text.toString())
                intent1.putExtra("mobile", binding.etAppointNumber.text.toString())
                startActivity(intent1)
    }
}

