package com.ayurva.mfineapplication

import androidx.recyclerview.widget.RecyclerView
import com.ayurva.mfineapplication.databinding.ItemLayoutBinding
import com.bumptech.glide.Glide


class SymptomsViewHolder(private val view: ItemLayoutBinding) : RecyclerView.ViewHolder(view.root) {
    fun setData(heartRelatedModel: SymptomsModel) {
        view.apply {
                Glide.with(view.ivImage).load(heartRelatedModel.ivUrl).into(ivImage)
            view.tvSymptomName.text = heartRelatedModel.tvSymptoms
        }
    }
}