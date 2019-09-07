package com.example.aluno.saudeebemestar

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_calculo_imc.*

class CalculoIMC : AppCompatActivity() {

    var peso: Float = 0f
    var altura: Float = 0f
    var imc: Float = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculo_imc)

        val peso_editText = findViewById<EditText>(R.id.peso)
        val altura_editText = findViewById<EditText>(R.id.altura)
        val imc_textView = findViewById<TextView>(R.id.imcText)
        val imc_classification = findViewById<TextView>(R.id.imc_classification)

        altura_editText.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                altura = altura_editText.text.toString().toFloat() / 100

                if (altura > 0 && peso > 0)
                    CalcularIMC(imc_textView, imc_classification)

                return@OnKeyListener true
            }
            false
        })

        peso_editText.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                peso = peso_editText.text.toString().toFloat()
                if (altura > 0 && peso > 0)
                    CalcularIMC(imc_textView, imc_classification)

                    return@OnKeyListener true
            }
            false
        })
    }

    fun CalcularIMC(imc_textView: TextView, imc_classification: TextView) {

        imc = peso / (altura * altura)
        imc_textView.text = "%.1f".format(imc)

        imc_classification.let {
            if (imc < 18.5)
                it.text = "Abaixo do Peso"
            else if (imc < 24.9)
                it.text = "Peso Normal"
            else if (imc < 29.9)
                it.text = "Sobrepeso"
            else if (imc < 34.9)
                it.text = "Obesidade Grau 1"
            else if (imc < 39.9)
                it.text = "Obesidade Grau 2"
            else
                it.text = "Obesidade Grau 3"
        }
    }
}