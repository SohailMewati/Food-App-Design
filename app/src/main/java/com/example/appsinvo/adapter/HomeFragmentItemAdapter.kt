package com.example.appsinvo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.appsinvo.models.HomeFragmentItemModel
import com.example.appsinvo.R

class HomeFragmentItemAdapter(
    private val homeItemList: List<HomeFragmentItemModel>,
    val context: Context
) :
    RecyclerView.Adapter<HomeFragmentItemAdapter.MyHomeItemsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHomeItemsViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.home_fragment_item, parent, false)
        return MyHomeItemsViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyHomeItemsViewHolder, position: Int) {
        val itemList = homeItemList[position]

        holder.image.setImageResource(itemList.img)
        holder.title.text = itemList.title
    }

    override fun getItemCount(): Int {
        return homeItemList.size
    }


    class MyHomeItemsViewHolder(itemView: View) : ViewHolder(itemView) {

        val image: ImageView = itemView.findViewById(R.id.imgItem)
        val title: TextView = itemView.findViewById(R.id.txtTitle)

    }
}