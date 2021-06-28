package com.example.basickotlin.week1.day2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Button
import com.example.basickotlin.R
import com.example.basickotlin.databinding.ActivityMain3Binding
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {
    private var TAG: String = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMain3Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val viewPager = binding.viewPager
        val navigationView = binding.navigationView

        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        viewPager.adapter = adapter
        viewPager.setPageTransformer(ZoomOutPageTransformer())

//        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
//            override fun onPageSelected(position: Int) {
//                when(position){
//                    0 -> navigationView.menu.findItem(R.id.item_menu_1).setEnabled(true)
//                    1 -> navigationView.menu.findItem(R.id.item_menu_2).setEnabled(true)
//                    2 -> navigationView.menu.findItem(R.id.item_menu_3).setEnabled(true)
//                }
//            }
//        }
//        )

        navigationView.setOnItemSelectedListener(object : NavigationBarView.OnItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when(item.itemId){
                    R.id.item_menu_1 -> {
                        viewPager.setCurrentItem(0)
                    }
                    R.id.item_menu_2 -> {
                        viewPager.setCurrentItem(1)
                    }
                    R.id.item_menu_3 -> {
                        viewPager.setCurrentItem(2)
                    }
                }
                return true
            }

        })
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