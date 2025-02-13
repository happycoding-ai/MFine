package com.ayurva.mfineapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ayurva.mfineapplication.databinding.ActivityMainBinding
import com.ayurva.mfineapplication.databinding.ActivityOrderMedicineBinding

class OrderMedicineActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOrderMedicineBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderMedicineBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.backToHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

}
