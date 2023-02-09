package com.example.exampleapp

import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.exampleapp.databinding.ActivityNewUserBinding

class NewUser : AppCompatActivity() {

    private var name: String? = null
    private var email: String? = null
    private var username: String? = null
    private var password: String? = null

    private var _binding: ActivityNewUserBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_new_user)

        _binding = ActivityNewUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.exUser.setOnClickListener {
            intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }

        binding.create.setOnClickListener {

            name = binding.name.text.toString()
            email = binding.email.text.toString()
            username = binding.userName.text.toString()
            password = binding.password.text.toString()

            createAccount()
        }
        binding.hideOrShow.setOnClickListener {
            if (binding.password.transformationMethod.equals(HideReturnsTransformationMethod.getInstance())){

                binding.hideOrShow.setImageResource(R.drawable.visibility_off)
                binding.password.transformationMethod = PasswordTransformationMethod.getInstance()

            } else{

                binding.hideOrShow.setImageResource(R.drawable.visibility)
                binding.password.transformationMethod = HideReturnsTransformationMethod.getInstance()
            }
        }
    }

    private fun createAccount() {
        if (name == "") {
            Toast.makeText(applicationContext, "Name Field is Empty", Toast.LENGTH_SHORT).show()
        } else if (email == "") {
            Toast.makeText(applicationContext, "Email Field is Empty", Toast.LENGTH_SHORT).show()
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email!!).matches()) {
            Toast.makeText(applicationContext, "Invalid Email ID", Toast.LENGTH_SHORT).show()
        } else if (username == "") {
            Toast.makeText(applicationContext, "User Name Field is Empty", Toast.LENGTH_SHORT)
                .show()
        } else if (password == "") {
            Toast.makeText(applicationContext, "Password Field is Empty", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(applicationContext, "Create Account", Toast.LENGTH_SHORT).show()

            intent = Intent(applicationContext, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}