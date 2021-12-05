package com.example.kotlinlearning

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Calculator : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        val textFirstNumber = findViewById<EditText>(R.id.textFirstNumber)
        val textSecondNumber = findViewById<EditText>(R.id.textSecondNumber)
        val textOperator = findViewById<TextView>(R.id.textOperator)
        val textAnswer = findViewById<TextView>(R.id.textAnswer)
        val buttonResult = findViewById<Button>(R.id.buttonResult)
        val buttonAddition = findViewById<Button>(R.id.buttonAddition)
        val buttonSubtract = findViewById<Button>(R.id.buttonSubtract)
        val buttonMultiply = findViewById<Button>(R.id.buttonMultiply)
        val buttonDivision = findViewById<Button>(R.id.buttonDivision)
        val buttonGoBack = findViewById<Button>(R.id.buttonGoBack)

        buttonAddition.setOnClickListener{
            textOperator.text = "+"
        }

        buttonSubtract.setOnClickListener{
            textOperator.text = "-"
        }

        buttonMultiply.setOnClickListener{
            textOperator.text = "*"
        }

        buttonDivision.setOnClickListener{
            if (textSecondNumber.text.toString().toInt() != 0) {
                textOperator.text = "/"
            }
            else
                textOperator.text = ""
                textAnswer.text = "rly?"
        }

        buttonResult.setOnClickListener{
            if (textFirstNumber.text.isNotEmpty() && textSecondNumber.text.isNotEmpty() && textOperator.text.isNotEmpty()) {
                var num1: Int = textFirstNumber.text.toString().toInt()
                var num2: Int = textSecondNumber.text.toString().toInt()
                when(textOperator.text){
                    "+" -> textAnswer.text = (num1 + num2).toString()
                    "-" -> textAnswer.text = (num1 - num2).toString()
                    "*" -> textAnswer.text = (num1 * num2).toString()
                    "/" -> textAnswer.text = (num1 / num2).toString()
                }
            }
        }


        buttonGoBack.setOnClickListener{
            finish()
        }
    }
}