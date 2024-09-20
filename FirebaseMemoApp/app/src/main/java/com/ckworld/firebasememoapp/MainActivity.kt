package com.ckworld.firebasememoapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Initialize Firebase Auth
        auth = Firebase.auth

        val showMsg = findViewById<TextView>(R.id.showMessage)
        val anonyBtn = findViewById<Button>(R.id.anonymousLoginBtn)
        anonyBtn.setOnClickListener {
            auth.signInAnonymously()
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val user = auth.currentUser
//                        Log.d("MainActivity", "signInAnonymously:success " + user!!.uid)
                        showMsg.setText("signInAnonymously:success\n${user!!.uid}")
                    } else {
//                        Toast.makeText(baseContext, "Authentication failed.", Toast.LENGTH_LONG).show()
                        showMsg.setText("Authentication failed.")
                    }
                }
        }

        val emailBtn = findViewById<Button>(R.id.emailLoginBtn)
        val registerBtn = findViewById<Button>(R.id.emailRegisterBtn)
        val email = findViewById<EditText>(R.id.emailArea)
        val password = findViewById<EditText>(R.id.passwordArea)

        registerBtn.setOnClickListener {
            showMsg.setText("email=${email.text}\npassword=${password.text}")
            auth.createUserWithEmailAndPassword(email.text.toString(), password.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val user = auth.currentUser
                        showMsg.setText("email=${email.text}\npassword=${password.text}\ncreateUserWithEmail:success\nuid=${user!!.uid}")
                    } else {
//                        Toast.makeText(baseContext, "Authentication failed.", Toast.LENGTH_LONG).show()
                        showMsg.setText("createUserWithEmail:failure")
                    }
                }
        }

        emailBtn.setOnClickListener{
            auth.signInWithEmailAndPassword(email.text.toString(), password.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val user = auth.currentUser
                        showMsg.setText("email=${email.text}\npassword=${password.text}\nsignInWithEmail:success\nuid=${user!!.uid}")
                    } else {
//                        Toast.makeText(baseContext, "Authentication failed.", Toast.LENGTH_SHORT).show()
                        showMsg.setText("signInWithEmail:failure")
                    }
                }
        }

        val logoutBtn = findViewById<Button>(R.id.logoutBtn)
        logoutBtn.setOnClickListener {
            Firebase.auth.signOut()
            showMsg.setText("로그아웃 완료")
        }
    }
}