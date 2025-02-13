package com.ayurva.mfineapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ayurva.mfineapplication.databinding.ItemLayoutBinding
import java.util.ArrayList


class SymptomsAdapter(private val heartRelatedModels: ArrayList<SymptomsModel>) : RecyclerView.Adapter<SymptomsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SymptomsViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SymptomsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SymptomsViewHolder, position: Int) {
        val heartRelatedModel = heartRelatedModels[position]
        ItemAnimation.animateFadeIn(holder.itemView, position)
        holder.setData(heartRelatedModel)
    }

    override fun getItemCount(): Int {
        return heartRelatedModels.size
    }
}