package com.example.basickotlin.day2

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.basickotlin.R


class Page1Fragment : Fragment() {

    private var TAG: String = "Fragment"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e(TAG,"onCreate đã kích hoạt" )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.e(TAG,"onCreateView đã kích hoạt" )
        return inflater.inflate(R.layout.fragment_page1, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e(TAG,"onAttach đã kích hoạt" )

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.e(TAG,"onActivityCreated đã kích hoạt" )
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

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e(TAG,"onDestroyView đã kích hoạt" )
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG,"onDestroy đã kích hoạt" )
    }

    override fun onDetach() {
        super.onDetach()
        Log.e(TAG,"onDetach đã kích hoạt" )
    }

}