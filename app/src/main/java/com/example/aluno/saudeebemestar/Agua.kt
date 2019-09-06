package com.example.aluno.saudeebemestar

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_agua.*

class Agua : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agua)

        var value: Int = 0;
        val editText = findViewById<EditText>(R.id.agua_edittext)
        val progress = findViewById<ProgressBar>(R.id.waterBar)
        val waterText = findViewById<TextView>(R.id.waterText)

        editText.addTextChangedListener(object : TextWatcher{

            override fun afterTextChanged(s: Editable?) {
                value+= editText.text.toString().toInt()
                progress.progress += value
                waterText.text = value.toString() + "ml/2000ml"
            }
        })
    }
}
