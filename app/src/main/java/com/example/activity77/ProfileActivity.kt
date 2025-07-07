package com.example.activity77

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                // Handle menu item click here
                val intent = android.content.Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
                true
            }
            R.id.logout -> {
                // Handle logout action
                val alertDialog = androidx.appcompat.app.AlertDialog.Builder(this)
                alertDialog.setTitle("Logout")
                alertDialog.setMessage("Are you sure you want to logout?")
                alertDialog.setPositiveButton("Yes") { dialog, _ ->
                    // Handle logout logic here
                    dialog.dismiss()
                    finish() // Close the ProfileActivity
                }
                true
            }
            R.id.close -> {
                // Handle about action
                finish() // Close the ProfileActivity
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}