package com.example.appsinvo.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.appsinvo.MyBookingDetail
import com.example.appsinvo.R
import com.example.appsinvo.models.FakeDataModel

class MyBookingAdapter(private val bookingList: List<FakeDataModel>, val context: Context) :
    RecyclerView.Adapter<MyBookingAdapter.MyBookingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyBookingViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.booking_item, parent, false)
        return MyBookingViewHolder(view)

    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyBookingViewHolder, position: Int) {
        val bList = bookingList[position]

        holder.id.text = "Id: ${bList.id}"

        val shortTitle = if (bList.title.length > 10) {
            "${bList.title.substring(0, 10)}...."

        } else {
            bList.title
        }
        holder.title.text = "Title: $shortTitle"

        val shortBody = if (bList.body.length > 20) {
            "${bList.body.substring(0, 20)}....View Detail"
        } else {
            bList.body
        }
        holder.body.text = "Body: $shortBody"
    }

    override fun getItemCount(): Int {
        return bookingList.size
    }

    inner class MyBookingViewHolder(itemView: View) : ViewHolder(itemView) {

        val id: TextView = itemView.findViewById(R.id.txtId)
        val title: TextView = itemView.findViewById(R.id.txtTitle)
        val body: TextView = itemView.findViewById(R.id.txtBody)
        private val imgBookingDetails: ImageView = itemView.findViewById(R.id.imgShareBooking)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val selectedItem = bookingList[position]

                    val intent = Intent(context, MyBookingDetail::class.java)
                    intent.putExtra("Id", selectedItem.id)
                    intent.putExtra("Title", selectedItem.title)
                    intent.putExtra("body", selectedItem.body)
                    context.startActivity(intent)
                }
            }

            imgBookingDetails.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    /*  val shareBookingDetails = bookingList[position].toStringRepresentation() // Sending all data of booking
                      shareBooking(shareBookingDetails)*/
                    val shareBookingDetails = bookingList[position].id // Only single data send
                    shareBooking(shareBookingDetails)
                }
            }
        }

    }

    fun shareBooking(dataToShare: String?) {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        shareIntent.putExtra(Intent.EXTRA_TEXT, dataToShare)
        context.startActivity(Intent.createChooser(shareIntent, "Share Booking Details"))
    }
}