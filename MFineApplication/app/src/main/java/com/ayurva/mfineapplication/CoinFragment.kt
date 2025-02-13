package com.ayurva.mfineapplication

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.ayurva.mfineapplication.databinding.FragmentCoinBinding

class CoinFragment : Fragment(R.layout.fragment_coin) {

    private lateinit var binding: FragmentCoinBinding

    private var isAnswerOneShowing = false
    private var isAnswerTwoShowing=false
    private var isAnswerThreeShowing=false
    private var isAnswerFourShowing=false
    private var isAnswerFiveShowing=false
    private var isAnswerSixSowing=false
    private var isAnswerSevenShowing=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentCoinBinding.bind(view)
        /**
        => Question & Answer on CLik operation calling
         */
        binding.qNo1.setOnClickListener {
            onClickQuestion1()
        }
        binding.qNo2.setOnClickListener {
            onClickQuestion2()
        }
        binding.qNo3.setOnClickListener {
            onClickQuestion3()
        }
        binding.qNo4.setOnClickListener {
            onClickQuestion4()
        }
        binding.qNo5.setOnClickListener {
            onClickQuestion5()
        }
        binding.qNo6.setOnClickListener {
            onClickQuestion6()
        }
        binding.qNo7.setOnClickListener {
            onClickQuestion7()
        }
    }

    /**
    => Question & Answer on CLik operation implementing
     */
    private fun onClickQuestion1() {
        if (!isAnswerOneShowing) {
            val icon = ContextCompat.getDrawable(requireContext(), R.drawable.arrow_up_icon)
            binding.qNo1.setCompoundDrawablesWithIntrinsicBounds(null, null, icon, null)
            binding.ansNo1.visibility = View.VISIBLE
            isAnswerOneShowing = true
        } else {
            val icon = ContextCompat.getDrawable(requireContext(), R.drawable.arrow_down_icon)
            binding.qNo1.setCompoundDrawablesWithIntrinsicBounds(null, null, icon, null)
            binding.ansNo1.visibility = View.GONE
            isAnswerOneShowing = false
        }

    }


    private fun onClickQuestion2() {
        if (!isAnswerTwoShowing) {
            val icon = ContextCompat.getDrawable(requireContext(), R.drawable.arrow_up_icon)
            binding.qNo2.setCompoundDrawablesWithIntrinsicBounds(null, null, icon, null)
            binding.ansNo2.visibility = View.VISIBLE
            isAnswerTwoShowing = true
        } else {
            val icon = ContextCompat.getDrawable(requireContext(), R.drawable.arrow_down_icon)
            binding.qNo2.setCompoundDrawablesWithIntrinsicBounds(null, null, icon, null)
            binding.ansNo2.visibility = View.GONE
            isAnswerTwoShowing = false
        }
    }

    private fun onClickQuestion3() {
        if (!isAnswerThreeShowing) {
            val icon = ContextCompat.getDrawable(requireContext(), R.drawable.arrow_up_icon)
            binding.qNo3.setCompoundDrawablesWithIntrinsicBounds(null, null, icon, null)
            binding.ansNo3.visibility = View.VISIBLE
            isAnswerThreeShowing = true
        } else {
            val icon = ContextCompat.getDrawable(requireContext(), R.drawable.arrow_down_icon)
            binding.qNo3.setCompoundDrawablesWithIntrinsicBounds(null, null, icon, null)
            binding.ansNo3.visibility = View.GONE
            isAnswerThreeShowing = false
        }
    }

    private fun onClickQuestion4() {
        if (!isAnswerFourShowing) {
            val icon = ContextCompat.getDrawable(requireContext(), R.drawable.arrow_up_icon)
            binding.qNo4.setCompoundDrawablesWithIntrinsicBounds(null, null, icon, null)
            binding.ansNo4.visibility = View.VISIBLE
            isAnswerFourShowing = true
        } else {
            val icon = ContextCompat.getDrawable(requireContext(), R.drawable.arrow_down_icon)
            binding.qNo4.setCompoundDrawablesWithIntrinsicBounds(null, null, icon, null)
            binding.ansNo4.visibility = View.GONE
            isAnswerFourShowing = false

        }
    }

    private fun onClickQuestion5() {
        if (!isAnswerFiveShowing) {
            val icon = ContextCompat.getDrawable(requireContext(), R.drawable.arrow_up_icon)
            binding.qNo5.setCompoundDrawablesWithIntrinsicBounds(null, null, icon, null)
            binding.ansNo5.visibility = View.VISIBLE
            isAnswerFiveShowing = true
        } else {
            val icon = ContextCompat.getDrawable(requireContext(), R.drawable.arrow_down_icon)
            binding.qNo5.setCompoundDrawablesWithIntrinsicBounds(null, null, icon, null)
            binding.ansNo5.visibility = View.GONE
            isAnswerFiveShowing = false
        }
    }

    private fun onClickQuestion6() {
        if (!isAnswerSixSowing) {
            val icon = ContextCompat.getDrawable(requireContext(), R.drawable.arrow_up_icon)
            binding.ansNo6.setCompoundDrawablesWithIntrinsicBounds(null, null, icon, null)
            binding.ansNo6.visibility = View.VISIBLE
            isAnswerSixSowing = true
        } else {
            val icon = ContextCompat.getDrawable(requireContext(), R.drawable.arrow_down_icon)
            binding.qNo6.setCompoundDrawablesWithIntrinsicBounds(null, null, icon, null)
            binding.ansNo6.visibility = View.GONE
            isAnswerSixSowing = false
        }
    }

    private fun onClickQuestion7() {
        if (!isAnswerSevenShowing) {
            val icon = ContextCompat.getDrawable(requireContext(), R.drawable.arrow_up_icon)
            binding.qNo7.setCompoundDrawablesWithIntrinsicBounds(null, null, icon, null)
            binding.ansNo7.visibility = View.VISIBLE
            isAnswerSevenShowing = true
        } else {
            val icon = ContextCompat.getDrawable(requireContext(), R.drawable.arrow_down_icon)
            binding.qNo7.setCompoundDrawablesWithIntrinsicBounds(null, null, icon, null)
            binding.ansNo7.visibility = View.GONE
            isAnswerSevenShowing = false
        }
    }
}