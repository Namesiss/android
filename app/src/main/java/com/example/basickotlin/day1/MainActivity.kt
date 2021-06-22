package com.example.basickotlin.day1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.basickotlin.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity : AppCompatActivity() {
    private lateinit var toDoAdapter: ToDoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
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