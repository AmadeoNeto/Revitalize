package com.example.aluno.saudeebemestar

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.DesafioAdapter
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.QuerySnapshot
import kotlinx.android.synthetic.main.activity_desafios_rv.*
import kotlin.math.log

class DesafiosRV : AppCompatActivity() {

    lateinit var adapter: RecyclerView.Adapter<*>
    lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_desafios_rv)

        val db = FirebaseFirestore.getInstance()
        val task = GetDocuments(db,"Desafios", 4)
        var desafioList = mutableListOf<Desafio>()

        Log.d("firestore", "RV: ${desafioRV == null}")

        task?.addOnSuccessListener {
            if(it != null) {
                it.documents.forEach { doc ->
                    desafioList.add(GetDesafio(doc))
                    Log.d("firestore", "Data: ${GetDesafio(doc).desafioTitle}")

                    viewManager = LinearLayoutManager(this)
                    adapter = DesafioAdapter(desafioList)

                    desafioRV.adapter = adapter
                    desafioRV.layoutManager = viewManager
                }
            }
        }
        Log.d("firestore", "Lita: ${desafioList.size}")
        desafioList.forEach{
            Log.d("firestore", "Lita: ${it.desafioTitle}")
        }

        //Teste
//        var desafioDoc = Consultar(db,"Desafios","alongar")
//                ?.addOnSuccessListener {
//                    Log.d("firestore", "Data: ${it.data}")
//                    Log.d("firestore", "${it.data?.get("titulo")}")
//                    desafio = GetDesafio(it)
//                    Log.d("firestore","Desafio: ${desafio.desafioTitle}")
//                }


        //Manualmente
//        desafioList.let{
//            it.add(Desafio("Diminua o uso de açúcar refinado",
//                    "Dica: use o mascavo, ele é bem mais saudável",R.drawable.sugar,false))
//            it.add(Desafio("Faça 30 abdominais todos os dias",
//                    "Essa é uma órima opção para fortalecer a musculatura do abdômen", R.drawable.abdominal, false))
//            it.add(Desafio("Diminua o consumo de enlatados",
//                    "O nível elevado de sódio desses alimentos pode causar problemas de saúde",R.drawable.caned_food,false))
//            it.add((Desafio("Diminua a quanridade de lipídios",
//                    "A presença exacerbada deles no nosso  aumenta a chance do entupimento de veias", R.drawable.fast_food, false)))
//        }
    }
    //abdominal - Photo by bruce mars from Pexels
    //sugar - Photo by Suzy Hazelwood from Pexels
    //cannedFood - Photo by edwin josé vega ramos from Pexels
    //fastFood - Photo by rawpixel.com from Pexels

    fun Consultar(db : FirebaseFirestore,collection: String, document : String): Task<DocumentSnapshot>? {
        val returnDocument = db.collection(collection).document(document).get()
        return returnDocument
    }

    fun GetDocuments(db : FirebaseFirestore,collection: String, limit : Long) : Task<QuerySnapshot>? {
        return db.collection(collection).orderBy("titulo").limit(limit).get()
    }

    fun GetDesafio(doc : DocumentSnapshot) : Desafio{

        return Desafio(doc.get("titulo").toString(), doc.get("descricao").toString(), R.drawable.sugar,false)
    }
}
