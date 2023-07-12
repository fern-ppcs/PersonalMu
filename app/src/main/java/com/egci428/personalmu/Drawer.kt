package com.egci428.personalmu

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.Window
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Drawer: AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
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
        date.setText(current)
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_Color -> {
                val colorIntent = Intent(this, Drawer::class.java)
                startActivity(colorIntent)
                Toast.makeText(applicationContext,"Clicked Home",Toast.LENGTH_SHORT).show()
            }
            R.id.nav_lucky-> {
                val fortuneIntent = Intent(this, FortuneTeller::class.java)
                startActivity(fortuneIntent)
                Toast.makeText(applicationContext,"Clicked Home",Toast.LENGTH_SHORT).show()
            }
            R.id.nav_camera -> {
                val colorIntent = Intent(this, Camera::class.java)
                startActivity(colorIntent)
                Toast.makeText(applicationContext,"Clicked Home",Toast.LENGTH_SHORT).show()
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