package com.example.recyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewapp.databinding.ActivityMainBinding
import com.example.recyclerviewapp.models.Item
import com.example.recyclerviewapp.adapters.MyAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var adapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize RecyclerView
        recyclerView = binding.recyclerView
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create adapter and set to RecyclerView
        adapter = MyAdapter(listOf(Item("Item 1"), Item("Item 2"), Item("Item 3")))
        recyclerView.adapter = adapter

        // Optional: Add click listener
        recyclerView.addOnItemTouchListener(object : RecyclerView.OnItemTouchListener {
            override fun onTouchEvent(recyclerView: RecyclerView, e: android.view MotionEvent) {
                // Handle touch events if needed
            }
            override fun getTouchHelper(recyclerView: RecyclerView): ItemTouchHelper? {
                return null
            }
        })
    }
}
