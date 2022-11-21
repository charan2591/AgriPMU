package com.example.pmufirstapplication.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

import com.example.pmufirstapplication.R
import com.example.pmufirstapplication.models.MainModel
import com.example.pmufirstapplication.viewmodels.MainViewModel

class RecyclerAdapter(val viewModel: MainViewModel , val arrayList: ArrayList<MainModel>
, val context: Context) : RecyclerView.Adapter<RecyclerAdapter.MainViewHolder>(){

    class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(itemModel: MainModel)
        {
            itemView.findViewById<TextView>(R.id.title).text = itemModel.title
            itemView.findViewById<ImageButton>(R.id.delete).setOnClickListener{

            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val root = LayoutInflater.from(context).inflate(R.layout.recycler_item,parent,false)
        return MainViewHolder(root)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
       holder.bind(arrayList[position])
    }

    override fun getItemCount(): Int {

        if(arrayList.size==0){
            Toast.makeText(context,"List is empty", Toast.LENGTH_LONG).show()
        }

       return arrayList.size
    }
}