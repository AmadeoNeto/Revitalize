package com.example.recyclerview
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.aluno.saudeebemestar.Desafio
import com.example.aluno.saudeebemestar.GlideApp
import com.example.aluno.saudeebemestar.R
import com.google.firebase.storage.FirebaseStorage
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

        val storage = FirebaseStorage.getInstance()
        Log.d("firebase", "${storage.getReferenceFromUrl("https://firebasestorage.googleapis.com/v0/b/revitalize-1b7c2.appspot.com/o/Desafios%2Fabdominal.jpg?alt=media&token=7e4d995a-f2ea-47a6-8cee-41f7515bb075")}")

        holder.let{
            it.title.text = desafioList[position].desafioTitle
            it.description.text = desafioList[position].desafioDescriprion

            GlideApp.with(it.itemView.context).load(desafioList[position].desafioImage).fitCenter().into(it.image)
        }
    }

    inner class DesafioViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val image = itemView.desafioImage
        val title = itemView.desafioTitle
        val description = itemView.desafioDescription
    }
}