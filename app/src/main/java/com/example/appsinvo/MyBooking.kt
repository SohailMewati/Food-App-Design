package com.example.appsinvo

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appsinvo.adapter.MyBookingAdapter
import com.example.appsinvo.models.FakeDataModel
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Suppress("UNREACHABLE_CODE")
class MyBooking : Fragment() {

    private var bookingList: ArrayList<FakeDataModel> = ArrayList()
    private lateinit var bookingRecyclerView: RecyclerView

    private lateinit var bookingAdapter: MyBookingAdapter

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_my_booking, container, false)

        bookingRecyclerView = view.findViewById(R.id.bookingRecyclerView)

        // Call a function to make the network request


        bookingRecyclerView.layoutManager = LinearLayoutManager(context)


        bookingAdapter = context?.let { MyBookingAdapter(bookingList, it) }!!
        bookingRecyclerView.adapter = bookingAdapter

        fetchDataFromApi()



        return view
    }

    @OptIn(DelicateCoroutinesApi::class)
    @SuppressLint("NotifyDataSetChanged")
    private fun fetchDataFromApi() {

        GlobalScope.launch(Dispatchers.Default) {
            val apiService = FoodRetrofit().getInstance()

            val data = apiService.getFakeApiData()

            if (data.isSuccessful) {

                val responseData = data.body()

                GlobalScope.launch(Dispatchers.Main) {

                    if (responseData != null) {
                        bookingList.addAll(responseData)
                    }

                    bookingAdapter.notifyDataSetChanged()
                    Log.e("Sohail", responseData.toString())
                }
            }
        }
    }
}
