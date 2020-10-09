package com.uniqueanimalssounds

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.Toast

class lion1 : AppCompatActivity() {

    private lateinit var lion1:MediaPlayer
    private  lateinit var lion2:MediaPlayer
    private  lateinit var btndonkey:Button
    private  lateinit var btnlion:Button
    var length:Int?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lion)
        lion1= MediaPlayer.create(this,R.raw.lion1)
        lion2= MediaPlayer.create(this,R.raw.lion2)
        btndonkey=findViewById(R.id.btndonkey)
        btnlion=findViewById(R.id.btnlion)
        //length=lion2.duration
       //Toast.makeText(this,length.toString(),Toast.LENGTH_SHORT).show()
        startSound()
    }
// hOME Button pressed
    override fun onUserLeaveHint() {
        super.onUserLeaveHint()
        if (this.lion1.isPlaying||this.lion2.isPlaying) {
            lion1.stop()
            lion2.stop()
           // lion1.release()
           // lion2.release()
        }

    }
    override fun onBackPressed() {
       // super.onBackPressed()
        if (this.lion1.isPlaying||this.lion2.isPlaying) {
            lion1.stop()
            lion2.stop()
            lion1.release()
            lion2.release()
        }
    }
    private fun startSound() {


           lion1.start()


       lion1.setOnCompletionListener {

           lion2.start()
       }


      //  Toast.makeText(this,"on start",Toast.LENGTH_SHORT).show()
        btndonkey.setOnClickListener {
            if (this.lion1.isPlaying||this.lion2.isPlaying) {
                lion1.stop()
                lion2.stop()
                lion1.release()
                lion2.release()
            }
            startActivity(Intent(this,donkey2::class.java))
        }
    }


}


