package com.prathyusha.skillapp.activity

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.prathyusha.skillapp.R

class SplashActivity : AppCompatActivity() {

    private val SPLASH_TIMER = 4000
    var splashScreen: ImageView? = null

    var onBoardingScreen: SharedPreferences? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_splash)

        //splashScreen = findViewById(R.id.splashImage);
        //sideAnim = AnimationUtils.loadAnimation(SplashScreen.this,R.anim.side_anim);
        //set Animations on elements
        //splashScreen.setAnimation(sideAnim);
        Handler().postDelayed({
                val intent = Intent(this@SplashActivity, OnBoarding::class.java)
                startActivity(intent)
                finish()
            } , SPLASH_TIMER.toLong())

    }
}