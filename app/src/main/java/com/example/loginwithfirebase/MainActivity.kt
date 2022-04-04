package com.example.loginwithfirebase

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.loginwithfirebase.databinding.ActivityMainBinding
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val signInLauncher = registerForActivityResult(
        FirebaseAuthUIActivityResultContract()
    ) { res ->
        this.onSignInResult(res)
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        onClick()
    }

    private fun onClick() {

        binding.tvCreate.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
        binding.googleLogin.setOnClickListener {
            startAuthentication(AuthUI.IdpConfig.GoogleBuilder().build())
        }
        binding.facebookLogin.setOnClickListener {
            startAuthentication(AuthUI.IdpConfig.GitHubBuilder().build())
        }
        binding.phoneNo.setOnClickListener {
            startAuthentication(AuthUI.IdpConfig.PhoneBuilder().build())
        }
    }

    private fun startAuthentication(build: AuthUI.IdpConfig) {
        val providers = arrayListOf(
            build
        )
        val signInIntent = AuthUI.getInstance()
            .createSignInIntentBuilder()
            .setAvailableProviders(providers)
            .build()
        signInLauncher.launch(signInIntent)
    }


    private fun onSignInResult(result: FirebaseAuthUIAuthenticationResult) {
        val response = result.idpResponse
        if (result.resultCode == RESULT_OK) {
            // Successfully signed in
            val user = FirebaseAuth.getInstance().currentUser
            // ...
        } else {
            // Sign in failed. If response is null the user canceled the
            // sign-in flow using the back button. Otherwise check
            // response.getError().getErrorCode() and handle the error.
            // ...
        }
    }

}
