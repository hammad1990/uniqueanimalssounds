package com.uniqueanimalssounds

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.Toast

class cow6 : AppCompatActivity() {
    lateinit var cow1: MediaPlayer
    lateinit var cow2: MediaPlayer
    lateinit var btncow: Button
    lateinit var btnhorse: Button
    lateinit var btnbear: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cow)
        cow1 = MediaPlayer.create(this, R.raw.cow1)
        cow2 = MediaPlayer.create(this, R.raw.cow2)

        btnhorse = findViewById(R.id.btnhorse)
        btncow = findViewById(R.id.btncow)
        btnbear = findViewById(R.id.btnbear)
    }
    override fun onUserLeaveHint() {
        super.onUserLeaveHint()
        if (this.cow1.isPlaying||this.cow2.isPlaying) {
            cow1.stop()
            cow2.stop()
            cow1.release()
            cow2.release()
        }
    }
    override fun onBackPressed() {
        //super.onBackPressed()
        if (this.cow1.isPlaying||this.cow2.isPlaying) {
            cow1.stop()
            cow2.stop()
            cow1.release()
            cow2.release()
        }
        startActivity(Intent(this, horse5::class.java))

    }
    override fun onStart() {
        super.onStart()
        if(!cow1.isPlaying){
            cow1.start()

        }
        cow1.setOnCompletionListener {
            cow2.start()
        }


       // Toast.makeText(this,"on start", Toast.LENGTH_SHORT).show()
        btnhorse.setOnClickListener {
            if (this.cow1.isPlaying||this.cow2.isPlaying) {
                cow1.stop()
                cow2.stop()
                cow1.release()
                cow2.release()
            }
            startActivity(Intent(this, horse5::class.java))
        }

        btnbear.setOnClickListener {
            if (this.cow1.isPlaying||this.cow2.isPlaying) {
                cow1.stop()
                cow2.stop()
                cow1.release()
                cow2.release()
            }
            startActivity(Intent(this, bear7::class.java))
        }
    }
    
    
}