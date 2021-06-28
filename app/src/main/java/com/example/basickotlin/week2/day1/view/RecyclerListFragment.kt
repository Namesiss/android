package com.example.basickotlin.week2.day1.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.basickotlin.R
import com.example.basickotlin.week2.day1.adapter.RecyclerViewAdapter
import com.example.basickotlin.week2.day1.model.RecyclerList
import com.example.basickotlin.week2.day1.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.fragment_recycler_list.*


class RecyclerListFragment : Fragment() {
    private lateinit var recyclerViewAdapter : RecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_recycler_list, container, false)
        initViewModel(view)
        initViewModel()
        return view
    }

    private fun initViewModel(view: View){
        recycler_View.layoutManager = LinearLayoutManager(activity)
        val decoration = DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
        recycler_View.addItemDecoration(decoration)
        recyclerViewAdapter = RecyclerViewAdapter()
        recycler_View.adapter = recyclerViewAdapter
    }

    private fun initViewModel(){
        //Gọi từ livemodel
        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        //Observer livedata
        viewModel.getRecyclerListObserver().observe(viewLifecycleOwner, Observer<RecyclerList> {
            if ( it != null){
                recyclerViewAdapter.setUpdatedData(it.items)
            } else {
                Toast.makeText(activity, "ERROR IN GETTING DATA", Toast.LENGTH_LONG).show()
            }
        })

        viewModel.makeApiCall()
    }
    companion object {
        @JvmStatic
        fun newInstance() =
            RecyclerListFragment()
    }
}