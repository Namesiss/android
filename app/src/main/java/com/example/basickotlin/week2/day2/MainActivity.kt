package com.example.basickotlin.week2.day2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.basickotlin.R
import com.example.basickotlin.databinding.ActivityMain14Binding
import com.example.basickotlin.week2.day1.viewmodel.ViewModelFactory
import com.example.basickotlin.week2.day2.model.User
import com.example.basickotlin.week2.day2.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel : UserViewModel
    private lateinit var dataBinding: ActivityMain14Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main14)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main14)
        val factory = ViewModelFactory()
        viewModel = ViewModelProvider(this, factory).get(UserViewModel::class.java)
        dataBinding.userViewModel = viewModel
        dataBinding.lifecycleOwner = this
        viewModel.list.observe(this, Observer {
            dataBinding.content.text = it.toString()
        })

        viewModel.isStringEmpty.observe(this, Observer {
            if(it == true){
                Toast.makeText(this, "NO NOTES DETECTED",Toast.LENGTH_LONG).show()
            }
        })
    }
}