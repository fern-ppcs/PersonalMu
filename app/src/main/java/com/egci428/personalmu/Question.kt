package com.egci428.personalmu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Question : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)


        val submitBtn = findViewById<Button>(R.id.submitBtn)


        submitBtn.setOnClickListener {
//            saveData()
            val intent = Intent(this, PersonalColor::class.java)
            startActivity(intent)
        }
    }
}