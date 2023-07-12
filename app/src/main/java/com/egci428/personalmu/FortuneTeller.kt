package com.egci428.personalmu

import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import com.google.gson.GsonBuilder
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
import kotlin.random.Random

class FortuneTeller : AppCompatActivity(), SensorEventListener {
    private var sensorManager: SensorManager? = null
    private val client = OkHttpClient()
    private var view: View? = null
    private var lastUpdate: Long =0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fortune_teller)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        lastUpdate = System.currentTimeMillis()

        val closeBtn = findViewById<ImageButton>(R.id.closeBtn)
        closeBtn.setOnClickListener {
            finish()
        }
    }


    private fun getAccelerometer(event: SensorEvent) {
        val values = event.values
        val x = values[0]
        val y = values[1]
        val z = values[2]

        val accel = (x*x + y*y +z*z)/(SensorManager.GRAVITY_EARTH* SensorManager.GRAVITY_EARTH)
        val actualTime = System.currentTimeMillis()


        if(accel >= 2){
            if(actualTime-lastUpdate <200){
                fetchJson()
                return
            }
            lastUpdate = actualTime

        }
    }

    fun fetchJson(){

        val textView = findViewById<TextView>(R.id.textView)
        val jsonURL: String = "https://raw.githubusercontent.com/Proifon/Predictions/main/predictions.json"
        val request = Request.Builder()
            .url(jsonURL)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                response.use {
                    if (!response.isSuccessful) throw IOException("Unexpected code $response")

                    for ((name, value) in response.headers) {
                        println("$name: $value")
                    }

                    val body = response.body!!.string()
                    if(body == null) return@use

                    val gson = GsonBuilder().create()
                    val quotes = gson.fromJson(body, Array<predictions>::class.java)
                    var randomNumber: Int = Random.nextInt(0,21)
                    val quote = quotes[randomNumber]
                    Log.d("TTT", quote.predictions)
                    runOnUiThread{
                        textView.text = quote.predictions
                    }

                }
            }
        })
    }

    override fun onSensorChanged(event: SensorEvent) {
        if(event.sensor.type == Sensor.TYPE_ACCELEROMETER){
            getAccelerometer(event)
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }

    override fun onPause() {
        super.onPause()
        sensorManager!!.unregisterListener(this)
    }

    override  fun onResume(){
        super.onResume()
        sensorManager!!.registerListener(this, sensorManager!!.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL)
    }
}