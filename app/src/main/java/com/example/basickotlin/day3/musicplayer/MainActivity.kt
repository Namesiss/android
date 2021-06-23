package com.example.basickotlin.day3.musicplayer

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.SeekBar
import com.example.basickotlin.R
import kotlinx.android.synthetic.main.activity_main4.*

class MainActivity : AppCompatActivity() {
    lateinit var runnable: Runnable
    private var handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        //Media Player Obj
        songIMG.setImageResource(R.drawable.image)
        txtSongTitle.setText("Basic Music Player")
        val media : MediaPlayer = MediaPlayer.create(this, R.raw.music)
        seekBar.progress = 0
        seekBar.max = media.duration
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if(fromUser){
                    media.seekTo(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })

        runnable = Runnable {
            seekBar.progress = media.currentPosition
            handler.postDelayed(runnable, 1000)
        }

        handler.postDelayed(runnable, 1000)

        media.setOnCompletionListener {
            btnPlay.setImageResource(R.drawable.ic_baseline_play_circle_filled_24)
            seekBar.progress=0
        }
        val listener = View.OnClickListener { view ->
            when(view.id){
                R.id.btnPlay -> {
                    if(!media.isPlaying){
                        media.start()
                        //change img
                        btnPlay.setImageResource(R.drawable.ic_baseline_pause_24)
                    }
                    else {
                        media.pause()
                        btnPlay.setImageResource(R.drawable.ic_baseline_play_circle_filled_24)
                    }
                }
            }
        }

        btnPlay.setOnClickListener(listener)
        btnNext.setOnClickListener(listener)
        btnPrev.setOnClickListener(listener)

    }


}