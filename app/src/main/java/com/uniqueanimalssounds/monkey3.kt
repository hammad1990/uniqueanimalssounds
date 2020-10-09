package com.uniqueanimalssounds

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.Toast

class monkey3 : AppCompatActivity() {
    lateinit var monkey1: MediaPlayer
    lateinit var monkey2: MediaPlayer
    lateinit var btndonkey: Button
    lateinit var btnmonkey: Button
    lateinit var btnbird: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.monkey)
        monkey1= MediaPlayer.create(this,R.raw.monkey1)
        monkey2= MediaPlayer.create(this,R.raw.monkey2)
        btndonkey=findViewById(R.id.btndonkey)
        btnmonkey=findViewById(R.id.btnmonkey)
        btnbird=findViewById(R.id.btnbird)

    }
    override fun onUserLeaveHint() {
        super.onUserLeaveHint()
        if (this.monkey1.isPlaying||this.monkey2.isPlaying) {
            monkey1.stop()
            monkey2.stop()
        }
    }
    override fun onBackPressed() {
       // super.onBackPressed()
        if (this.monkey1.isPlaying||this.monkey2.isPlaying) {
            monkey1.stop()
            monkey2.stop()
           // monkey1.release()
           // monkey2.release()
        }
        startActivity(Intent(this, donkey2::class.java))

    }
    override fun onStart() {
        super.onStart()
        if(!monkey1.isPlaying){
            monkey1.start()
        }
        monkey1.setOnCompletionListener {
            monkey2.start()
        }
      //  Toast.makeText(this,"on start", Toast.LENGTH_SHORT).show()
        btnbird.setOnClickListener {
            if (this.monkey1.isPlaying||this.monkey2.isPlaying) {
                monkey1.stop()
                monkey2.stop()
               // monkey1.release()
                //monkey2.release()
            }
           // startActivity(Intent(this, bird4::class.java))
        }

        btndonkey.setOnClickListener {
            if (this.monkey1.isPlaying||this.monkey2.isPlaying) {
                monkey1.stop()
                monkey2.stop()
               // monkey1.release()
                //monkey2.release()
            }
            startActivity(Intent(this, donkey2::class.java))
        }
    }

}