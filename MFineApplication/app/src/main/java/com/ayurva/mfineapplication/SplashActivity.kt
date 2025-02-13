package com.ayurva.mfineapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.ayurva.mfineapplication.databinding.ActivitySignUpBinding
import com.ayurva.mfineapplication.databinding.ActivitySplashBinding
import com.google.firebase.auth.FirebaseAuth


@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler().postDelayed({
//            val intent = Intent(this@SplashActivity, SignUp::class.java)
//            startActivity(intent)
            val user = FirebaseAuth.getInstance().currentUser
            if (user != null) {
                // User is signed in
                val i = Intent(this@SplashActivity, MainActivity::class.java)
                i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(i)
            } else {
                // User is signed out
                val i = Intent(this@SplashActivity, SignUp::class.java)
                startActivity(i)
                Log.d("SIGNOUT", "onAuthStateChanged:signed_out")
            }

            finish()
        }, 5000)



    }
}