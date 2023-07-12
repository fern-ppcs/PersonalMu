package com.egci428.personalmu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {
    var uname: String? = null
    var pname: String? = null

    private val file = "users.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val signInBtn = findViewById<Button>(R.id.signInBtn)
        val signUpBtn = findViewById<Button>(R.id.signUpBtn)
        val cancelBtn = findViewById<Button>(R.id.cancelBtn)
        val userText = findViewById<EditText>(R.id.userText)
        val passText = findViewById<EditText>(R.id.passText)

        signUpBtn.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
        signInBtn.setOnClickListener {
            uname = userText.text.toString()
            pname = passText.text.toString()
            if (!uname.isNullOrEmpty() && !pname.isNullOrEmpty()) {
                var loginSuccessful = false  // Flag to track login success
                try {
                    val fIn = openFileInput(file)
                    val mfile = InputStreamReader(fIn)
                    val br = BufferedReader(mfile)
                    var line = br.readLine()
                    while (line != null) {
                        val userItem = line.split(",")
                        if (userItem[0] == uname && userItem[1] == pname) {
                            loginSuccessful = true  // Set the flag to true
                            val dataToSend = if (line.contains("Warm")) 0 else 1
                            Toast.makeText(applicationContext, "Login Success", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, Drawer::class.java)
                            intent.putExtra("dataToSend", dataToSend)
                            startActivity(intent)
                            break  // Exit the loop when login is successful
                        }
                        line = br.readLine()
                    }
                    br.close()
                    mfile.close()
                    fIn.close()

                    if (!loginSuccessful) {
                        // Show error message if login was not successful
                        Toast.makeText(applicationContext, "User name or password is incorrect", Toast.LENGTH_SHORT).show()
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
        cancelBtn.setOnClickListener {
            userText.text = null
            passText.text = null
        }
    }
}
