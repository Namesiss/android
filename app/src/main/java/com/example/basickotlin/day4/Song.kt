package com.example.basickotlin.day4

import android.graphics.Bitmap

data class Song(
    var _id : String,
    var title : String,
    var album : String,
    var artist : String,
    var image : Bitmap
)

