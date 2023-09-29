package com.example.appsinvo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigation: BottomNavigationView

    // private val currentFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigation = findViewById(R.id.bottomNavigation)

        window.statusBarColor = ContextCompat.getColor(this, R.color.primary_color)

        bottomNavigation.setOnItemSelectedListener { menuItem ->

            when (menuItem.itemId) {
                R.id.myBooking -> {
                    loadFragment(MyBooking(), addToBackStack = true)
                    true
                }

                R.id.scanQr -> {
                    loadFragment(MyScanQrFragment(), addToBackStack = true)
                    true
                }

                R.id.homeItem -> {
                    loadFragment(HomeFragment(), addToBackStack = true)
                    true
                }

                R.id.myQr -> {
                    loadFragment(MyQrFragment(), addToBackStack = true)
                    true
                }

                R.id.profile -> {
                    loadFragment(MyProfileFragment(), addToBackStack = true)
                    true
                }

                else -> false
            }
        }

        loadFragment(HomeFragment())
    }

    private fun loadFragment(fragment: Fragment, addToBackStack: Boolean = false) {
        val transaction = supportFragmentManager.beginTransaction()

        transaction.replace(R.id.fragmentContainer, fragment)

        if (addToBackStack) {
            transaction.addToBackStack(null)
        }

        transaction.commit()
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }
}
