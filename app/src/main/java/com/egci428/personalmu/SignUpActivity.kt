package com.egci428.personalmu

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

    private val file = "users.txt"
    //lateinit var usrList: MutableList<User>
    lateinit var latText: EditText
    lateinit var lonText: EditText
    lateinit var userSignText: EditText
    lateinit var passSignText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val addBtn = findViewById<Button>(R.id.addBtn)


        addBtn.setOnClickListener {
//            saveData()
            val intent = Intent(this, Question::class.java)
            startActivity(intent)
        }
    }



//    private fun saveData() {
//        val usr = userSignText.text.toString()
//        val pwd = passSignText.text.toString()
//        val lat = latText.text.toString().toDouble()
//        val lon = lonText.text.toString().toDouble()
//        Log.d("Debug", usr)
//        if (usr.isEmpty()) {
//            userSignText.error = "Please enter a username"
//            return
//        }
//
//        val userId = usr
//        val userData = User(usr, pwd, lat, lon) //user object
//        val  line = userData.username + "," + userData.password + "," + userData.latitude + "," + userData.longitude + "\n"
//
//        try {
//            val fOut = openFileOutput(file, Context.MODE_APPEND)
//            fOut.write(line.toByteArray())
//            fOut.close()
//            Toast.makeText(applicationContext,"Data saved successfully", Toast.LENGTH_SHORT).show()
//        }catch (e: Exception){
//            e.printStackTrace()
//        }
//    }
}
