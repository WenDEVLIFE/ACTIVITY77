package com.example.activity77

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val loginButton = findViewById<Button>(R.id.button)
        loginButton.setOnClickListener {
            showLoginDialog()

        }
    }

    private fun showLoginDialog() {
        val dialogView = layoutInflater.inflate(R.layout.logindialog, null)
        val usernameInput = dialogView.findViewById<EditText>(R.id.dialogUsername)
        val passwordInput = dialogView.findViewById<EditText>(R.id.dialogPassword)

        AlertDialog.Builder(this)
            .setTitle("Login")
            .setView(dialogView)
            .setPositiveButton("OK") { _, _ ->
                val usernameText = usernameInput.text.toString()
                val passwordText = passwordInput.text.toString()

                if (usernameText.isEmpty() || passwordText.isEmpty()) {
                    usernameInput.error = "Username cannot be empty"
                    passwordInput.error = "Password cannot be empty"
                } else {
                    if (usernameText == "JohnDoe" && passwordText == "JohnDoe") {
                        Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()

                        val intent = Intent(this, ProfileActivity::class.java)
                        startActivity(intent)
                        finish() // Close the login activity

                    } else {
                        usernameInput.error = "Invalid username or password"
                        passwordInput.error = "Invalid username or password"
                    }
                }

            }
            .setNegativeButton("Cancel", null)
            .show()
    }


}