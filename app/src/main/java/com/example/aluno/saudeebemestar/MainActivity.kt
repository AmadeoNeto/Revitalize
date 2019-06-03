package com.example.aluno.saudeebemestar

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val start_btn = findViewById<Button>(R.id.startButton)

        start_btn.setOnClickListener{

            val intent = Intent(this, MainMenu::class.java)

            startActivity(intent)
        }
    }
}
