package com.example.room_exam_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this)[MainViewModel::class.java]

        viewModel.getAll().observe(this, Observer {
            result_text.text = it.toString()
        })


        add_button.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO) {
                viewModel.insert(Todo(todo_edit.text.toString()))
            }
        }
    }
}
