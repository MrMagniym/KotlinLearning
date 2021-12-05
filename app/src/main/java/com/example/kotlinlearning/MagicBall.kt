package com.example.kotlinlearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MagicBall : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_magic_ball)

        val textEditQuestion = findViewById<EditText>(R.id.textEditQuestion)
        val textViewAnswer = findViewById<TextView>(R.id.textViewAnswer)
        val buttonAnswer = findViewById<Button>(R.id.buttonAnswer)
        val buttonGoBack = findViewById<Button>(R.id.buttonGoBack)

        val answers = arrayOf(
            "Yes",
            "No",
            "More yes then no",
            "More no then yes",
            "maybe",
            "You have some chances",
            "Incorrect question"
        )

        buttonAnswer.setOnClickListener{
            if (textEditQuestion.text.isNotEmpty()){
                textViewAnswer.text = answers.random()
            }
        }

        buttonGoBack.setOnClickListener{
            finish()
        }
    }
}