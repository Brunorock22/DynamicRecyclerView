package com.example.recyclerstudying

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val companies = listOf<String>("Apple", "Google", "Amazon", "Tesla")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_recycler.apply {
            adapter = RecyclerAdapter(companies)
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }
}