package com.ayurva.mfineapplication.ViewHolder

import androidx.recyclerview.widget.RecyclerView
import com.ayurva.mfineapplication.Model.NotificationModel
import com.ayurva.mfineapplication.OnClickListener
import com.ayurva.mfineapplication.databinding.NotificationLayoutBinding

class NotificationViewHolder(private val view: NotificationLayoutBinding, private val onClickListener: OnClickListener) :
    RecyclerView.ViewHolder(view.root) {
    fun setNotificationData(model: NotificationModel) {

        view.apply {
            view.doctorName.text = model.doctorName
            view.doctorProfileImage.setImageResource(model.doctorImage)
            view.notificationText.text = model.notificationText

            view.readIcon.setOnClickListener {
                onClickListener.readNotification(model, adapterPosition)
            }
        }
    }
}