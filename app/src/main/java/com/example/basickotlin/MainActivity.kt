package com.example.basickotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import com.example.basickotlin.week1.MainActivity as W1
import com.example.basickotlin.week2.day1.MainActivity as W2

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listener = View.OnClickListener { view ->
            when(view.getId()) {
                R.id.btnWeek1 ->
                    startActivity(Intent(this, W1::class.java))
                R.id.btnWeek2 ->
                    startActivity(Intent(this, W2::class.java))
//                R.id.btnDay3 ->
//                    startActivity(Intent(this, M3::class.java))
//                R.id.btnDay4 ->
//                    startActivity(Intent(this, M4::class.java))
//                R.id.btnDay5 ->
//                    startActivity(Intent(this, M5::class.java))
            }
        }

        btnWeek1.setOnClickListener(listener)
        btnWeek2.setOnClickListener(listener)
//        btnDay3.setOnClickListener(listener)
//        btnDay4.setOnClickListener(listener)
//        btnDay5.setOnClickListener(listener)
    }


}