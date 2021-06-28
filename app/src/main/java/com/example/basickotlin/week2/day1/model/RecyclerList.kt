package com.example.basickotlin.week2.day1.model

data class RecyclerList(val items: ArrayList<RecyclerData>)
data class RecyclerData(val name: String, val description:String, val owner : Owner)
data class Owner(val avatar_url: String)