package com.example.aluno.saudeebemestar

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_calculo_imc.*

class CalculoIMC : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculo_imc)

        val peso_editText = findViewById<EditText>(R.id.peso)
        val altura_editText = findViewById<EditText>(R.id.altura)
        val calcular_btn = findViewById<Button>(R.id.calcularIMC)
        val imc_textView = findViewById<TextView>(R.id.imcText)
        val imc_classification = findViewById<TextView>(R.id.imc_classification)

        var peso : Float
        var altura : Float
        var imc : Float

        calcular_btn.setOnClickListener {

            peso = peso_editText.text.toString().toFloat()
            altura = altura_editText.text.toString().toFloat()/100
            imc = (peso / (altura * altura))

            imc_textView.text = "%.1f".format(imc).toString()

            imc_classification.let{
                if (imc < 18.5)
                    it.text = "Abaixo do Peso"
                else if(imc < 24.9)
                    it.text = "Peso Normal"
                else if(imc < 29.9)
                    it.text = "Sobrepeso"
                else if(imc < 34.9)
                    it.text = "Obesidade Grau 1"
                else if(imc < 39.9)
                    it.text = "Obesidade Grau 2"
                else
                    it.text = "Obesidade Grau 3"
            }
        }
    }
}
