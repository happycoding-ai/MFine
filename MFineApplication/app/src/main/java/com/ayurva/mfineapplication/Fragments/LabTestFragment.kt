package com.ayurva.mfineapplication.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.ayurva.mfineapplication.MainActivity
import com.ayurva.mfineapplication.R
import com.ayurva.mfineapplication.databinding.FragmentExploreBinding
import com.ayurva.mfineapplication.databinding.FragmentLabTestBinding


class LabTestFragment : Fragment(R.layout.fragment_lab_test) {

    private var _binding: FragmentLabTestBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentLabTestBinding.bind(view)

        loadSource()

        binding.ibBackLabTest.setOnClickListener{
            val intent= Intent(context, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun loadSource() {

        Glide.with(binding.newLaunch).load("https://i.postimg.cc/J0YKJtWQ/new-launch.jpg").into(binding.newLaunch)
        Glide.with(binding.bodyCheck).load("https://i.postimg.cc/02rVvGpX/body-check.jpg").into(binding.bodyCheck)
        Glide.with(binding.pcrTest).load("https://i.postimg.cc/FscmvPwD/pcr-test.jpg").into(binding.pcrTest)
        Glide.with(binding.carePlush).load("https://i.postimg.cc/C5xmzk91/care-plush.jpg").into(binding.carePlush)
     //   Glide.with(advance_full_body_check).load("https://i.postimg.cc/q7wjJ9Kd/advance-full-body-check.jpg").into(advance_full_body_check)
      // Glide.with(covid_test).load("https://i.postimg.cc/zvbjkvcJ/covide-test.jpg").into(covid_test)
     //   Glide.with(men_body_check).load("https://i.postimg.cc/zBfpV0wH/men-body-check.jpg").into(men_body_check)
//        Glide.with(women_body_check).load("https://i.postimg.cc/KzsfLBQq/women-body-check.jpg").into(women_body_check)
    }

}
/**
Glide template=>    Glide.with().load().into()
 */