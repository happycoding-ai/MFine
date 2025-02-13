package com.ayurva.mfineapplication

import android.app.ProgressDialog
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import com.ayurva.mfineapplication.databinding.ActivitySearchBinding
import com.ayurva.mfineapplication.databinding.ActivitySignUpBinding
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit

class SignUp : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    //if code sending failed, will used to resend
    private var forceResendingToken: PhoneAuthProvider.ForceResendingToken? = null

    private var mCallbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks? = null
    private var mVerificationId: String? = null
    private lateinit var firebaseAuth: FirebaseAuth

    private val TAG = "Main_TAG"

    //process dialog
    private lateinit var progressDialog: ProgressDialog

    //************** end **********


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        firebaseAuth = FirebaseAuth.getInstance()

        binding.logIn.setOnClickListener{
            logInToTheApp("test@gmail.com",
                "1234567890",
                firebaseAuth)
        }

        binding.etMobileNumber.doAfterTextChanged {
            if (binding.etMobileNumber.text.toString().trim().length == 10) {
                binding.imgBtnConfirm.visibility = View.VISIBLE
                //val phone = etMobileNumber.text.toString().trim()
                //startPhoneNumberVerification(phone)
            } else if (binding.etMobileNumber.text.toString().trim().length < 10) {
                binding.imgBtnConfirm.visibility = View.INVISIBLE
            }


//            val phone = etMobileNumber.text.toString().trim()
//            if (TextUtils.isEmpty(phone)) {
//
//                Toast.makeText(this@SignUp, "Please enter phone number", Toast.LENGTH_SHORT)
//                    .show()
//
//            } else {
//                startPhoneNumberVerification(phone)
//            }
        }

        binding.imgBtnConfirm.setOnClickListener {
            val phone = binding.etMobileNumber.text.toString().trim()
            startPhoneNumberVerification(phone)
            binding.cdOtp.visibility = View.VISIBLE
            binding.etMobileNumber.setTextColor(Color.parseColor("#A6A6A6"))
            binding.imgBtnConfirm.visibility = View.INVISIBLE
            binding.imgBtnEdit.visibility = View.VISIBLE
            binding.etMobileNumber.isEnabled = false
            binding.etOtp.requestFocus()
        }

        binding.imgBtnEdit.setOnClickListener {
            binding.etMobileNumber.isEnabled = true
            binding.etMobileNumber.requestFocus()
            binding.imgBtnConfirm.visibility = View.VISIBLE
            binding.imgBtnEdit.visibility = View.INVISIBLE
            binding.etMobileNumber.setTextColor(Color.parseColor("#000000"))
            binding.cdOtp.visibility = View.GONE

        }

        binding.etOtp.doAfterTextChanged {
            if (binding.etOtp.text.toString().trim().length == 6) {

                val code = binding.etOtp.text.toString().trim()
                verifyPhoneNumberWithCode(mVerificationId, code)

//                val intent = Intent(baseContext, CreateAccount::class.java)
//
//                startActivity(intent)
                //etOtp.text = null
            }


//            val code = etOtp.text.toString().trim()
//            if (TextUtils.isEmpty(code)) {
//                Toast.makeText(
//                    this@SignUp,
//                    "please enter verification code",
//                    Toast.LENGTH_SHORT
//                ).show()
//
//            } else {
//                verifyPhoneNumberWithCode(mVerificationId, code)
//                val intent = Intent(this, CreateAccount::class.java)
//                startActivity(intent)
//            }
        }



        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Please Wait")
        progressDialog.setCanceledOnTouchOutside(false)

        mCallbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            override fun onVerificationCompleted(phoneAuthCredential: PhoneAuthCredential) {


                signWithPhoneAuthCredntial(phoneAuthCredential)

            }

            override fun onVerificationFailed(e: FirebaseException) {
                progressDialog.dismiss()
//                to toast exception e
                Toast.makeText(this@SignUp, "${(e.message)}", Toast.LENGTH_SHORT).show()
                Toast.makeText(this@SignUp, "Enter valid number", Toast.LENGTH_SHORT).show()

            }

            override fun onCodeSent(verificationId: String, token: PhoneAuthProvider.ForceResendingToken) {
                super.onCodeSent(verificationId, token)
                Log.d(TAG, "onCodeSent:$verificationId")
                mVerificationId = verificationId
                forceResendingToken = token
                progressDialog.dismiss()

                //hid phone layout and show code layout
                // binding.phoneL1.visibility=View.VISIBLE
                //binding.codeL1.visibility=View.GONE
                Toast.makeText(this@SignUp, "Verification code sent", Toast.LENGTH_SHORT)
                    .show()
//                binding.codeSentDescriptionTv.text =
//                    "Please type the Verification code we sent to ${
//                        binding.etPhone.text.toString().trim()
//                    }"

            }

        }


//        binding.btnContinue.setOnClickListener {
//
//            // input phone number
//            val phone = etMobileNumber.text.toString().trim()
//            if (TextUtils.isEmpty(phone)) {
//
//                Toast.makeText(this@SignUp, "Please enter phone number", Toast.LENGTH_SHORT)
//                    .show()
//
//            } else {
//                startPhoneNumberVerification(phone)
//            }
//
//        }

//        binding.codeSubmitBtn.setOnClickListener {
//            // input verification code
//            val code = etOtp.text.toString().trim()
//            if (TextUtils.isEmpty(code)) {
//                Toast.makeText(
//                    this@SignUp,
//                    "please enter verification code",
//                    Toast.LENGTH_SHORT
//                ).show()
//
//            } else {
//                verifyPhoneNumberWithCode(mVerificationId, code)
//                val intent = Intent(this, CreateAccount::class.java)
//                startActivity(intent)
//            }
//        }

//        binding.resendCodeTv.setOnClickListener {
//            // input phone number
//            val phone = etMobileNumber.text.toString().trim()
//            if (TextUtils.isEmpty(phone)) {
//
//                Toast.makeText(this@SignUp, "Please enter phone number", Toast.LENGTH_SHORT)
//                    .show()
//
//            } else {
//                forceResendingToken?.let { it1 -> resendVerificationCode(phone, it1) }
//            }
//        }

    }




    private fun logInToTheApp(email: String, password: String, firebaseAuth: FirebaseAuth) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val i = Intent(this@SignUp, MainActivity::class.java)
                    i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(i)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                    Toast.makeText(
                        baseContext,
                        "Authentication failed.",
                        Toast.LENGTH_SHORT,
                    ).show()
                }
            }
    }





    private fun startPhoneNumberVerification(phone: String) {
        progressDialog.setMessage("Verifying Phone Number...")
        progressDialog.show()

        val options = mCallbacks?.let {
            PhoneAuthOptions.newBuilder(firebaseAuth)
                .setPhoneNumber("+91$phone")
                .setTimeout(60L, TimeUnit.SECONDS)
                .setActivity(this)
                .setCallbacks(it)
                .build()

        }
        if (options != null) {
            PhoneAuthProvider.verifyPhoneNumber(options)
        }
    }

    private fun resendVerificationCode(
        phone: String,
        token: PhoneAuthProvider.ForceResendingToken
    ) {
        progressDialog.setMessage("Resending Code...")
        progressDialog.show()

        val options = mCallbacks?.let {
            PhoneAuthOptions.newBuilder(firebaseAuth)
                .setPhoneNumber(phone)
                .setTimeout(60L, TimeUnit.SECONDS)
                .setActivity(this)
                .setCallbacks(it)
                .setForceResendingToken(token)
                .build()

        }
        if (options != null) {
            PhoneAuthProvider.verifyPhoneNumber(options)
        }
    }

    private fun verifyPhoneNumberWithCode(verificationId: String?, code: String) {
        progressDialog.setMessage("Verifying code...")
        progressDialog.show()

        val credential = verificationId?.let { PhoneAuthProvider.getCredential(it, code) }
        signWithPhoneAuthCredntial(credential)
    }

    private fun signWithPhoneAuthCredntial(credential: PhoneAuthCredential?) {
        progressDialog.setMessage("Logging In...")

        if (credential != null) {
            firebaseAuth.signInWithCredential(credential)
                .addOnSuccessListener {
                    //lgoin sucess
                    progressDialog.dismiss()
                    // Toast.makeText(this,"$(e.message)",Toast.LENGTH_SHORT).show()
                    val phone = firebaseAuth.currentUser?.phoneNumber
                    Toast.makeText(this, "Loggin in as $phone", Toast.LENGTH_SHORT).show()

                    //sending phone number to next page
//                    val bundle=Bundle();
//                    bundle.putString("phone",phone)

                    if(binding.etOtp.text.toString().length==6) {
                        // start profile actiivity
                        val intent = Intent(baseContext, CreateAccount::class.java)
                        intent.putExtra("phone",phone)
                        startActivity(intent)
                    }


                }
                .addOnFailureListener { e ->
                    //login failed
                    progressDialog.dismiss()
//                    to print exception e
//                    Toast.makeText(this, "${(e.message)}", Toast.LENGTH_SHORT).show()
                    Toast.makeText(this, "Enter valid OTP", Toast.LENGTH_SHORT).show()

                }
        }
    }
}