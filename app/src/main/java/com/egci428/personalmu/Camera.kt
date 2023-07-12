package com.egci428.personalmu


import android.Manifest
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts


class Camera: AppCompatActivity() {

    lateinit var photoBtn: Button
    lateinit var imageView1: ImageView
    lateinit var imageView2: ImageView
    lateinit var imageView3: ImageView
    lateinit var imageView4: ImageView
    lateinit var textView1: TextView
    lateinit var textView2: TextView
    lateinit var textView3: TextView
    lateinit var textView4: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)

        photoBtn = findViewById(R.id.photoBtn)
        imageView1 = findViewById(R.id.photo1)
        imageView2 = findViewById(R.id.photo2)
        imageView3 = findViewById(R.id.photo3)
        imageView4 = findViewById(R.id.photo4)
        textView1 = findViewById(R.id.autumn)
        textView2 = findViewById(R.id.summer)
        textView3 = findViewById(R.id.winter)
        textView4 = findViewById(R.id.spring)
        val closeBtn = findViewById<ImageButton>(R.id.closeBtn)

        closeBtn.setOnClickListener {
            val colorIntent = Intent(this, Drawer::class.java)
            startActivity(colorIntent)
        }
    }

    fun takePhoto(view: View){
        requestCameraPermission.launch(Manifest.permission.CAMERA)
    }

    private val requestCameraPermission = registerForActivityResult(ActivityResultContracts.RequestPermission()){
            isSuccess : Boolean ->
        if(isSuccess){
            Log.d("Take Picture", "Permission granted")
            takePicture.launch(null)
        } else {
            Toast.makeText(applicationContext, "Camera has no permission", Toast.LENGTH_SHORT).show()
        }
    }

    private val takePicture = registerForActivityResult(ActivityResultContracts.TakePicturePreview()){
            bitmap: Bitmap? ->
        Log.d("Take Picture", "Show bitmap picture")
        imageView1.setImageBitmap(bitmap)
        imageView2.setImageBitmap(bitmap)
        imageView3.setImageBitmap(bitmap)
        imageView4.setImageBitmap(bitmap)
        textView1.setText("Autumn")
        textView2.setText("Summer")
        textView3.setText("Winter")
        textView4.setText("Spring")
    }
}


