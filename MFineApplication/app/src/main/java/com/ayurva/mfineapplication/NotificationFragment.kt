package com.ayurva.mfineapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ayurva.mfineapplication.Adapter.NotificationAdapter
import com.ayurva.mfineapplication.Model.NotificationModel
import com.ayurva.mfineapplication.databinding.FragmentNotificationBinding

class NotificationFragment : Fragment(R.layout.fragment_notification), OnClickListener {

    private var _binding: FragmentNotificationBinding? = null
    private val binding get() = _binding!!

    private var doctorList = arrayListOf<NotificationModel>()
    private lateinit var notificationAdapter: NotificationAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentNotificationBinding.bind(view)
        buildNotificationList()
        setNotificationRecyclerView()
        binding.backToHome.setOnClickListener {
            val intent = Intent(requireContext(), MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun buildNotificationList() {
        doctorList = arrayListOf()
        doctorList.add(
            NotificationModel(
                R.drawable.person_1,
                "Dr.Twinkle",
                "wants to know your fever condition, if you have any query then he will resolve"
            )
        )
        doctorList.add(
            NotificationModel(
                R.drawable.person_1,
                "Dr.Pallavi",
                "wants to know health click heer to conversession"
            )
        )
        doctorList.add(
            NotificationModel(
                R.drawable.person_1, "Dr.Mausham",
                "wants to know your head pain"
            )
        )
        doctorList.add(
            NotificationModel(
                R.drawable.person_1,
                "Dr.Nishant",
                "wants to know health click heer to conversession"
            )
        )
        doctorList.add(
            NotificationModel(
                R.drawable.person_1,
                "Dr.kumar",
                "wants to know health click heer to conversession"
            )
        )
        doctorList.add(
            NotificationModel(
                R.drawable.person_4,
                "Dr.Riya",
                "wants to know health click heer to conversession"
            )
        )
        doctorList.add(
            NotificationModel(
                R.drawable.person_4,
                "Dr.Mishra",
                "wants to know health click heer to conversession"
            )
        )
        doctorList.add(
            NotificationModel(
                R.drawable.person_1,
                "Dr.Ganesh",
                "wants to know health click heer to conversession"
            )
        )
        doctorList.add(
            NotificationModel(
                R.drawable.person_4,
                "Dr.Subhash",
                "wants to know health click heer to conversession"
            )
        )
        doctorList.add(
            NotificationModel(
                R.drawable.person_4,
                "Dr.Ganesh",
                "wants to know health click heer to conversession"
            )
        )
    }

    private fun setNotificationRecyclerView() {
        notificationAdapter = NotificationAdapter(doctorList, this)
        binding.notificationRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.notificationRecyclerView.adapter = notificationAdapter
    }

    override fun getData(position: Int, result: DoctorModel) {

    }

    override fun readNotification(notificationModel: NotificationModel, position: Int) {
//        Toast.makeText(context, "Read Notification $position", LENGTH_SHORT).show()
        doctorList.removeAt(position)
        notificationAdapter.notifyDataSetChanged()

    }
}