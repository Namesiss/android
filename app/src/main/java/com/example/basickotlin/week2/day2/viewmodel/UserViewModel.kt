package com.example.basickotlin.week2.day2.viewmodel

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.basickotlin.week2.day2.model.User

class UserViewModel : ViewModel(), Observable {
    val isStringEmpty = MutableLiveData<Boolean>()
    @Bindable
    val inputName = MutableLiveData<String>()
    @Bindable
    val inputEmail = MutableLiveData<String>()
    val list = MutableLiveData<ArrayList<User>>()
    private val arrayList = ArrayList<User>()


    init {
        isStringEmpty.value = false
    }

    fun addData() {
        val name = inputName.value!!
        val email = inputEmail.value!!

        if(name.isBlank() || email.isBlank()){
            isStringEmpty.value = true
        }
        else {
            inputName.value = " "
            inputEmail.value = " "
            var userItem = User(name, email)
            arrayList.add(userItem)
            list.value = arrayList
        }
    }

    fun clearData() {
        arrayList.clear()
        list.value = arrayList
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }


}




