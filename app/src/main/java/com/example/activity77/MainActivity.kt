package com.example.activity77 // Match your Gradle namespace

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var etNumber1: EditText
    private lateinit var etNumber2: EditText
    private lateinit var resultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        etNumber1 = findViewById(R.id.editTextText9)
        etNumber2 = findViewById(R.id.editTextText10)
        resultText = findViewById(R.id.resultText)

        findViewById<Button>(R.id.button8).setOnClickListener { calculate("+") }
        findViewById<Button>(R.id.button9).setOnClickListener { calculate("-") }
        findViewById<Button>(R.id.button10).setOnClickListener { calculate("×") }
        findViewById<Button>(R.id.button11).setOnClickListener { calculate("/") }
        findViewById<Button>(R.id.buttonback).setOnClickListener {
            val intent = android.content.Intent(this, ProfileActivity::class.java)
            startActivity(intent)
            finish() // Close the MainActivity
        }
    }

    private fun calculate(operation: String) {
        val num1Str = etNumber1.text.toString()
        val num2Str = etNumber2.text.toString()

        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            resultText.text = "Error: Empty input"
            return
        }

        val num1 = num1Str.toDoubleOrNull()
        val num2 = num2Str.toDoubleOrNull()

        if (num1 == null || num2 == null) {
            resultText.text = "Error: Invalid number"
            return
        }

        val result = when (operation) {
            "+" -> num1 + num2
            "-" -> num1 - num2
            "×" -> num1 * num2
            "/" -> {
                if (num2 == 0.0) {
                    resultText.text = "Error: Division by zero"
                    return
                } else {
                    num1 / num2
                }
            }
            else -> 0.0
        }

        resultText.text = if (result % 1 == 0.0) result.toInt().toString() else result.toString()
    }
}

