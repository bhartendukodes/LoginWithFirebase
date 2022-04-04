package com.example.loginwithfirebase

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.loginwithfirebase.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {


    private val binding by lazy {
        ActivityRegisterBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        onClick()
        enterField()
    }

    private fun enterField() {
        binding.apply {
            val email = edtEmail.text.toString()
            val password = edtPassword.text.toString()
            val reEnterPassword = edtReEnter.text.toString()


            tvAlready.setOnClickListener {
                if (edtEmail.text.toString().trim().isEmpty()) {
                    edtEmail.error="Empty Email"
                    return@setOnClickListener
                }

                if (edtPassword.text.toString().trim().isEmpty()) {
                    edtPassword.error="Please enter your Password"
                    return@setOnClickListener
                }
                if (edtReEnter.text.toString().trim().isEmpty()) {
                    edtReEnter.error="Please re-enter your password"
                    return@setOnClickListener
                }
            }

        }
    }

    private fun onClick() {
        binding.tvAlready.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}