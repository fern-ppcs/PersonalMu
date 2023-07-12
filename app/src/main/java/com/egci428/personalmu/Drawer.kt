package com.egci428.personalmu

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.MenuItem
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Drawer : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawer)

        drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        if (savedInstanceState == null) {
            navigationView.setCheckedItem(R.id.nav_Color)
        }

        val formatter = DateTimeFormatter.ofPattern("dd MMMM EEEE")
        val current = LocalDateTime.now().format(formatter)

        val date = findViewById<TextView>(R.id.DateTV)
        date.text = current

        FirebaseApp.initializeApp(this)
        val db: FirebaseFirestore = FirebaseFirestore.getInstance()

        // Load data from Firestore
        val colorsCollection = db.collection("Colors")
        val currentDayOfWeek = LocalDateTime.now().dayOfWeek.toString().substring(0, 1).toUpperCase() +
                LocalDateTime.now().dayOfWeek.toString().substring(1).toLowerCase()
        val dayDocument = colorsCollection.document(currentDayOfWeek)
        // val dayDocument = colorsCollection.document("Thursday")
        dayDocument.get().addOnSuccessListener { documentSnapshot ->
            if (documentSnapshot.exists()) {
                val data = documentSnapshot.data
                if (data != null) {
                    val workIM1Color = data["W1"] as String?
                    val workIM2Color = data["W2"] as String?
                    val workIM3Color = data["W3"] as String?
                    val workIM4Color = data["W4"] as String?
                    val moneyIM1Color = data["M1"] as String?
                    val moneyIM2Color = data["M2"] as String?
                    val moneyIM3Color = data["M3"] as String?
                    val moneyIM4Color = data["M4"] as String?
                    val loveIM1Color = data["L1"] as String?
                    val loveIM2Color = data["L2"] as String?
                    val loveIM3Color = data["L3"] as String?
                    val loveIM4Color = data["L4"] as String?
                    val eduIM1Color = data["E1"] as String?
                    val eduIM2Color = data["E2"] as String?
                    val eduIM3Color = data["E3"] as String?
                    val eduIM4Color = data["E4"] as String?
                    val miseryIM1Color = data["B1"] as String?
                    val miseryIM2Color = data["B2"] as String?

                    // Change background color of ImageViews
                    val workIM1 = findViewById<ImageView>(R.id.workIM1)
                    val workIM2 = findViewById<ImageView>(R.id.workIM2)
                    val workIM3 = findViewById<ImageView>(R.id.workIM3)
                    val workIM4 = findViewById<ImageView>(R.id.workIM4)
                    val moneyIM1 = findViewById<ImageView>(R.id.moneyIM1)
                    val moneyIM2 = findViewById<ImageView>(R.id.moneyIM2)
                    val moneyIM3 = findViewById<ImageView>(R.id.moneyIM3)
                    val moneyIM4 = findViewById<ImageView>(R.id.moneyIM4)
                    val loveIM1 = findViewById<ImageView>(R.id.loveIM1)
                    val loveIM2 = findViewById<ImageView>(R.id.loveIM2)
                    val loveIM3 = findViewById<ImageView>(R.id.loveIM3)
                    val loveIM4 = findViewById<ImageView>(R.id.loveIM4)
                    val eduIM1 = findViewById<ImageView>(R.id.eduIM1)
                    val eduIM2 = findViewById<ImageView>(R.id.eduIM2)
                    val eduIM3 = findViewById<ImageView>(R.id.eduIM3)
                    val eduIM4 = findViewById<ImageView>(R.id.eduIM4)
                    val miseryIM1 = findViewById<ImageView>(R.id.miseryIM1)
                    val miseryIM2 = findViewById<ImageView>(R.id.miseryIM2)
                    val dataReceived = intent.getIntExtra("dataToSend", -1)
                    val skintoneTV = findViewById<TextView>(R.id.skintoneTV)

                    var CVal = 1f
                    if (dataReceived == 0) {
                        skintoneTV.text = "Warm tone"
                        CVal = 1f
                    } else if (dataReceived == 1) {
                        skintoneTV.text = "Cool tone"
                        CVal = 0.6f
                    }


                    workIM1Color?.let { color ->
                        val filteredColor = Color.parseColor(color).adjustAlpha(CVal)
                        workIM1.setBackgroundColor(filteredColor)
                    }
                    workIM2Color?.let { color ->
                        val filteredColor = Color.parseColor(color).adjustAlpha(CVal)
                        workIM2.setBackgroundColor(filteredColor)
                    }
                    workIM3Color?.let { color ->
                        val filteredColor = Color.parseColor(color).adjustAlpha(CVal)
                        workIM3.setBackgroundColor(filteredColor)
                    }
                    workIM4Color?.let { color ->
                        val filteredColor = Color.parseColor(color).adjustAlpha(CVal)
                        workIM4.setBackgroundColor(filteredColor)
                    }
                    moneyIM1Color?.let { color ->
                        val filteredColor = Color.parseColor(color).adjustAlpha(CVal)
                        moneyIM1.setBackgroundColor(filteredColor)
                    }
                    moneyIM2Color?.let { color ->
                        val filteredColor = Color.parseColor(color).adjustAlpha(CVal)
                        moneyIM2.setBackgroundColor(filteredColor)
                    }
                    moneyIM3Color?.let { color ->
                        val filteredColor = Color.parseColor(color).adjustAlpha(CVal)
                        moneyIM3.setBackgroundColor(filteredColor)
                    }
                    moneyIM4Color?.let { color ->
                        val filteredColor = Color.parseColor(color).adjustAlpha(CVal)
                        moneyIM4.setBackgroundColor(filteredColor)
                    }
                    loveIM1Color?.let { color ->
                        val filteredColor = Color.parseColor(color).adjustAlpha(CVal)
                        loveIM1.setBackgroundColor(filteredColor)
                    }
                    loveIM2Color?.let { color ->
                        val filteredColor = Color.parseColor(color).adjustAlpha(CVal)
                        loveIM2.setBackgroundColor(filteredColor)
                    }
                    loveIM3Color?.let { color ->
                        val filteredColor = Color.parseColor(color).adjustAlpha(CVal)
                        loveIM3.setBackgroundColor(filteredColor)
                    }
                    loveIM4Color?.let { color ->
                        val filteredColor = Color.parseColor(color).adjustAlpha(CVal)
                        loveIM4.setBackgroundColor(filteredColor)
                    }
                    eduIM1Color?.let { color ->
                        val filteredColor = Color.parseColor(color).adjustAlpha(CVal)
                        eduIM1.setBackgroundColor(filteredColor)
                    }
                    eduIM2Color?.let { color ->
                        val filteredColor = Color.parseColor(color).adjustAlpha(CVal)
                        eduIM2.setBackgroundColor(filteredColor)
                    }
                    eduIM3Color?.let { color ->
                        val filteredColor = Color.parseColor(color).adjustAlpha(CVal)
                        eduIM3.setBackgroundColor(filteredColor)
                    }
                    eduIM4Color?.let { color ->
                        val filteredColor = Color.parseColor(color).adjustAlpha(CVal)
                        eduIM4.setBackgroundColor(filteredColor)
                    }
                    miseryIM1Color?.let { color ->
                        val filteredColor = Color.parseColor(color).adjustAlpha(CVal)
                        miseryIM1.setBackgroundColor(filteredColor)
                    }
                    miseryIM2Color?.let { color ->
                        val filteredColor = Color.parseColor(color).adjustAlpha(CVal)
                        miseryIM2.setBackgroundColor(filteredColor)
                    }
                }
            }
        }


    }

    // Extension function to adjust alpha of a color
    fun Int.adjustAlpha(factor: Float): Int {
        val alpha = (255 * factor).toInt()
        return Color.argb(alpha, Color.red(this), Color.green(this), Color.blue(this))
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_Color -> {
                val colorIntent = Intent(this, Drawer::class.java)
                startActivity(colorIntent)
                Toast.makeText(applicationContext, "Clicked Home", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_lucky -> {
                val fortuneIntent = Intent(this, FortuneTeller::class.java)
                startActivity(fortuneIntent)
                Toast.makeText(applicationContext, "Clicked Home", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_camera -> {
                val colorIntent = Intent(this, Camera::class.java)
                startActivity(colorIntent)
                Toast.makeText(applicationContext, "Clicked Home", Toast.LENGTH_SHORT).show()
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}
