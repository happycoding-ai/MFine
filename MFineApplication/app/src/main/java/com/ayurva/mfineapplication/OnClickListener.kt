package com.ayurva.mfineapplication

import com.ayurva.mfineapplication.Model.NotificationModel

interface OnClickListener {
    fun getData(position: Int, result: DoctorModel)
    fun readNotification(notificationModel: NotificationModel, position: Int)
}