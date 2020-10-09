package com.uniqueanimalssounds

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.Toast

class donkey2 : AppCompatActivity() {

    lateinit var donkey1: MediaPlayer
    lateinit var donkey2: MediaPlayer
    lateinit var btndonkey: Button
    lateinit var btnmonkey: Button
    lateinit var btnlion: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.donkey)
        donkey1= MediaPlayer.create(this,R.raw.donkey1)
        donkey2= MediaPlayer.create(this,R.raw.donkey2)
        btndonkey=findViewById(R.id.btndonkey)
        btnmonkey=findViewById(R.id.btnmonkey)
        btnlion=findViewById(R.id.btnlion)
        startSound()
        //Toast.makeText(this,"on create",Toast.LENGTH_SHORT).show()
    }

    override fun onUserLeaveHint() {
        super.onUserLeaveHint()
        if (this.donkey1.isPlaying||this.donkey2.isPlaying) {
            donkey1.stop()
            donkey2.stop()
           // donkey1.release()
         //  donkey2.release()
        }
    }
    override fun onBackPressed() {
      super.onBackPressed()
        if (this.donkey1.isPlaying||this.donkey2.isPlaying) {
            donkey1.stop()
            donkey2.stop()
           // donkey1.release()
           // donkey2.release()
        }
        //startActivity(Intent(this, lion1::class.java))
    }
    private fun startSound() {

       if(!donkey1.isPlaying){


           donkey1.start()

       }
       donkey1.setOnCompletionListener {

           donkey2.start()
       }
       btnmonkey.setOnClickListener {
           if (this.donkey1.isPlaying||this.donkey2.isPlaying) {
               donkey1.stop()
               donkey2.stop()
               donkey1.release()
               donkey2.release()
           }
          var myintent=Intent(this,monkey3::class.java)
           startActivity(myintent)
       }

       btnlion.setOnClickListener {
           if (this.donkey1.isPlaying||this.donkey2.isPlaying) {
               donkey1.stop()
               donkey2.stop()
               donkey1.release()
               donkey2.release()
           }
           var myintent= Intent(this,lion1::class.java)
           startActivity(myintent)
       }
    }



}