package com.example.globallogicchallenge.view

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.globallogicchallenge.R
import com.example.globallogicchallenge.model.Item

class AdapterItemList (private val itemList: List<Item>) : RecyclerView.Adapter<AdapterItemList.MainViewHolder>() {

    inner class MainViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {          // TODO ****  listener para cada item del recyclerView ****

            itemView.setOnClickListener { v: View ->

                val position : Int = adapterPosition

                val intent = Intent (v.context.applicationContext, ActivityDetail::class.java)

                intent.putExtra("title", itemList[position].title)
                intent.putExtra("description", itemList[position].description)
                intent.putExtra("image", itemList[position].image)

                v.context.startActivity(intent)


            }

        }

        fun bindData(item: Item) {

            val title = itemView.findViewById<TextView>(R.id.output_title)
            val description = itemView.findViewById<TextView>(R.id.output_description)
            val image = itemView.findViewById<ImageView>(R.id.output_image)





            title.text = item.title
            description.text = item.description
            image.load(item.image.replace("photos.ar","photos"))


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {

        return MainViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {

        holder.bindData(itemList[position])
    }

    override fun getItemCount(): Int {

        return itemList.size
    }



}