package com.example.kotlinlearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class FormatText : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_format_text)

        val textEditQuestion = findViewById<EditText>(R.id.textEditQuestion)
        val textViewAnswer = findViewById<TextView>(R.id.textViewAnswer)
        val buttonChange = findViewById<Button>(R.id.buttonChange)
        val buttonGoBack = findViewById<Button>(R.id.buttonGoBack)

        buttonChange.setOnClickListener{
            if (textEditQuestion.text.isNotEmpty()){
                textViewAnswer.text = textEditQuestion.text.toString().replace('a', 'o', true)
            }
        }

        buttonGoBack.setOnClickListener{
            finish()
        }
    }
}