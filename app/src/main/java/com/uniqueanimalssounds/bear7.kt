package com.uniqueanimalssounds

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.Toast

class bear7 : AppCompatActivity() {

    lateinit var bear1: MediaPlayer
    lateinit var bear2: MediaPlayer
    lateinit var btncow: Button
    lateinit var btndog: Button
    lateinit var btnbear: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bear)
        bear1= MediaPlayer.create(this,R.raw.bear1)
        bear2= MediaPlayer.create(this,R.raw.bear2)
        btndog=findViewById(R.id.btndog)
        btncow=findViewById(R.id.btncow)
        btnbear=findViewById(R.id.btnbear)

    }
    override fun onUserLeaveHint() {
        super.onUserLeaveHint()
        if (this.bear1.isPlaying||this.bear2.isPlaying) {
            bear1.stop()
            bear2.stop()
            bear1.release()
            bear2.release()
        }
    }
    override fun onBackPressed() {
        //super.onBackPressed()
        if (this.bear1.isPlaying||this.bear2.isPlaying) {
            bear1.stop()
            bear2.stop()
            bear1.release()
            bear2.release()
        }
        startActivity(Intent(this, cow6::class.java))

    }
    override fun onStart() {
        super.onStart()
        if(!bear1.isPlaying){
            bear1.start()

        }
        bear1.setOnCompletionListener {
            bear2.start()
        }


       // Toast.makeText(this,"on start", Toast.LENGTH_SHORT).show()
        btncow.setOnClickListener {
            if (this.bear1.isPlaying||this.bear2.isPlaying) {
                bear1.stop()
                bear2.stop()
                bear1.release()
                bear2.release()
            }
            startActivity(Intent(this, cow6::class.java))
        }

        btndog.setOnClickListener {
            if (this.bear1.isPlaying||this.bear2.isPlaying) {
                bear1.stop()
                bear2.stop()
                bear1.release()
                bear2.release()
            }
            startActivity(Intent(this, dog8::class.java))
        }
    }
}