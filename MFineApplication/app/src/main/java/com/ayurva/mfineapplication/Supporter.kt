package com.ayurva.mfineapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ayurva.mfineapplication.databinding.ActivitySplashBinding
import com.ayurva.mfineapplication.databinding.ActivitySupporterBinding


class Supporter : AppCompatActivity() {

    private lateinit var binding: ActivitySupporterBinding

    private val fragmentManager = supportFragmentManager
    private val fragmentTransaction = fragmentManager.beginTransaction()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySupporterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (intent?.getStringExtra("token").equals("notificationFragment")) {
            launchNotificationFragment()
        }
//                else {
//            launchHomeFragment()
//        }
    }

//    private fun launchHomeFragment() {
//        val homeFragment = HomeFragment()
//        fragmentTransaction.add(R.id.fragment, homeFragment, "").commit()
//    }

    private fun launchNotificationFragment() {
        val notificationFragment = NotificationFragment()
        fragmentTransaction.add(R.id.fragment, notificationFragment, "notificationFragment")
            .commit()
    }

}