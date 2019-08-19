package com.example.aluno.saudeebemestar

import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_agua.*

class Agua : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agua)

        var value: Int = 0;
        val button150 = findViewById<Button>(R.id.button150)
        val button200 = findViewById<Button>(R.id.button200)
        val button500 = findViewById<Button>(R.id.button500)
        val progress = findViewById<ProgressBar>(R.id.waterBar)
        val waterText = findViewById<TextView>(R.id.waterText)

        button150.setOnClickListener {
            progress.progress += 150
            value+= 150
            waterText.text = value.toString() + "ml/2000ml"
        }

        button200.setOnClickListener {
            progress.progress += 200
            value += 200
            waterText.text = value.toString() + "ml/2000ml"
        }

        button500.setOnClickListener {
            progress.progress += 500
            value += 500
            waterText.text = value.toString() + "ml/2000ml"
        }
    }
}
