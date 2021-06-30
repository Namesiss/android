package com.example.basickotlin.week1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.basickotlin.R
import kotlinx.android.synthetic.main.activity_main12.*
import com.example.basickotlin.week1.day1.MainActivity as M1
import com.example.basickotlin.week1.day2.MainActivity as M2
import com.example.basickotlin.week1.day3.MainActivity as M3
import com.example.basickotlin.week1.day4.MainActivity as M4
import com.example.basickotlin.week1.day5.MainActivity as M5
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main12)
        val listener = View.OnClickListener { view ->
            when(view.getId()) {
                R.id.btnW1Day1 ->
                    startActivity(Intent(this, M1::class.java))
                R.id.btnW1Day2 ->
                    startActivity(Intent(this, M2::class.java))
                R.id.btnW1Day3 ->
                    startActivity(Intent(this,  M3::class.java))
                R.id.btnW1Day4 ->
                    startActivity(Intent(this, M4::class.java))
                R.id.btnW1Day5 ->
                    startActivity(Intent(this, M5::class.java))
            }
        }

        btnW1Day1.setOnClickListener(listener)
        btnW1Day2.setOnClickListener(listener)
        btnW1Day3.setOnClickListener(listener)
        btnW1Day4.setOnClickListener(listener)
        btnW1Day5.setOnClickListener(listener)
    }

}