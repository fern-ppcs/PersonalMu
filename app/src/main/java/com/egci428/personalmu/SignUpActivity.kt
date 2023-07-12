package com.egci428.personalmu

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.egci428.personalmu.model.User
import java.util.*

class SignUpActivity : AppCompatActivity() {

    //private val file = "users.txt"
    //lateinit var usrList: MutableList<User>
    lateinit var userSignText: EditText
    lateinit var passSignText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val addBtn = findViewById<Button>(R.id.addBtn)
        userSignText = findViewById(R.id.editText)
        passSignText = findViewById(R.id.editText2)

        addBtn.setOnClickListener {
            val intent = Intent(this, Question::class.java)
            intent.putExtra("user",userSignText.text.toString())
            intent.putExtra("pw", passSignText.text.toString())
            startActivity(intent)

            Log.d("user",userSignText.text.toString())
            Log.d("upass",passSignText.text.toString())
        }
    }

}
