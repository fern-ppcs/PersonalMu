package com.egci428.personalmu

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast
import android.widget.RadioGroup

class Question : AppCompatActivity() {
    private lateinit var radioGroup: RadioGroup
    private lateinit var radioGroup2: RadioGroup
    private lateinit var radioGroup3: RadioGroup
    var user_name = " "
    var password = " "
    var tone = " "
    var warm = 0
    var cool = 0
    private val file = "users.txt"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        val submitBtn = findViewById<Button>(R.id.submitBtn)


        radioGroup = findViewById(R.id.radioGroup)
        radioGroup2 = findViewById(R.id.radioGroup2)
        radioGroup3 = findViewById(R.id.radioGroup3)

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
//            RadioGroup.OnCheckedChangeListener { group, checkedId ->
//                val radio: RadioButton = findViewById(checkedId)
//                Toast.makeText(applicationContext," On checked change :"+
//                        " ${radio.text}",
//                    Toast.LENGTH_SHORT).show()
//            }
            when(checkedId){
                R.id.green ->{warm += 1}
                R.id.purple ->{cool +=1}
            }
        }

        radioGroup2.setOnCheckedChangeListener { group, checkedId ->
//            RadioGroup.OnCheckedChangeListener { group, checkedId ->
//                val radio: RadioButton = findViewById(checkedId)
//                Toast.makeText(applicationContext," On checked change :"+
//                        " ${radio.text}",
//                    Toast.LENGTH_SHORT).show()
//            }
            when(checkedId){
                R.id.dark ->{warm += 1}
                R.id.red ->{cool +=1}
            }
        }

        radioGroup3.setOnCheckedChangeListener { group, checkedId ->
//            RadioGroup.OnCheckedChangeListener { group, checkedId ->
//                val radio: RadioButton = findViewById(checkedId)
//                Toast.makeText(applicationContext," On checked change :"+
//                        " ${radio.text}",
//                    Toast.LENGTH_SHORT).show()
//            }
            when(checkedId){
                R.id.gold ->{warm += 1}
                R.id.silver ->{cool +=1}
            }
        }


        submitBtn.setOnClickListener {
            if (warm > cool){
                tone = "Warm tone"
            } else { tone = "Cool tone"}
            user_name = intent.getStringExtra("user").toString()
            password = intent.getStringExtra("pw").toString()
            saveData(user_name,password,tone)
            Log.d("warm tone",tone)
            val intent = Intent(this, PersonalColor::class.java)
            intent.putExtra("Tone",tone)
            startActivity(intent)
        }
    }

    private fun saveData(username: String, passw: String, skintone: String) {

        val userData = User(username = username, password = passw, tone= skintone) //user object
        val  line = userData.username + "," + userData.password +","+userData.tone + "\n"
        Log.d("Quser1",user_name)
        Log.d("Qpass1",password)
        try {
            val fOut = openFileOutput(file, Context.MODE_APPEND)
            fOut.write(line.toByteArray())
            fOut.close()
            Toast.makeText(applicationContext,"Data saved successfully", Toast.LENGTH_SHORT).show()
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

}