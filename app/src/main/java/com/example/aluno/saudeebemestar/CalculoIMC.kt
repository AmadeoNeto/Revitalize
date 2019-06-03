package com.example.aluno.saudeebemestar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_calculo_imc.*

class CalculoIMC : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculo_imc)

        val peso_editText = findViewById<EditText>(R.id.peso)
        val altura_editText = findViewById<EditText>(R.id.altura)
        val calcular_btn = findViewById<Button>(R.id.calcularIMC)
        val imc_textView = findViewById<TextView>(R.id.imcText)

        var peso : Float
        var altura : Float
        var imc : Float

        calcular_btn.setOnClickListener {

            peso = peso_editText.text.toString().toFloat()
            altura = altura_editText.text.toString().toFloat()
            imc = (peso / (altura * altura)) * 10000

            imc_textView.text = imc.toString()
        }
    }
}
