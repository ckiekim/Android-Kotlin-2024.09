package com.ckworld.iveapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        /*
        val image1 = findViewById<ImageView>(R.id.ive_1)
        val image2 = findViewById<ImageView>(R.id.ive_2)
        val image3 = findViewById<ImageView>(R.id.ive_3)
        val image4 = findViewById<ImageView>(R.id.ive_4)
        val image5 = findViewById<ImageView>(R.id.ive_5)
        val image6 = findViewById<ImageView>(R.id.ive_6)

        image1.setOnClickListener {
            val intent = Intent(this, ImageInsideActivity::class.java)
            intent.putExtra("index", "1")
            startActivity(intent)
        }
        image2.setOnClickListener {
            val intent = Intent(this, ImageInsideActivity::class.java)
            intent.putExtra("index", "2")
            startActivity(intent)
        }
        image3.setOnClickListener {
            val intent = Intent(this, ImageInsideActivity::class.java)
            intent.putExtra("index", "3")
            startActivity(intent)
        }
        image4.setOnClickListener {
            val intent = Intent(this, ImageInsideActivity::class.java)
            intent.putExtra("index", "4")
            startActivity(intent)
        }
        image5.setOnClickListener {
            val intent = Intent(this, ImageInsideActivity::class.java)
            intent.putExtra("index", "5")
            startActivity(intent)
        }
        image6.setOnClickListener {
            val intent = Intent(this, ImageInsideActivity::class.java)
            intent.putExtra("index", "6")
            startActivity(intent)
        }
        */

        // ImageView들의 ID를 배열로 정의
        val imageIds = listOf(
            R.id.ive_1, R.id.ive_2, R.id.ive_3,
            R.id.ive_4, R.id.ive_5, R.id.ive_6
        )
        // 반복문을 사용하여 클릭 리스너 설정
        for ((index, imageId) in imageIds.withIndex()) {
            findViewById<ImageView>(imageId).setOnClickListener {
                val intent = Intent(this, ImageInsideActivity::class.java)
                intent.putExtra("index", (index + 1).toString())
                startActivity(intent)
            }
        }
    }
}