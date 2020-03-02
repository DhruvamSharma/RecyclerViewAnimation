package com.example.recyclerviewanimation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewanimation.adapter.CustomRecyclerViewAdapter
import com.example.recyclerviewanimation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerview()
    }

    private fun setupRecyclerview() {
        val adapter: CustomRecyclerViewAdapter = CustomRecyclerViewAdapter()
        val layoutManager: LinearLayoutManager = LinearLayoutManager(applicationContext)
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = layoutManager
    }
}