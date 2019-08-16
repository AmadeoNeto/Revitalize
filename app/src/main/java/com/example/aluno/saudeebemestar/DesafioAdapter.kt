package com.example.recyclerview
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aluno.saudeebemestar.Desafio
import com.example.aluno.saudeebemestar.R
import kotlinx.android.synthetic.main.desafio_layout.view.*

class DesafioAdapter (private val desafioList : MutableList<Desafio>) : RecyclerView.Adapter<DesafioAdapter.DesafioViewHolder> (){

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): DesafioViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.desafio_layout,parent,false)
        return DesafioViewHolder(view)
    }

    override fun getItemCount(): Int {
        return desafioList.size
    }

    override fun onBindViewHolder(holder: DesafioViewHolder, position: Int) {

        holder.let{
            it.image.setImageResource(desafioList[position].desafioImage)
            it.title.text = desafioList[position].desafioTitle
            it.description.text = desafioList[position].desafioDescriprion
        }
    }

    inner class DesafioViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val image = itemView.desafioImage
        val title = itemView.desafioTitle
        val description = itemView.desafioDescription
    }
}