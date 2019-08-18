package com.example.aluno.saudeebemestar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.recyclerview.DesafioAdapter
import kotlinx.android.synthetic.main.activity_desafios_rv.*

class DesafiosRV : AppCompatActivity() {

    lateinit var adapter: RecyclerView.Adapter<*>
    lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_desafios_rv)

        var desafioList = mutableListOf<Desafio>()

        desafioList.let{
            it.add(Desafio("Diminua o uso de açúcar refinado",
                    "Dica: use o mascavo, ele é bem mais saudável",R.drawable.sugar,false))
            it.add(Desafio("Faça 30 abdominais todos os dias",
                    "Essa é uma órima opção para fortalecer a musculatura do abdômen", R.drawable.abdominal, false))
            it.add(Desafio("Diminua o consumo de enlatados",
                    "O nível elevado de sódio desses alimentos pode causar problemas de saúde",R.drawable.caned_food,false))
            it.add((Desafio("Diminua a quanridade de lipídios",
                    "A presença exacerbada deles no nosso  aumenta a chance do entupimento de veias", R.drawable.fast_food, false)))
        }

        viewManager = LinearLayoutManager(this)
        adapter = DesafioAdapter(desafioList)

        desafioRV.adapter = adapter
        desafioRV.layoutManager = viewManager
    }
    //abdominal - Photo by bruce mars from Pexels
    //sugar - Photo by Suzy Hazelwood from Pexels
    //cannedFood - Photo by edwin josé vega ramos from Pexels
    //fastFood - Photo by rawpixel.com from Pexels
}
