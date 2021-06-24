package com.example.basickotlin.day4

import android.Manifest
import android.content.ContentUris
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.ParcelFileDescriptor
import android.provider.MediaStore
import android.util.Log
import android.util.Size
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.basickotlin.R
import kotlinx.android.synthetic.main.activity_main9.*
import java.io.FileDescriptor


class MainActivity : AppCompatActivity() {
    lateinit var listSong: MutableList<Song>
    private lateinit var adapter: SongAdapter
    lateinit var thumbSize: Size

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main9)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            thumbSize = Size(110, 110)
        }

        listSong = mutableListOf()
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                Array(1) { Manifest.permission.READ_EXTERNAL_STORAGE },
                11
            )
        } else loadAudio()


        rvSongList.adapter = SongAdapter(listSong)
        rvSongList.layoutManager = LinearLayoutManager(this)

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 11 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            loadAudio()
        }
    }


    private fun loadAudio() {
        var uri: Uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
        var selection: String = MediaStore.Audio.Media.IS_MUSIC + "!= 0";
        var sortOrder: String = MediaStore.Audio.Media.TITLE + " ASC"
        var cursor = contentResolver.query(uri, null, selection,null,sortOrder )

        if(cursor != null && cursor.count > 0){
            while(cursor.moveToNext()){
                var _id : String = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media._ID))
                var id : Long = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM_ID))
                var bm: Bitmap = getAlbumart(id)
                var title : String = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE))
                var album : String = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM))
                var artist : String = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST))
                val song = Song(_id ,title ,album, artist, bm)
                Log.d("DATA", "ADDED SONG: " + song.toString())
                listSong.add(song)

            }
            cursor.close()
        }
    }

    private fun getAlbumArtwork(albumId : Long) : Bitmap {
        var contentUri : Uri = ContentUris.withAppendedId(
                MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI,
        albumId
        );

        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            contentResolver.loadThumbnail(contentUri, thumbSize, null)
        } else {
            return BitmapFactory.decodeResource(
                this.getResources(),
                R.drawable.image)
        };
    }

    fun getAlbumart(album_id: Long): Bitmap {
        var bm: Bitmap = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.image)
        try {
            val sArtworkUri = Uri
                .parse("content://media/external/audio/albumart")
            val uri = ContentUris.withAppendedId(sArtworkUri, album_id)
            var pfd: ParcelFileDescriptor? = contentResolver.openFileDescriptor(uri, "r")
            if (pfd != null) {
                val fd: FileDescriptor = pfd.fileDescriptor
                bm = BitmapFactory.decodeFileDescriptor(fd)
            }
        } catch (e: Exception) {
        }
        return bm
    }

}