package com.ayurva.mfineapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ayurva.mfineapplication.databinding.DoctorItemlayoutBinding
import java.util.ArrayList

class DoctorAdapter(private val doctorModelList: ArrayList<DoctorModel>, private var clickListener: OnClickListener) : RecyclerView.Adapter<DoctorViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorViewHolder {
        val binding = DoctorItemlayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DoctorViewHolder(binding,clickListener)
    }

    override fun onBindViewHolder(holder: DoctorViewHolder, position: Int) {
        val doctorModelList = doctorModelList[position]
        holder.setData(doctorModelList)
        ItemAnimation.animateLeftRight(holder.itemView, position)
    }

    override fun getItemCount(): Int {
        return doctorModelList.size
    }
}