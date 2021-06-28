package com.example.basickotlin.week2.day1

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
import androidx.recyclerview.widget.RecyclerView
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
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_View)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        val decoration = DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(decoration)

        recyclerViewAdapter = RecyclerViewAdapter()
        recyclerView.adapter = recyclerViewAdapter
    }

    private fun initViewModel(){
        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
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