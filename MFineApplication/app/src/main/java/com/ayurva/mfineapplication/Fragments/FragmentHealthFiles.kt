package com.ayurva.mfineapplication.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.ayurva.mfineapplication.EditProfile
import com.ayurva.mfineapplication.R
import com.ayurva.mfineapplication.databinding.FragmentExploreBinding
import com.ayurva.mfineapplication.databinding.FragmentHealthFilesBinding

class FragmentHealthFiles : Fragment(R.layout.fragment_health_files) {

    private var _binding: FragmentHealthFilesBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inflate the binding object
        _binding = FragmentHealthFilesBinding.bind(view)

        binding.linearEditProfile.setOnClickListener() {
            val intent = Intent(context, EditProfile::class.java)
            startActivity(intent)
        }


        binding.ibEditProfile.setOnClickListener() {
            val intent = Intent(context, EditProfile::class.java)
            startActivity(intent)
        }


        binding.tvConsultationHealth.setOnClickListener {
            Toast.makeText(context, "Consultation | Work in Process", Toast.LENGTH_SHORT).show()
        }

        binding.tvHealthPrescription.setOnClickListener {
            Toast.makeText(context, "Prescription | Work in Process", Toast.LENGTH_SHORT).show()
        }
        binding.tvAttachmentReportHealth.setOnClickListener {
            Toast.makeText(
                context,
                "Attachment and Report Health | Work in Process",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.tvRemainderHealth.setOnClickListener {
            Toast.makeText(context, "Remainder | Work in Process", Toast.LENGTH_SHORT).show()

        }
        binding.tvMedicalHistoryHealth.setOnClickListener {
            Toast.makeText(context, "Medical History | Work in Process", Toast.LENGTH_SHORT).show()

        }

        binding.tvSubscriptionHealth.setOnClickListener {
            Toast.makeText(context, "Subscription | Work in Process", Toast.LENGTH_SHORT).show()

        }

        binding.tvLabParameters.setOnClickListener {
            Toast.makeText(context, "Lab Parameters | Work in Process", Toast.LENGTH_SHORT).show()

        }

//        tvEditProfileHealth.setOnClickListener {
//            Toast.makeText(context, "Edit Profile | Work in Process", Toast.LENGTH_SHORT).show()
//
//        }
    }

}