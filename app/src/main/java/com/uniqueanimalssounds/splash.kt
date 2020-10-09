package com.uniqueanimalssounds

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash)


        Handler().postDelayed(
            Runnable { startActivity(Intent(this,lion1::class.java))
                finish()}, 2000)
    }
}