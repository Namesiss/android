package com.example.basickotlin

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_todo.view.*

class ToDoAdapter(
    private val todos: MutableList<ToDo>
) : RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder>() {

    class ToDoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        return ToDoViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_todo,
                parent,
                false
            )
        )
    }

    fun addToDo(todo: ToDo){
        println("Title: " + todo.title)
        todos.add(todo)
        notifyItemInserted(todos.size - 1)
    }

    fun deleteDoneTodos(){
        todos.removeAll{
            todo -> todo.isChecked
        }
        notifyDataSetChanged()
    }
    private fun toggleStrikeThrough(tvTodoTitle: TextView, isChecked: Boolean) {
        if(isChecked) {
            tvTodoTitle.paintFlags = tvTodoTitle.paintFlags or STRIKE_THRU_TEXT_FLAG
        } else {
            tvTodoTitle.paintFlags = tvTodoTitle.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()
        }
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        val current = todos[position]
        println("Titlec current: " + current.title)
        holder.itemView.apply {
            tvToDoTitle.text = current.title
            cbItem.isChecked = current.isChecked
            //toggleStrikeThrough(tvToDoTitle, current.isChecked)
            cbItem.setOnCheckedChangeListener { _, isChecked ->
                toggleStrikeThrough(tvToDoTitle, isChecked)
                current.isChecked = !current.isChecked
            }
        }
    }

    override fun getItemCount(): Int {
        return todos.size
    }

}

