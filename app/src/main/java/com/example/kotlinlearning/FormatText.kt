package com.example.kotlinlearning

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class FormatText : AppCompatActivity() {
    private var word: String = ""
    private var wordMax: String = ""

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_format_text)

        val textEditQuestion = findViewById<EditText>(R.id.textEditQuestion)
        val textViewAnswer = findViewById<TextView>(R.id.textViewAnswer)
        val buttonChange = findViewById<Button>(R.id.buttonChange)
        val buttonGoBack = findViewById<Button>(R.id.buttonGoBack)
        val textViewWordMax = findViewById<TextView>(R.id.textViewMaxWord)

        buttonChange.setOnClickListener {
            val array = textEditQuestion.text.toString().toCharArray()
            if (textEditQuestion.text.isNotEmpty()) {
                for (i in array.indices) {
                    if (array[i] != ' ') {
                        word += array[i]
                        if (wordMax.length < word.length) {
                            wordMax = word
                        }

                    } else {
                        word = ""
                    }
                }
                textViewWordMax.text = wordMax.uppercase()
                textViewAnswer.text = textEditQuestion.text.toString().replace('a', 'o', true)
                textViewAnswer.text = textViewAnswer.text.toString().replace(' ', '_')
            }
        }

        buttonGoBack.setOnClickListener {
            finish()
        }
    }
}