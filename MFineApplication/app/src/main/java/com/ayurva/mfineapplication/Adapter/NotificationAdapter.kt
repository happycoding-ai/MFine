package com.ayurva.mfineapplication.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ayurva.mfineapplication.ItemAnimation
import com.ayurva.mfineapplication.Model.NotificationModel
import com.ayurva.mfineapplication.OnClickListener
import com.ayurva.mfineapplication.R
import com.ayurva.mfineapplication.ViewHolder.NotificationViewHolder
import com.ayurva.mfineapplication.databinding.NotificationLayoutBinding

class NotificationAdapter(private val notificationList: List<NotificationModel>, private val onClickListener: OnClickListener) :
    RecyclerView.Adapter<NotificationViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        val binding = NotificationLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NotificationViewHolder(binding, onClickListener)
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        val model: NotificationModel = notificationList[position]
        ItemAnimation.animateFadeIn(holder.itemView, position)
        holder.setNotificationData(model)
    }

    override fun getItemCount(): Int {
        return notificationList.size
    }

}