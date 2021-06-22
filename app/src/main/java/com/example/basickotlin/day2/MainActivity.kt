package com.example.basickotlin.day2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.basickotlin.R

class MainActivity : AppCompatActivity() {
    private var TAG: String = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        Log.e(TAG,"onCreate đã kích hoạt" )

        findViewById<Button>(R.id.btn_nav).setOnClickListener {
            startActivity(Intent(this, SecondaryActivity::class.java))
        }
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
}