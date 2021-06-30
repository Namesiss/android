package com.example.basickotlin.week2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.basickotlin.R
import com.example.basickotlin.week2.day1.MainActivity as M1
import com.example.basickotlin.week2.day2.MainActivity as M2
import kotlinx.android.synthetic.main.activity_main13.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main13)
        val listener = View.OnClickListener { view ->
            when(view.getId()) {
                R.id.btnW2Day1 ->
                    startActivity(Intent(this, M1::class.java))
                R.id.btnW2Day2 ->
                    startActivity(Intent(this, M2::class.java))
//                R.id.btnW2Day3 ->
//                    startActivity(Intent(this,  com.example.basickotlin.week1.day3.MainActivity::class.java))
//                R.id.btnW2Day4 ->
//                    startActivity(Intent(this, com.example.basickotlin.week1.day4.MainActivity::class.java))
//                R.id.btnW2Day5 ->
//                    startActivity(Intent(this, com.example.basickotlin.week1.day5.MainActivity::class.java))
            }
        }

        btnW2Day1.setOnClickListener(listener)
        btnW2Day2.setOnClickListener(listener)
        btnW2Day3.setOnClickListener(listener)
        btnW2Day4.setOnClickListener(listener)
        btnW2Day5.setOnClickListener(listener)
    }

}