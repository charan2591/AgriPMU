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
import com.example.pmufirstapplication.models.SearchModel
import com.example.pmufirstapplication.viewmodels.MainViewModel
import com.example.pmufirstapplication.viewmodels.SearchViewModel

class RecyclerSearchViewAdapter(val viewModel: SearchViewModel, val arrayList: ArrayList<SearchModel>
                                , val context: Context
) : RecyclerView.Adapter<RecyclerSearchViewAdapter.SearchViewHolder>(){

    inner class SearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(itemModel: SearchModel)
        {
            itemView.findViewById<TextView>(R.id.name).text = itemModel.farmerName
            itemView.findViewById<TextView>(R.id.quantity).text = itemModel.quantity
            itemView.findViewById<TextView>(R.id.location).text = itemModel.location
            itemView.findViewById<TextView>(R.id.time).text = itemModel.eventTime
            itemView.findViewById<TextView>(R.id.price).text = itemModel.price
            itemView.findViewById<ImageButton>(R.id.delete).setOnClickListener{
//                viewModel.remove(itemModel)
//                notifyItemRemoved(arrayList.indexOf(itemModel))
//                val intent = Intent(context,BottomBarActivity::class.java)
//                context.startActivity(intent)

            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val root = LayoutInflater.from(context).inflate(R.layout.recycler_search_item,parent,false)
        return SearchViewHolder(root)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(arrayList[position])
    }

    override fun getItemCount(): Int {

        if(arrayList.size==0){
            Toast.makeText(context,"List is empty", Toast.LENGTH_LONG).show()
        }
        return arrayList.size
    }
}