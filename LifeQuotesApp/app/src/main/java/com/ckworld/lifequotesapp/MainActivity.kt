package com.ckworld.lifequotesapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.ListView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.ckworld.lifequotesapp.databinding.ActivityMainBinding
import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private var isBackPressed = false
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val todayQuotes = readQuotes(this)
        // Log.d("todayQuotes' size", "================== " + todayQuotes.size)
        // val index = Random.nextInt(0, 100)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.mainText.setText(todayQuotes.random())
        binding.viewAllQuotesButton.setOnClickListener {
            val intent = Intent(this, QuotesActivity::class.java)
            intent.putExtra("todayQuotes", todayQuotes.joinToString("\t"))
            startActivity(intent)
        }
        binding.refreshIcon.setOnClickListener {
            binding.mainText.setText(todayQuotes.random())
        }

        onBackPressedDispatcher.addCallback(this, object: OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (isBackPressed) {
                    Log.d("MainActivity", "===========I'll die.")
                    finishAffinity()
                } else {
                    Log.d("MainActivity", "================Back Button Pressed")
                    isBackPressed = true
                    Toast.makeText(this@MainActivity, "종료하시려면 한번더 누르세요.", Toast.LENGTH_LONG).show()

                    Handler(Looper.getMainLooper()).postDelayed({
                        isBackPressed = false
                    }, 2000)
                }
            }
        })
    }

//    override fun onBackPressed() {
//        if (isBackPressed) {
//            super.onBackPressed()
//            finish()
//        }
//        Log.d("MainActivity", "================Back Button Pressed")
//        isBackPressed = true
//        Toast.makeText(this, "종료하시려면 한번더 누르세요.", Toast.LENGTH_LONG).show()
//
//        Handler(Looper.getMainLooper()).postDelayed({
//            isBackPressed = false
//        }, 2000)
//    }

    private fun readQuotes(context: Context): List<String> {
        val reader: BufferedReader
        val buffer = mutableListOf<String>()
        try {
            reader = BufferedReader(InputStreamReader(context.resources.assets.open("todayQuote.txt")))
            var line: String?
            while (reader.readLine().also { line = it } != null) {
                buffer.add(line!!)
            }
            reader.close()
            return buffer
        } catch (e: Exception) {
            e.printStackTrace()
        }
        buffer.add("fail")
        return buffer
    }
}