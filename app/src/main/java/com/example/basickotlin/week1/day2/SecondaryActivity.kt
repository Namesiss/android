package com.example.basickotlin.week1.day2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.basickotlin.MainActivity
import com.example.basickotlin.R

class SecondaryActivity : AppCompatActivity() {
    private var TAG: String = "SecondaryActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondary)
        Log.e(TAG, "onCreate đã kích hoạt")
    }

    override fun onStart() {
        super.onStart()
        Log.e(TAG,"onStart đã kích hoạt" )
    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG,"onResume đã kích hoạt" )
    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG,"onPause đã kích hoạt" )
    }

    override fun onStop() {
        super.onStop()
        Log.e(TAG,"onStop đã kích hoạt" )
    }

    override fun onRestart() {
        super.onRestart()
        Log.e(TAG,"onRestart đã kích hoạt" )
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG,"onDestroy đã kích hoạt" )
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent= Intent(this, MainActivity::class.java).apply {
            setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        }

        startActivity(intent)
    }
}