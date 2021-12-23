package com.example.kotlinlearning

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class FormatText : AppCompatActivity() {
    private lateinit var textEditQuestion: EditText
    private lateinit var textViewAnswer: TextView
    private lateinit var buttonChange: Button
    private lateinit var buttonGoBack: Button

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_format_text)

        textEditQuestion = findViewById(R.id.textEditQuestion)
        textViewAnswer = findViewById(R.id.textViewAnswer)
        buttonChange = findViewById(R.id.buttonChange)
        buttonGoBack = findViewById(R.id.buttonGoBack)

        buttonChange.setOnClickListener {
            if (textEditQuestion.text.isNotEmpty()) {
                textViewAnswer.text = textEditQuestion.text.toString().replace('a', 'o', true)
                textViewAnswer.text = splitWordToUppercase()
//                textViewAnswer.text = maxWordToUppercase()

                textViewAnswer.text = textViewAnswer.text.toString().replace(' ', '_')
            }
        }

        buttonGoBack.setOnClickListener {
            finish()
        }
    }

    private fun splitWordToUppercase(): String {
        val inputString = textViewAnswer.text.toString()
        var outputString = ""
        val list = inputString.split(" ").toList()
        val maxWord = list.maxByOrNull {
            it.length
        }
        for (word in list) {
            outputString += if (word == maxWord) {
                word.uppercase() + " "
            } else {
                "$word "
            }
        }
        return outputString
    }

    private fun maxWordToUppercase(): String {
        val array = textEditQuestion.text.toString().toCharArray()
        var word = ""
        var wordMax = ""
        var newString = ""
        var count = 0
        for (i in array.indices) {
            if (array[i] != ' ') {
                word += array[i]
                if (wordMax.length < word.length) {
                    wordMax = word
                    count = i
                }
            } else {
                word = ""
            }
        }
        for (i in array.indices) {
            if (i >= (count - wordMax.length + 1) && i <= count) {
                newString += array[i].toString().uppercase()
            } else {
                newString += array[i]
            }
        }
        return newString
    }
}