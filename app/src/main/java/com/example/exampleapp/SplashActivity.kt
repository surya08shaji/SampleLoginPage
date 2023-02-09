package com.example.exampleapp

import android.content.Intent
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.exampleapp.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private var _binding: ActivitySplashBinding? = null
    private val binding get() = _binding!!

    private lateinit var animation: Animation


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_splash)

        //splash time
        _binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val upHandler = Handler()
//        val runnable = Runnable {
//            updateDisplay()
//        }
//        upHandler.postDelayed(runnable,4000)

//        Handler().postDelayed({
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//            finish()
//        }, 4000)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)


        //text color gradient view
        val paint = binding.appName.paint
        val width = paint.measureText(binding.appName.text.toString())
        val textShader: Shader = LinearGradient(
            0f, 0f, width, binding.appName.textSize, intArrayOf(
                Color.parseColor("#6236AF"),
                Color.parseColor("#9B51CF"),
                Color.parseColor("#B65AD8")
            ), null, Shader.TileMode.REPEAT
        )

        binding.appName.paint.shader = textShader


        // small images animation
        animation = AnimationUtils.loadAnimation(
            applicationContext,
            R.anim.scale_in
        )
        binding.image1.startAnimation(animation)

        animation = AnimationUtils.loadAnimation(
            applicationContext,
            R.anim.scale_in
        )
        binding.image2.startAnimation(animation)

        animation = AnimationUtils.loadAnimation(
            applicationContext,
            R.anim.scale_in
        )
        binding.image3.startAnimation(animation)

        animation = AnimationUtils.loadAnimation(
            applicationContext,
            R.anim.scale_in
        )
        binding.image4.startAnimation(animation)

        animation = AnimationUtils.loadAnimation(
            applicationContext,
            R.anim.scale_in
        )
        binding.image5.startAnimation(animation)

        animation = AnimationUtils.loadAnimation(
            applicationContext,
            R.anim.scale_in
        )
        binding.image6.startAnimation(animation)

        animation = AnimationUtils.loadAnimation(
            applicationContext,
            R.anim.scale_in
        )
        binding.image7.startAnimation(animation)

        animation = AnimationUtils.loadAnimation(
            applicationContext,
            R.anim.scale_in
        )
        binding.image8.startAnimation(animation)

        animation = AnimationUtils.loadAnimation(
            applicationContext,
            R.anim.scale_in
        )
        binding.image9.startAnimation(animation)

        animation = AnimationUtils.loadAnimation(
            applicationContext,
            R.anim.scale_in
        )
        binding.image10.startAnimation(animation)

        animation = AnimationUtils.loadAnimation(
            applicationContext,
            R.anim.scale_in
        )
        binding.image11.startAnimation(animation)

        animation = AnimationUtils.loadAnimation(
            applicationContext,
            R.anim.scale_in
        )
        binding.image12.startAnimation(animation)
    }
}