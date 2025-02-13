package com.ayurva.mfineapplication

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ayurva.mfineapplication.databinding.ActivitySignUpBinding
import com.ayurva.mfineapplication.databinding.ActivityWalletBinding

class WalletActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWalletBinding

    private val fragmentManager = supportFragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityWalletBinding.inflate(layoutInflater)
        setContentView(binding.root)
        launchCouponFragment()

        binding.couponBtn.setOnClickListener {
            couponButton()
        }

        binding.coinBtn.setOnClickListener {
            buttonCoin()
        }

        // return to home page
        binding.backToHome.setOnClickListener {
            val intent=Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun couponButton() {
        binding.couponBtn.setBackgroundResource(R.drawable.coupon_tab_bg)
        binding.couponBtn.setTextColor(0xFFFFFFFF.toInt())
        binding.couponBtn.setBackgroundColor(Color.TRANSPARENT)
        binding.coinBtn.setTextColor(0xFFF4511E.toInt())
        launchCouponFragment()
    }

    private fun buttonCoin() {
        binding.coinBtn.setBackgroundResource(R.drawable.coin_tab_bg)
        binding.coinBtn.setTextColor(0xFFFFFFFF.toInt())
        binding.couponBtn.setBackgroundColor(Color.TRANSPARENT)
        binding.couponBtn.setTextColor(0xFFF4511E.toInt())
        launchCoinFragment()

    }

    private fun launchCouponFragment() {
        binding.walletTitle.text = "12 Coupons Available"
        binding.walletTitle.setTextColor(0xFF000000.toInt())
        val couponFragment = CouponFragment()
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.wallet_fragment, couponFragment, "couponFragment").commit()
    }

    private fun launchCoinFragment() {
        binding.walletTitle.text = "11 Ayurva Coins Available"
        binding.walletTitle.setTextColor(0xFFFB8C00.toInt())
        val fragmentTransaction = fragmentManager.beginTransaction()
        val coinFragment = CoinFragment()
        fragmentTransaction.replace(R.id.wallet_fragment, coinFragment).commit()


    }

    private fun removeCouponFragment() {
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.remove(CouponFragment()).commit()
    }

    private fun removeCoinFragment() {
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.remove(CoinFragment()).commit()
    }
}
