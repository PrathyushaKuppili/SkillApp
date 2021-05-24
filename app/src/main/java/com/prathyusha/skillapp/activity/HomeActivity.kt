package com.prathyusha.skillapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.prathyusha.skillapp.fragment.NotifyFragment
import com.prathyusha.skillapp.fragment.ProfileFragment
import com.prathyusha.skillapp.R
import com.prathyusha.skillapp.fragment.BookmarkFragment
import com.prathyusha.skillapp.fragment.HomeFragment


class HomeActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var newsLayoutManager: LinearLayoutManager
    lateinit var bottomNav: BottomNavigationView
    private val homeFragment= HomeFragment()
    private val bookFragment= BookmarkFragment()
    private val notifyFragment= NotifyFragment()
    private val profileFragment= ProfileFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        replaceFragment(homeFragment)

        bottomNav=findViewById(R.id.bottomNav)
        bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> {
                    replaceFragment(homeFragment)
                    true
                }
                R.id.nav_bookmark -> {
                    replaceFragment(bookFragment)
                    true
                }
                R.id.nav_notify -> {
                    replaceFragment(notifyFragment)
                    true
                }
                R.id.nav_profile -> {
                    replaceFragment(profileFragment)
                    true
                }
                else -> false
            }
        }
    }

    private fun replaceFragment(fragment : Fragment){
        if(fragment!=null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainer,fragment)
            transaction.commit()
        }
    }
    }