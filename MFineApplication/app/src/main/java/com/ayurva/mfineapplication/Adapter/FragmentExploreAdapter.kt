package com.ayurva.mfineapplication.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ayurva.mfineapplication.Model.CommonSymptoms
import com.ayurva.mfineapplication.Model.Hospitals
import com.ayurva.mfineapplication.databinding.ItemLayoutCommonSymptomsBinding
import com.ayurva.mfineapplication.databinding.ItemLayoutHospitalsBinding


//Adapter for Common Symptoms
class CommonSymptomsAdapter(private val listOfSymptoms:ArrayList<CommonSymptoms>): RecyclerView.Adapter<CommonSymptomsAdapter.CommonSymptomsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommonSymptomsViewHolder {
        val binding = ItemLayoutCommonSymptomsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CommonSymptomsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommonSymptomsViewHolder, position: Int) {
        val commonSymptoms = listOfSymptoms[position]
        holder.setData(commonSymptoms)
    }

    override fun getItemCount(): Int {
        return listOfSymptoms.size
    }


    //ViewHolder for Common Symptoms
    class CommonSymptomsViewHolder(private val view: ItemLayoutCommonSymptomsBinding) : RecyclerView.ViewHolder(view.root) {
        internal fun setData(commonSymptoms: CommonSymptoms) {
            view.apply {
                Glide.with(ivSymptomsImage).load(commonSymptoms.symptomImage).into(ivSymptomsImage)
                tvSymptomName.text = commonSymptoms.symptomTitle
            }
        }
    }

}




//Adapter for Hospitals
class HospitalsAdapter(private val listOfHospitals:ArrayList<Hospitals>): RecyclerView.Adapter<HospitalsAdapter.HospitalsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HospitalsViewHolder {
        val view = ItemLayoutHospitalsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HospitalsViewHolder(view)
    }

    override fun onBindViewHolder(holder: HospitalsViewHolder, position: Int) {
        val hospitals = listOfHospitals[position]
        holder.setData(hospitals)
    }

    override fun getItemCount(): Int {
        return listOfHospitals.size
    }


    //ViewHolder for Hospitals
    class HospitalsViewHolder(private val view: ItemLayoutHospitalsBinding) : RecyclerView.ViewHolder(view.root) {
        internal fun setData(hospitals: Hospitals) {
            view.apply {
                Glide.with(ivHospitalImage).load(hospitals.hospitalImage).into(ivHospitalImage)
                tvHospitalName.text = hospitals.hospitalName
            }
        }
    }

}
