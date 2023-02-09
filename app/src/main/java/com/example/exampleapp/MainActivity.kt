package com.example.exampleapp

import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.exampleapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var username: String? = null
    private var password: String? = null
    private var hideOrShow: ImageView? = null

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.login.setOnClickListener {

            username = binding.userName.text.toString()
            password = binding.password.text.toString()
            hideOrShow = binding.hideOrShow

            validation()
        }

        binding.newUser.setOnClickListener {

            intent = Intent(applicationContext, NewUser::class.java)
            startActivity(intent)
        }
        binding.hideOrShow.setOnClickListener {
            if (binding.password.transformationMethod.equals(HideReturnsTransformationMethod.getInstance())) {

                binding.hideOrShow.setImageResource(R.drawable.visibility_off)
                binding.password.transformationMethod = PasswordTransformationMethod.getInstance()

            } else {

                binding.hideOrShow.setImageResource(R.drawable.visibility)
                binding.password.transformationMethod =
                    HideReturnsTransformationMethod.getInstance()
            }
        }
    }

    private fun validation() {
        if (username == "" && password == "") {
            Toast.makeText(
                applicationContext,
                "User Name or Password Field is Empty",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            Toast.makeText(applicationContext, "Successful", Toast.LENGTH_SHORT).show()

            intent = Intent(applicationContext, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}