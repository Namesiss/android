package com.example.basickotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var toDoAdapter: ToDoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toDoAdapter = ToDoAdapter(mutableListOf())
        rvTodoItems.adapter = toDoAdapter
        rvTodoItems.layoutManager = LinearLayoutManager(this)

        btnAdd.setOnClickListener {
            val tdTitle = textTodo.text.toString()
            println(tdTitle)
            if(tdTitle.isNotEmpty()) {
                val todo = ToDo(tdTitle)
                toDoAdapter.addToDo(todo)
                textTodo.text.clear()
            }
        }

        btnDelete.setOnClickListener {
            toDoAdapter.deleteDoneTodos()
        }
    }
}