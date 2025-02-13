package com.ayurva.mfineapplication

import androidx.recyclerview.widget.RecyclerView
import com.ayurva.mfineapplication.databinding.DoctorItemlayoutBinding
import com.bumptech.glide.Glide

class DoctorViewHolder(private val binding: DoctorItemlayoutBinding, private val onClickListener: OnClickListener) :
    RecyclerView.ViewHolder(binding.root) {

    fun setData(doctorModelList: DoctorModel) {
        binding.apply {
            Glide.with(ivDoctorImage).load(doctorModelList.doctorImageUrl).into(ivDoctorImage)
            tvLocation.text = doctorModelList.location
            tvDoctorName.text = doctorModelList.doctorName
            tvSpecialization.text = doctorModelList.specialization
            tvPost.text = doctorModelList.post
            tvLanguage.text = doctorModelList.language
            tvExperience.text = doctorModelList.experience
            binding.btnConsultNowToDoctor.setOnClickListener {
                onClickListener.getData(adapterPosition,doctorModelList)
            }
        }

    }
}