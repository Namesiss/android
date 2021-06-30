package com.example.basickotlin.week2.day1.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.basickotlin.week2.day1.model.RecyclerList
import com.example.basickotlin.week2.day1.network.RetroInstance
import com.example.basickotlin.week2.day1.network.RetroService
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class MainActivityViewModel: ViewModel() {
    var recyclerListLiveData : MutableLiveData<RecyclerList> = MutableLiveData()

    fun getRecyclerListObserver() : MutableLiveData<RecyclerList> {
        return recyclerListLiveData
    }

    fun makeApiCall() {
        viewModelScope.launch(Dispatchers.IO) {
            val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
            val response = retroInstance.getDataFromApi("ny")
            recyclerListLiveData.postValue(response)
        }
    }
}