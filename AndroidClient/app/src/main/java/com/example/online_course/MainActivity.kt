package com.example.online_course

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.online_course.databinding.ActivityMainBinding
import com.example.online_course.utils.ToastUtil.toast
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var bottomNavigationView: BottomNavigationView
    private var mFragments = mutableListOf<Fragment>()
    private var lastIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bottomNavigationView = binding.navigationView

        setSupportActionBar(binding.toolbar)
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setHomeAsUpIndicator(R.drawable.menu_white)
        }

        initBottomNavigation()
        initData()
    }


    private fun initData() {
        mFragments = ArrayList()
        mFragments.add(DashBoardFragment())
        mFragments.add(StoreFragment())
        mFragments.add(ProfileFragment())
        // 初始化展示MessageFragment
        setFragmentPosition(0)
    }

    private fun setFragmentPosition(position: Int) {
        val ft = supportFragmentManager.beginTransaction()
        val currentFragment = mFragments[position]
        val lastFragment = mFragments[lastIndex]
        lastIndex = position
        ft.hide(lastFragment)
        if (!currentFragment.isAdded) {
            supportFragmentManager.beginTransaction().remove(currentFragment).commit()
            ft.add(R.id.my_nav_host_fragment, currentFragment)
        }
        ft.show(currentFragment)
        ft.commitAllowingStateLoss()
    }
    private fun initBottomNavigation() {
        bottomNavigationView.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_dashboard -> setFragmentPosition(0)
                R.id.menu_store -> setFragmentPosition(1)
                R.id.menu_profile -> setFragmentPosition(2)
                else -> {
                }
            }
            true
        })
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> binding.drawerLayout.openDrawer(GravityCompat.START)
            R.id.menu_email -> "click email".toast(this)
        }
        return true
    }

}