package com.example.loginproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        register_text.setOnClickListener{
            startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
        }

        login_btn.setOnClickListener {
            when {
                TextUtils.isEmpty(et_login_emailUser.text.toString()) -> {
                    Toast.makeText(
                        this@LoginActivity, "Please enter email", Toast.LENGTH_SHORT
                    ).show()

                }
                TextUtils.isEmpty(et_login_password.text.toString()) -> {
                    Toast.makeText(
                        this@LoginActivity, "Please enter email", Toast.LENGTH_SHORT
                    ).show()

                }

                else -> {

                    val email: String = et_login_emailUser.text.toString()
                    val password: String = et_login_password.text.toString()
                    val name: String = et_login_name.text.toString()

                    FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener { task ->

                                if (task.isSuccessful) {

                                    Toast.makeText(
                                        this@LoginActivity,
                                        "Logged in!",
                                        Toast.LENGTH_SHORT
                                    ).show()

                                    val intent =
                                        Intent(this@LoginActivity, MainActivity::class.java)
                                    intent.flags =
                                        Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

                                    intent.putExtra("user_id", FirebaseAuth.getInstance().currentUser!!.uid)
                                    intent.putExtra("email_id", email)
                                    intent.putExtra("name", name)
                                    startActivity(intent)
                                    finish()
                                } else {

                                    Toast.makeText(
                                        this@LoginActivity,
                                        task.exception!!.message.toString(),
                                        Toast.LENGTH_SHORT
                                    ).show()

                                }
                            }

                }
            }
        }
    }
}
