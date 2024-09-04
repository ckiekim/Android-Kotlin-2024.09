package com.ckworld.lifequotesapp

import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class QuotesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quotes)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        val listItems = mutableListOf<ListViewModel>()
//        listItems.add(ListViewModel("Java", "Java is bla bla"))
//        listItems.add(ListViewModel("Kotlin", "코틀린은 어쩌구 저쩌구"))
//        listItems.add(ListViewModel("Android Studio", "Android Studio is bla bla"))

        val todayQuotes = intent.getStringExtra("todayQuotes")?.split("\t")
        val listAdapter = ListViewAdapter(todayQuotes!!.toMutableList())
        val listView = findViewById<ListView>(R.id.quotesList)
        listView.adapter = listAdapter
    }
}