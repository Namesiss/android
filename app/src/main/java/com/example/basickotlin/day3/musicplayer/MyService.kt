package com.example.basickotlin.day3.musicplayer

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.Build
import android.os.IBinder
import android.provider.Settings
import android.widget.Toast
import com.example.basickotlin.R
import com.example.basickotlin.day3.broadcast.MainActivity

class MyService : Service() {
    lateinit var player : MediaPlayer
    private val binder = LocalBinder()
    val CHANNEL_ID = "channel_service_example"

    inner class LocalBinder : Binder() {
        fun getService() : MyService = this@MyService
    }

    override fun onCreate() {
        super.onCreate()
        player = MediaPlayer.create(this, R.raw.music)
        player.setVolume(100F,100F)
        player.setLooping(true)
    }

    override fun onBind(intent: Intent): IBinder {
        return binder
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when(intent?.action){
            "PLAY" -> {
                player.start()
                sendNotification()
            }
            "PAUSE" -> {
                player.pause()
            }
        }

        return START_STICKY
    }

    private fun sendNotification() {
        //Intent sẽ được mở khi click vào notification
        val pendingItent : PendingIntent = Intent(this, MainActivity::class.java).let {
            notificationIntent ->
            PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT)
        }

        val notification: Notification = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Notification.Builder(this, CHANNEL_ID)
                .setContentTitle("Ứng dụng example đang chạy nền")
                .setContentText("Bài hát đang được phát nèeee")
                .setSmallIcon(R.drawable.image)
                .setContentIntent(pendingItent)
                .build()
        } else {
            TODO("VERSION.SDK_INT < O")
        }

        startForeground(1, notification)
    }
    public fun seekbarGetCurrentPosition(): Int {
        return player.currentPosition
    }

    public fun getDuration() : Int = player.duration


    public fun setTo(progress: Int) {
        return player.seekTo(progress)
    }
    override fun onDestroy() {
        super.onDestroy()
        player.stop()
        player.release()
    }


}