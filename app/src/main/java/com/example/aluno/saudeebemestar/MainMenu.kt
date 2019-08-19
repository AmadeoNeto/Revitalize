package com.example.aluno.saudeebemestar

import android.os.Bundle
import android.widget.Button
import  android.content.Intent
import androidx.appcompat.app.AppCompatActivity

class MainMenu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        val imc_btn = findViewById<Button>(R.id.imcButton)
        val water_btn = findViewById<Button>(R.id.aguaButton)
        val challenges_btn = findViewById<Button>(R.id.desafiosButton)
        val alimentation_btn = findViewById<Button>(R.id.alimentacaoButton)

        imc_btn.setOnClickListener {

            val intent = Intent(this, CalculoIMC::class.java)

            startActivity(intent)
        }

        water_btn.setOnClickListener {

            val intent = Intent(this, Agua::class.java)

            startActivity(intent)
        }

        challenges_btn.setOnClickListener {

            val intent = Intent(this, DesafiosRV::class.java)

            startActivity(intent)
        }

        alimentation_btn.setOnClickListener {

            val intent = Intent(this, Alimentacao::class.java)

            startActivity(intent)
        }
    }
}
