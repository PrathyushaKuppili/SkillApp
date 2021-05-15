package com.prathyusha.skillapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.prathyusha.skillapp.R

class OtpActivity : AppCompatActivity() {

    lateinit var btn_verify:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp)
        btn_verify=findViewById(R.id.btn_verify)

        btn_verify.setOnClickListener {
            val intent= Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}