package com.ckworld.iveapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ImageInsideActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_image_inside)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val memberImage = findViewById<ImageView>(R.id.memberImageArea)
        val index = intent.getStringExtra("index")
        // Toast.makeText(this, index, Toast.LENGTH_LONG).show()
        /*
        if (index == "1")
            memberImage.setImageResource(R.drawable.ive1)
        if (index == "2")
            memberImage.setImageResource(R.drawable.ive2)
        if (index == "3")
            memberImage.setImageResource(R.drawable.ive3)
        if (index == "4")
            memberImage.setImageResource(R.drawable.ive4)
        if (index == "5")
            memberImage.setImageResource(R.drawable.ive5)
        if (index == "6")
            memberImage.setImageResource(R.drawable.ive6)
         */
        val drawableIds = listOf(
            R.drawable.ive1, R.drawable.ive2, R.drawable.ive3,
            R.drawable.ive4, R.drawable.ive5, R.drawable.ive6
        )
        val names = listOf("유진", "가을", "원영", "리즈", "레이", "이서")
        val memberText = findViewById<TextView>(R.id.memberTextArea)
        val idx = index?.toInt()
        if (idx != null) {
            memberImage.setImageResource(drawableIds[idx - 1])
            memberText.setText(names[idx - 1])
        }

    }
}