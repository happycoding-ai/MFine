package com.ayurva.mfineapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ayurva.mfineapplication.databinding.ActivityConsultNowBinding
import com.ayurva.mfineapplication.databinding.ActivityEditProfileBinding

class EditProfile : AppCompatActivity() {

    private lateinit var binding: ActivityEditProfileBinding

    private var sex:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        btnSave.setOnClickListener {
//            when (rgSex.checkedRadioButtonId) {
//                R.id.radioMale -> {
//                    ivProfileImage.setImageResource(R.drawable.man)
//                    displayToast("male")
//                }
//                R.id.radioFemale -> {
//                    ivProfileImage.setImageResource(R.drawable.woman)
//                    displayToast("female")
//                }
//                R.id.rbOthers -> {
//                    ivProfileImage.setImageResource(R.drawable.other)
//                    displayToast("others")
//                }
//            }
//        }

        //back button
        binding.cdProfileBack.setOnClickListener {
                val intent= Intent(baseContext,MainActivity::class.java)
                startActivity(intent)
        }

        binding.btnSave.setOnClickListener{
            Toast.makeText(baseContext,"Data Saved Successfully",Toast.LENGTH_SHORT).show()
            val intent= Intent(baseContext,MainActivity::class.java)
            startActivity(intent)
        }



        binding.radioMale.setOnClickListener {
            binding.ivProfileImage.setImageResource(R.drawable.man)
        }

        binding.radioFemale.setOnClickListener {
            binding.ivProfileImage.setImageResource(R.drawable.woman)
        }

        binding.radioOthers.setOnClickListener {
            binding.ivProfileImage.setImageResource(R.drawable.other)
        }

    }

    private fun displayToast(radio: String) {
        Toast.makeText(this, radio, Toast.LENGTH_SHORT).show()
    }

}