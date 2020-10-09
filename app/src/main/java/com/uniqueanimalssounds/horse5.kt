package com.uniqueanimalssounds

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.Toast

class horse5 : AppCompatActivity() {

    lateinit var horse1: MediaPlayer
    lateinit var horse2: MediaPlayer
    lateinit var btnhorse: Button
    lateinit var btncow: Button
    lateinit var btnbird: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.horse)
        horse1= MediaPlayer.create(this,R.raw.horse1)
        horse2= MediaPlayer.create(this,R.raw.horse2)
           btnhorse=findViewById(R.id.btnhorse)
        btncow=findViewById(R.id.btncow)
        btnbird=findViewById(R.id.btnbird)

    }
    override fun onUserLeaveHint() {
        super.onUserLeaveHint()
        if (this.horse1.isPlaying||this.horse2.isPlaying) {
            horse1.stop()
            horse2.stop()
            horse1.release()
            horse2.release()
        }
    }
    override fun onBackPressed() {
        //super.onBackPressed()
        if (this.horse1.isPlaying||this.horse2.isPlaying) {
            horse1.stop()
            horse2.stop()
            horse1.release()
            horse2.release()
        }
        startActivity(Intent(this, bird4::class.java))

    }
    override fun onStart() {
        super.onStart()
        if(!horse1.isPlaying){
            horse1.start()

        }
        horse1.setOnCompletionListener {
            horse2.start()
        }


        //Toast.makeText(this,"on start", Toast.LENGTH_SHORT).show()
        btnbird.setOnClickListener {
            if (this.horse1.isPlaying||this.horse2.isPlaying) {
                horse1.stop()
                horse2.stop()
                horse1.release()
                horse2.release()
            }
            startActivity(Intent(this, bird4::class.java))
        }

        btncow.setOnClickListener {
            if (this.horse1.isPlaying||this.horse2.isPlaying) {
                horse1.stop()
                horse2.stop()
                horse1.release()
                horse2.release()
            }
            startActivity(Intent(this, cow6::class.java))
        }
    }
    
    
}