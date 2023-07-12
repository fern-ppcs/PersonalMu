package com.egci428.personalmu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class PersonalColor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal)
        var tone = intent.getStringExtra("Tone")
        var tv = findViewById<TextView>(R.id.personalColor)
        tv.text = tone

        val returnBtn = findViewById<Button>(R.id.returnBtn)

        returnBtn.setOnClickListener {
//            saveData()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}