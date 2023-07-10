package com.egci428.personalmu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PersonalColor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal)


        val returnBtn = findViewById<Button>(R.id.returnBtn)

        returnBtn.setOnClickListener {
//            saveData()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}