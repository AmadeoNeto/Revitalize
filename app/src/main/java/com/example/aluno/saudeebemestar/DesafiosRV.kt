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
        viewManager = LinearLayoutManager(this)
        adapter = DesafioAdapter(desafioList)

        desafioRV.adapter = adapter
        desafioRV.layoutManager = viewManager
    }
}
