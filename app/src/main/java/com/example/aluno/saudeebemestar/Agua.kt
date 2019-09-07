package com.example.aluno.saudeebemestar

import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_agua.*

class Agua : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agua)

        var total = 0
        var value = 0

        val editText = findViewById<EditText>(R.id.agua_edittext)
        val progress = findViewById<ProgressBar>(R.id.waterBar)
        val waterText = findViewById<TextView>(R.id.waterText)
        val checkbox = findViewById<ImageView>(R.id.water_checkbox)

        editText.setOnKeyListener (View.OnKeyListener {v, keyCode, event ->
            if(keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                value = editText.text.toString().toInt()
                total+= value
                progress.progress += value
                waterText.text = "$total ml/2000ml"

                if (total >= 2000){
                    checkbox.visibility = View.VISIBLE
                }

                return@OnKeyListener true
            }
            false
        })

//        editText.addTextChangedListener(object : TextWatcher{
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }
//
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) { }
//
//            override fun afterTextChanged(s: Editable?) {
//                value+= editText.text.toString().toInt()
//                progress.progress += value
//                waterText.text = value.toString() + "ml/2000ml"
//            }
//        })
    }
}
