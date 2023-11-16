package com.example.workshala2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewCategoryAdapter(private val getActivity: MainActivity_param, private val movieList: MutableList<Category>) :
    RecyclerView.Adapter<RecyclerViewCategoryAdapter.MyViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_movie_list_item,parent,false)

        return MyViewHolder(view)
    }
    override fun getItemCount(): Int {
        return movieList.size
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvMovieTitle.text=movieList[position].title
        holder.ivMovieImg.setImageResource(movieList[position].image)
        holder.cardView.setOnClickListener{
            Toast.makeText(getActivity,movieList[position].title, Toast.LENGTH_LONG).show()
        }
    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvMovieTitle : TextView = itemView.findViewById(R.id.tvMovieTitle)
        val ivMovieImg : ImageView = itemView.findViewById(R.id.ivMovieImg)
        val cardView : CardView = itemView.findViewById(R.id.cardView)
    }
}