package com.example.kotlinlearning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonMagicBall = findViewById<Button>(R.id.buttonMagicBall)
        val buttonFormatText = findViewById<Button>(R.id.buttonFormatText)
        val buttonRiddles = findViewById<Button>(R.id.buttonRiddles)
        val buttonCalculator = findViewById<Button>(R.id.buttonCalculator)

        buttonMagicBall.setOnClickListener {
            startActivity(Intent(this@MainActivity, MagicBall::class.java))
        }
        buttonFormatText.setOnClickListener {
            val intent = Intent(this@MainActivity, FormatText::class.java)
            startActivity(intent)
        }
        buttonRiddles.setOnClickListener {
            val intent = Intent(this@MainActivity, Riddles::class.java)
            startActivity(intent)
        }
        buttonCalculator.setOnClickListener {
            val intent = Intent(this@MainActivity, Calculator::class.java)
            startActivity(intent)
        }
    }
}