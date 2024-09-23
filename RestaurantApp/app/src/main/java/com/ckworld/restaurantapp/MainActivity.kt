package com.ckworld.restaurantapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val items = mutableListOf<ContentsModel>(
        ContentsModel("https://img.siksinhot.com/place/1453843071299048.jpg?w=560&h=448&c=Y",
            "https://www.siksinhot.com/P/365975", "현대옥 용인죽전점"),
        ContentsModel("https://img.siksinhot.com/place/1453889321503393.jpg?w=560&h=448&c=Y",
            "https://www.siksinhot.com/P/28260", "닐리 수지구청점"),
        ContentsModel("https://img.siksinhot.com/place/1610584358198091.jpg?w=560&h=448&c=Y",
            "https://www.siksinhot.com/P/1248877", "내인생의최고의족발")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val recyclerView = findViewById<RecyclerView>(R.id.rv)
        val rvAdaper = RecyclerViewAdaper(baseContext, items)
        recyclerView.adapter = rvAdaper

        rvAdaper.itemClick = object: RecyclerViewAdaper.ItemClick {
            override fun onClick(view: View, position: Int) {
                val intent = Intent(baseContext, DetailActivity::class.java)
                intent.putExtra("url", items.get(position).pageUrl)
                startActivity(intent)
            }
        }

        recyclerView.layoutManager = GridLayoutManager(this, 2)
    }
}