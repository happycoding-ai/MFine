package com.ayurva.mfineapplication.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.ayurva.mfineapplication.*
import com.ayurva.mfineapplication.Adapter.CommonSymptomsAdapter
import com.ayurva.mfineapplication.Adapter.HospitalsAdapter
import com.ayurva.mfineapplication.Model.CommonSymptoms
import com.ayurva.mfineapplication.Model.Hospitals
import com.ayurva.mfineapplication.databinding.FragmentExploreBinding
import com.romainpiel.shimmer.Shimmer

class FragmentExplore : Fragment(R.layout.fragment_explore) {

    private var _binding: FragmentExploreBinding? = null
    private val binding get() = _binding!!


    private val listOfSymptoms:ArrayList<CommonSymptoms> = ArrayList()
    private val listOfHospitals:ArrayList<Hospitals> = ArrayList()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inflate the binding object
        _binding = FragmentExploreBinding.bind(view)

        binding.notificationBtn.setOnClickListener {
            val intent = Intent(context, Supporter::class.java)
            intent.putExtra("token", "notificationFragment")
            startActivity(intent)
        }
        binding.walletBtn.setOnClickListener {
            launchWallet()
        }

        binding.btnExploreMore.setOnClickListener{
            val intent=Intent(context,ExploreMoreActivity::class.java)
            startActivity(intent)
        }

        binding.cvOnlineConsultations.setOnClickListener{
            val intent=Intent(context,ConsultNow::class.java)
            startActivity(intent)
        }

        binding.tvSearchExplore.setOnClickListener {
            val intent=Intent(context,ConsultNow::class.java)
            startActivity(intent)
        }

        val shimmer=Shimmer()
        shimmer.start(binding.tvSearchExplore)
        shimmer.start(binding.tvSeeMore)
        //shimmer.start(btnExploreMore)


        setRecyclerViewData()
        setRecyclerView()
    }

    private fun launchWallet() {
        val intent = Intent(context, WalletActivity::class.java)
        startActivity(intent)
    }


    private fun setRecyclerViewData() {
        //for Common Symptoms
        for(i in 1..2) {
            listOfSymptoms.add(CommonSymptoms(R.drawable.sym_coronavirus, "COVID-19"))
            listOfSymptoms.add(CommonSymptoms(R.drawable.sym_pad, "Period Issue"))
            listOfSymptoms.add(CommonSymptoms(R.drawable.sym_acne, "Acne/Pimples"))
            listOfSymptoms.add(CommonSymptoms(R.drawable.sym_fever, "Fever"))
            listOfSymptoms.add(CommonSymptoms(R.drawable.sym_depression, "Depression"))
            listOfSymptoms.add(CommonSymptoms(R.drawable.sym_anxiety, "Anxiety"))
            listOfSymptoms.add(CommonSymptoms(R.drawable.sym_pregancy, "Pregnancy Queries"))
            listOfSymptoms.add(CommonSymptoms(R.drawable.sym_packpain, "Back Pain"))
            listOfSymptoms.add(CommonSymptoms(R.drawable.sym_acidity, "Acidity"))
            listOfSymptoms.add(CommonSymptoms(R.drawable.sym_headache, "Headache"))
            listOfSymptoms.add(CommonSymptoms(R.drawable.diabetes_care, "Diabetes"))
            listOfSymptoms.add(CommonSymptoms(R.drawable.sym_cough, "Coughs"))
            listOfSymptoms.add(CommonSymptoms(R.drawable.sym_harifall, "Hair fall"))
            listOfSymptoms.add(CommonSymptoms(R.drawable.sym_weightloss, "Weight loss"))
            listOfSymptoms.add(CommonSymptoms(R.drawable.sym_capsule, "Erectile Dysfunction"))
            listOfSymptoms.add(CommonSymptoms(R.drawable.sym_urinary, "Urinary Tract Infections"))
            listOfSymptoms.add(CommonSymptoms(R.drawable.sym_stomach, "Stomach Ache"))
            listOfSymptoms.add(CommonSymptoms(R.drawable.sym_pile, "Piles"))
            listOfSymptoms.add(CommonSymptoms(R.drawable.sym_throat, "Throat Pain"))
            listOfSymptoms.add(CommonSymptoms(R.drawable.sym_diheria, "Constipation"))


        }

        //for Hospitals
        for(i in 1..20) {
            listOfHospitals.add(Hospitals(R.drawable.hospital_sparsh, "Sparsh Hospitals"))
        }
    }

    private fun setRecyclerView() {
        //for Common Symptoms
        val commonSymptomsAdapter = CommonSymptomsAdapter(listOfSymptoms)
        val gridLayoutManagerCommonSymptoms = GridLayoutManager(context, 2, GridLayoutManager.HORIZONTAL, false)
        binding.recyclerViewCommonSymptoms.adapter = commonSymptomsAdapter
        binding.recyclerViewCommonSymptoms.layoutManager = gridLayoutManagerCommonSymptoms
        binding.recyclerViewCommonSymptoms.hasFixedSize()


        //for Hospitals
        val hospitalsAdapter = HospitalsAdapter(listOfHospitals)
        val gridLayoutManagerHospitals = GridLayoutManager(context, 1, GridLayoutManager.HORIZONTAL, false)
        binding.recyclerViewHospitals.adapter = hospitalsAdapter
        binding.recyclerViewHospitals.layoutManager = gridLayoutManagerHospitals
        binding.recyclerViewHospitals.hasFixedSize()
    }

}