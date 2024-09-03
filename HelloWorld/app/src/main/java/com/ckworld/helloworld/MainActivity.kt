package com.ckworld.helloworld

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)      // activity_main.xml 레이아웃

        // 1. 화면이 클릭되었다는 것을 알아야 함
        val image1 = findViewById<ImageView>(R.id.ive_1)
        image1.setOnClickListener {
            Toast.makeText(this, "1번 클릭 완료", Toast.LENGTH_LONG).show()
            // 2. 화면이 클릭되면 다음 화면으로 넘어가서 사진을 크게 보여줌
            val intent = Intent(this, Ive1Activity::class.java)
            startActivity(intent)
        }

        val image2 = findViewById<ImageView>(R.id.ive_2)
        image2.setOnClickListener {
            Toast.makeText(this, "2번 클릭 완료", Toast.LENGTH_LONG).show()
            val intent = Intent(this, Ive2Activity::class.java)
            startActivity(intent)
        }
        val image3 = findViewById<ImageView>(R.id.ive_3)
        image3.setOnClickListener {
            Toast.makeText(this, "3번 클릭 완료", Toast.LENGTH_LONG).show()
            val intent = Intent(this, Ive3Activity::class.java)
            startActivity(intent)
        }

    }
}
