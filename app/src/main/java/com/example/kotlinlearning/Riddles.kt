package com.example.kotlinlearning

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Riddles : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_riddles)

        val textAnswer = findViewById<EditText>(R.id.textAnswer)
        val textViewRiddle = findViewById<TextView>(R.id.textViewRiddle)
        val textResult = findViewById<TextView>(R.id.textResult)
        val buttonGetRiddle = findViewById<Button>(R.id.buttonGetRiddle)
        val buttonAnswer = findViewById<Button>(R.id.buttonAnswer)
        val buttonGoBack = findViewById<Button>(R.id.buttonGoBack)

        val riddles = mapOf(
            "Речка спятила с ума\n" +
            "По домам пошла сама" to "водопровод",

            "Музыкант, певец, рассказчик\n" +
            "А всего труба да ящик" to "граммофон",

            "На раскрашенных страницах\n" +
            "Много праздников хранится" to "календарь",

            "Ах, не трогайте меня\n" +
            "Обожгу и без огня!" to "крапива",

            "Маленькие домики по улице бегут\n" +
            "Мальчиков и девочек домики везут" to "машины",
        )

        var number = ""

        buttonGetRiddle.setOnClickListener{
            number = riddles.keys.random()
            textViewRiddle.text = number
        }

        buttonAnswer.setOnClickListener {
            for(item in riddles.values){
                if (riddles[number]!! == textAnswer.text.toString()){
                    textResult.text = "Correct"
                }
                else{
                    textResult.text = "Incorrect"
                }
            }
        }

        buttonGoBack.setOnClickListener{
            finish()
        }

    }
}