package com.example.basickotlin.day2


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

private const val NUMB_TABS = 3
class ViewPagerAdapter(fm : FragmentManager, lifecycle : Lifecycle) :  FragmentStateAdapter(fm, lifecycle){
    override fun getItemCount(): Int {
        return NUMB_TABS
    }

    override fun createFragment(position: Int): Fragment {
        when(position){
            0 -> return Page1Fragment()
            1 -> return Page2Fragment()
        }
        return Page3Fragment()
    }
}