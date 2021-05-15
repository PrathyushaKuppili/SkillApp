package com.prathyusha.skillapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.prathyusha.skillapp.R

class LoginActivity : AppCompatActivity() {

    lateinit var txtLogin :TextView
    lateinit var edtEnter:EditText
    lateinit var txtSignUp:TextView
    lateinit var newUserTextSignIn:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btn_continue=findViewById<Button>(R.id.btnContinue)
        txtLogin=findViewById(R.id.txtLogin)
        txtSignUp=findViewById(R.id.txtSignUp)
        edtEnter=findViewById(R.id.edtEnter)
        newUserTextSignIn=findViewById(R.id.newUserTextSign)
        btn_continue.setOnClickListener {
            val intent=Intent(this, OtpActivity::class.java)
            startActivity(intent)
        }

        newUserTextSignIn.setOnClickListener {

            if(newUserTextSignIn.text.equals("Sign Up")) {
                btn_continue.text = "\t\t\tSign up\t\t\t"
                txtSignUp.text = "Already have an Account!"
                newUserTextSignIn.text = "Sign in"

            } else {
                btn_continue.text = "\t\t\tSign in\t\t\t"
                newUserTextSignIn.text = "Sign up"
                txtSignUp.text = "Don't have an Account?"

            }
        }


    }
}