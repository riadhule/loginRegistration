package com.example.loginproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameUser = intent.getStringExtra("name")
        val userId = intent.getStringExtra("user_id")
        val emailId = intent.getStringExtra("email_id")

        name.text=  "Name: $nameUser"
        email.text= "Email:$emailId"


        view_id.setOnClickListener {

            view_id.text="$userId"
        }

        btn_logout.setOnClickListener {

            FirebaseAuth.getInstance().signOut()

            startActivity(Intent(this@MainActivity, LoginActivity::class.java))
            finish()
        }

    }
}
