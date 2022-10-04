package com.example.ttc

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class playWin : AppCompatActivity() {
    private lateinit var winsound: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_win)

        winsound= MediaPlayer.create(this,R.raw.congrats)
        winsound.start()
        val img:ImageView=findViewById(R.id.img)
        img.setImageResource(R.drawable.party)

      val intent=intent
        val txt :TextView=findViewById(R.id.win)

        txt.append(intent.getStringExtra("winner"))

    }
}