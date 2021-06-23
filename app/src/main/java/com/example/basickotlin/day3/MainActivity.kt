package com.example.basickotlin.day3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.basickotlin.R
import com.example.basickotlin.day3.musicplayer.MainActivity as MP
import com.example.basickotlin.day3.contentprovider.MainActivity as CP
import com.example.basickotlin.day3.broadcast.MainActivity as BC
import kotlinx.android.synthetic.main.activity_main6.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)
        val listener = View.OnClickListener { view ->
            when(view.id){
                R.id.btnMusicPlayer -> {
                    startActivity(Intent(this, MP::class.java))
                }
                R.id.btnBroadcast -> {
                    startActivity(Intent(this, BC::class.java))
                }
                R.id.btnContentProvider -> {
                    startActivity(Intent(this, CP::class.java))
                }

            }
        }

        btnMusicPlayer.setOnClickListener(listener)
        btnContentProvider.setOnClickListener(listener)
        btnBroadcast.setOnClickListener(listener)

    }
}