package com.ayurva.mfineapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ayurva.mfineapplication.Model.NotificationModel
import com.ayurva.mfineapplication.databinding.ActivitySupporterBinding
import com.ayurva.mfineapplication.databinding.ActivitySymptomDetailBinding
import com.ayurva.mfineapplication.databinding.DoctorItemlayoutBinding
import java.util.ArrayList

class SymptomDetailActivity : AppCompatActivity(),OnClickListener {

    private lateinit var binding: ActivitySymptomDetailBinding
    private lateinit var doctor: DoctorItemlayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySymptomDetailBinding.inflate(layoutInflater)
        doctor = DoctorItemlayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val s = intent.getStringExtra("symptomsName")
        binding.tvSymptomName.setText(s)
        browseDoctorList()
    }

    private fun browseDoctorList() {
        val rvRecyclerView = binding.recyclerViewDoctor
        val doctorModels = ArrayList<DoctorModel>()
        doctorModels.add(DoctorModel("https://i.postimg.cc/zD94hqhJ/mausam.jpg", "Hyderabad","Mausam Singh","MBBS(Intern)","Physician","English,Hindi","2 years experience"))
        doctorModels.add(DoctorModel("https://i.postimg.cc/0N24vQTC/lloyd.jpg", "Bangalore","Llyod Dcosta","MBBS,DNB(General Medicine)","Physician","English","7 years experience"))
        doctorModels.add(DoctorModel("https://i.postimg.cc/L6LwBGkj/prabhakar.jpg", "Bihar","Prabhakar Kumar","MBBS(Intern)","Physician","Hindi,English","1.5 years experience"))
        doctorModels.add(DoctorModel("https://i.postimg.cc/SjFLxTJh/nrupul.jpg", "Bangalore","Nrupul Dev","MBBS,DNB(General Medicine)","Physician","English","10 years experience"))
        doctorModels.add(DoctorModel("https://i.postimg.cc/HkmKS33R/nishant.jpg", "Bihar","Nishant Rishab","MBBS(Intern)","Physician","English,Hindi","1.5 years experience"))
        doctorModels.add(DoctorModel("https://i.postimg.cc/RZTY2fDF/saikrishna.jpg", "Bangalore","Sai Krishna","MBBS","Physician","English","4 years experience"))
        doctorModels.add(DoctorModel("https://i.postimg.cc/rydvzDKn/yogesh.jpg", "Bangalore","Yogesh Bhat","MBBS,DNB(General Medicine)","Physician","English","15 years experience"))
        val doctorAdapter = DoctorAdapter(doctorModels,this)
        val linearLayoutManager = LinearLayoutManager(this)
        rvRecyclerView.adapter = doctorAdapter
        rvRecyclerView.layoutManager = linearLayoutManager
    }

    override fun getData(position: Int, result: DoctorModel) {
        Toast.makeText(this, "Now you are one step behind", Toast.LENGTH_SHORT).show()
        doctor.btnConsultNowToDoctor.setOnClickListener {
            val intent = Intent(this, PatientRegistrationActivity::class.java)
            startActivity(intent)
        }
    }

    override fun readNotification(notificationModel: NotificationModel, position: Int) {

    }
}