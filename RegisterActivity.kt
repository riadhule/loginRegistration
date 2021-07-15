package com.example.loginproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.text.TextUtils
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        register_btn.setOnClickListener {
            when {
                TextUtils.isEmpty(et_login_name.text.toString()) -> {
                    Toast.makeText(
                        this@RegisterActivity, "Please enter name", Toast.LENGTH_SHORT
                    ).show()

                }
                TextUtils.isEmpty(et_register_emailUser.text.toString()) -> {
                    Toast.makeText(
                        this@RegisterActivity, "Please enter email", Toast.LENGTH_SHORT
                    ).show()

                }

                TextUtils.isEmpty(et_register_password.text.toString()) -> {
                    Toast.makeText(
                        this@RegisterActivity, "Please enter password", Toast.LENGTH_SHORT
                    ).show()
                }

                else -> {

                    val name: String = et_login_name.text.toString()
                    val email: String = et_register_emailUser.text.toString()
                    val password: String = et_register_password.text.toString()


                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(
                            OnCompleteListener<AuthResult> { task ->
                                if (task.isSuccessful) {

                                    val firebaseUser: FirebaseUser = task.result!!.user!!

                                    Toast.makeText(
                                        this@RegisterActivity,
                                        "Account created!",
                                        Toast.LENGTH_SHORT
                                    ).show()

                                    val intent =
                                        Intent(this@RegisterActivity, MainActivity::class.java)
                                    intent.flags =
                                        Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                    intent.putExtra("name", name)
                                    intent.putExtra("user_id", firebaseUser.uid)
                                    intent.putExtra("email_id", email)
                                    startActivity(intent)
                                    finish()
                                } else {

                                    Toast.makeText(
                                        this@RegisterActivity,
                                        task.exception!!.message.toString(),
                                        Toast.LENGTH_SHORT
                                    ).show()

                                }
                            }
                        )
                }
            }
        }

        go_login.setOnClickListener {
            startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
        }

    }

}

