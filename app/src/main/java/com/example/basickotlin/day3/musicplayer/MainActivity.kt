package com.example.basickotlin.day3.musicplayer

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.media.MediaPlayer
import android.os.*
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.SeekBar
import com.example.basickotlin.R
import kotlinx.android.synthetic.main.activity_main4.*

class MainActivity : AppCompatActivity() {
    lateinit var runnable: Runnable
    private var handler = Handler(Looper.getMainLooper())
    val play: String = "PLAY"
    val pause: String = "PAUSE"
    var myServiceConnection: MyService? = null
    var isPlaying = false
    lateinit var intentService : Intent
    val CHANNEL_ID = "channel_service_example"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        //Initial Service
        intentService = Intent(this, MyService::class.java)
        bindService(intentService, serviceConnection, Context.BIND_AUTO_CREATE)

        //Media Player Object
        songIMG.setImageResource(R.drawable.image)
        txtSongTitle.setText("Sì Gòn đeo lòng qué")

        //Create Notification
        createChannelNotification()


        runnable = Runnable {
            setSeekBar()
            seekBar.progress = myServiceConnection!!.seekbarGetCurrentPosition()
            handler.postDelayed(runnable, 1000)
        }

        handler.postDelayed(runnable, 1000)


        val listener = View.OnClickListener { view ->
            when (view.id) {
                R.id.btnPlay -> {
                    if (!isPlaying) {
                        intentService.setAction(play)
                        startService(intentService)
                        btnPlay.setImageResource(R.drawable.ic_baseline_pause_24)
                        isPlaying = true
                    } else {
                        intentService.setAction(pause)
                        startService(intentService)
                        btnPlay.setImageResource(R.drawable.ic_baseline_play_circle_filled_24)
                        isPlaying = false
                    }
                }
            }
        }

        btnPlay.setOnClickListener(listener)
        btnNext.setOnClickListener(listener)
        btnPrev.setOnClickListener(listener)

    }

    private val serviceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            val binder = service as MyService.LocalBinder
            myServiceConnection = binder.getService()
        }

        override fun onServiceDisconnected(name: ComponentName?) {
        }

    }

    private fun setSeekBar(){
        seekBar.progress = 0
        seekBar.max = myServiceConnection?.getDuration()!!

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    myServiceConnection?.setTo(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })
    }

    private fun createChannelNotification() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            var channel  = NotificationChannel(CHANNEL_ID,
                "Service example",
            NotificationManager.IMPORTANCE_DEFAULT)

            var manager : NotificationManager = getSystemService(NotificationManager::class.java)
            if(manager!=null){
                manager.createNotificationChannel(channel)
            }
        }

    }


}