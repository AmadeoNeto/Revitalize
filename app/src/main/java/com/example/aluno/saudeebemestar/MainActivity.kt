package com.example.aluno.saudeebemestar

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val start_btn = findViewById<Button>(R.id.startButton)

        start_btn.setOnClickListener {

            //            val intent = Intent(this, MainMenu::class.java)
//            startActivity(intent)

            TestFirebase()
        }
    }
    fun TestFirebase(){
        val db = FirebaseFirestore.getInstance() //Firebase
        val user = mapOf<String,Any>("nome" to "Joao", "idade" to 19) //FIREBASE

        db.collection("usuarios").document("jose20").set(user)
                .addOnSuccessListener { Log.d("Bancodados","cadastrado com sucesso") }
                .addOnFailureListener() { Log.d("Bancodados","Houve um erro no cadastramento") }
    }
}
