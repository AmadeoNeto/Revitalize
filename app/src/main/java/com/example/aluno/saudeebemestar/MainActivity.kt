package com.example.aluno.saudeebemestar

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val start_btn = findViewById<ImageButton>(R.id.startButton)

        start_btn.setOnClickListener {

            val intent = Intent(this, MainMenu::class.java)
            startActivity(intent)

//            TestFirebase()
        }
    }
    fun TestFirebase() {

        val db = FirebaseFirestore.getInstance()

        val desafios = db.collection("desafios")
        val lastDoc = consultar(db,"desafios", "alongar")
                ?.addOnCompleteListener{document ->
                    Log.d("Desafio", "Task completed")
                }
                ?.addOnSuccessListener { document ->
                    if(document.exists())
                        Log.d("Desafio", "Data: ${document.id}")
                }
                ?.addOnFailureListener{exception ->
                    Log.d("Desafio","Exception: $exception")
                }


        /*val docRef = desafios.whereEqualTo("Random",(0..size).random())*/

//        val cities = db.collection("cities")

//        val data1 = hashMapOf(
//                "name" to "San Francisco",
//                "state" to "CA",
//                "country" to "USA",
//                "capital" to false,
//                "population" to 860000,
//                "regions" to listOf("west_coast", "norcal")
//        )
//        cities.document("SF").set(data1)
//
//        val TAG = "test";
//        val docRef = db.collection("cities").document("SF")
//        docRef.get().addOnSuccessListener { document ->
//                    if (document != null) {
//                        Log.d(TAG, "DocumentSnapshot data: ${document}")
//                    } else {
//                        Log.d(TAG, "No such document")
//                    }
//                }
//                .addOnFailureListener { exception ->
//                    Log.d(TAG, "get failed with ", exception)
//                }
    }

    fun consultar(db : FirebaseFirestore,collection: String, document : String): Task<DocumentSnapshot>? {

        val returnDocument = db.collection(collection).document(document).get()
        return returnDocument
    }
}

