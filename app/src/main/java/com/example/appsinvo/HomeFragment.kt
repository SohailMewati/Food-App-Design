package com.example.appsinvo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.appsinvo.adapter.HomeFragmentItemAdapter
import com.example.appsinvo.models.HomeFragmentItemModel
import com.google.android.material.bottomnavigation.BottomNavigationView

@Suppress("UNREACHABLE_CODE")
class HomeFragment : Fragment() {

    private lateinit var homeFragmentRecyclerView: RecyclerView
    lateinit var homeFragmentAdapter: HomeFragmentItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.home_fragement, container, false)

        val viewPager = view?.findViewById<ViewPager>(R.id.homeViewPager)
        val indicator = view?.findViewById<LinearLayout>(R.id.indicatorContainer)

        val bottomNavigationView =
            activity?.findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigationView?.menu?.findItem(R.id.homeItem)?.isChecked = true

        homeFragmentRecyclerView = view.findViewById(R.id.homeRecyclerView)
        homeFragmentRecyclerView.layoutManager = GridLayoutManager(context, 3)

        val homeItem: ArrayList<HomeFragmentItemModel> = ArrayList()

        homeItem.add(HomeFragmentItemModel(R.drawable.mall, "Mall"))
        homeItem.add(HomeFragmentItemModel(R.drawable.saloon, "Beauty"))
        homeItem.add(HomeFragmentItemModel(R.drawable.restaurant, "Restaurant"))
        homeItem.add(HomeFragmentItemModel(R.drawable.restaurant, "Food Court"))

        homeItem.add(HomeFragmentItemModel(R.drawable.mall, "Mall"))
        homeItem.add(HomeFragmentItemModel(R.drawable.saloon, "Beauty"))
        homeItem.add(HomeFragmentItemModel(R.drawable.restaurant, "Restaurant"))

        homeFragmentAdapter = context?.let { HomeFragmentItemAdapter(homeItem, it) }!!
        homeFragmentRecyclerView.adapter = homeFragmentAdapter

        val images = listOf(R.drawable.offer, R.drawable.coatpnt, R.drawable.specialoffer)
        val adapter = ImageSliderAdapter(images)

        viewPager?.adapter = adapter

        for (i in images.indices) {

            val indicatorView = LayoutInflater.from(context)
                .inflate(R.layout.indicator_layout, indicator, false)
            indicator?.addView(indicatorView)

            indicatorView.setOnClickListener {
                viewPager?.setCurrentItem(i, true)
            }

            viewPager?.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {
                    // Not used in this example
                }

                override fun onPageSelected(position: Int) {
                    for (index in 0 until indicator!!.childCount) {
                        val indicator = indicator.getChildAt(index) as ImageView
                        indicator.setImageResource(if (index == position) R.drawable.selected else R.drawable.unselected)
                    }
                }

                override fun onPageScrollStateChanged(state: Int) {
                    // Not used in this example
                }
            })

        }
        return view

    }


}