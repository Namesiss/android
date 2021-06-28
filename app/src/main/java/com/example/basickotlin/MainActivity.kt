package com.example.basickotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import com.example.basickotlin.day1.MainActivity as M1
import com.example.basickotlin.day2.MainActivity as M2
import com.example.basickotlin.day3.MainActivity as M3
import com.example.basickotlin.day4.MainActivity as M4
import com.example.basickotlin.day5.MainActivity as M5

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listener = View.OnClickListener { view ->
            when(view.getId()) {
                R.id.btnDay1 ->
                    startActivity(Intent(this, M1::class.java))
                R.id.btnDay2 ->
                    startActivity(Intent(this, M2::class.java))
                R.id.btnDay3 ->
                    startActivity(Intent(this, M3::class.java))
                R.id.btnDay4 ->
                    startActivity(Intent(this, M4::class.java))
                R.id.btnDay5 ->
                    startActivity(Intent(this, M5::class.java))
            }
        }

        btnDay1.setOnClickListener(listener)
        btnDay2.setOnClickListener(listener)
        btnDay3.setOnClickListener(listener)
        btnDay4.setOnClickListener(listener)
        btnDay5.setOnClickListener(listener)
    }


}