package com.uniqueanimalssounds

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.Toast

class bird4 : AppCompatActivity() {
    lateinit var bird1: MediaPlayer
    lateinit var bird2: MediaPlayer
    lateinit var btnbird: Button
    lateinit var btnmonkey: Button
    lateinit var btnhorse: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bird)
        bird1 = MediaPlayer.create(this, R.raw.bird1)
        bird2 = MediaPlayer.create(this, R.raw.bird2)
        btnbird = findViewById(R.id.btnbird)
        btnmonkey = findViewById(R.id.btnmonkey)
        btnhorse = findViewById(R.id.btnhorse)
    }
    override fun onUserLeaveHint() {
        super.onUserLeaveHint()
        if (this.bird1.isPlaying||this.bird2.isPlaying) {
            bird1.stop()
            bird2.stop()
           // bird1.release()
          //  bird2.release()
        }
    }
    override fun onBackPressed() {
        //super.onBackPressed()
        if (this.bird1.isPlaying||this.bird2.isPlaying) {
            bird1.stop()
            bird2.stop()
           // bird1.release()
           // bird2.release()
        }
        startActivity(Intent(this, monkey3::class.java))
    }
    override fun onStart() {
        super.onStart()
        if(!bird1.isPlaying){
            bird1.start()
        }
        bird1.setOnCompletionListener {
            bird2.start()
        }
       // Toast.makeText(this,"on start", Toast.LENGTH_SHORT).show()
        btnmonkey.setOnClickListener {
            if (this.bird1.isPlaying||this.bird2.isPlaying) {
                bird1.stop()
                bird2.stop()
               // bird1.release()
               // bird2.release()
            }
            startActivity(Intent(this, monkey3::class.java))
        }

        btnhorse.setOnClickListener {
            if (this.bird1.isPlaying||this.bird2.isPlaying) {
                bird1.stop()
                bird2.stop()
               // bird1.release()
               // bird2.release()
            }
            startActivity(Intent(this, horse5::class.java))
        }
    }


}