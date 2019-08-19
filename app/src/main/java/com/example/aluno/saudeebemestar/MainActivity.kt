package com.example.aluno.saudeebemestar

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val start_btn = findViewById<Button>(R.id.startButton)

        val db = FirebaseFirestore.getInstance() //Firebase

        start_btn.setOnClickListener{

            //val intent = Intent(this, MainMenu::class.java)
            //startActivity(intent)
            db.collection("usuarios").document("moesio")
        }
    }
}
