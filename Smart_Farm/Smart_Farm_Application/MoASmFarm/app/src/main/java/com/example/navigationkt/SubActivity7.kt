package com.example.navigationkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import com.example.navigationkt.sub7fragment.Fragment701
import com.example.navigationkt.sub7fragment.Fragment702
import com.example.navigationkt.sub7fragment.Fragment703
import com.example.navigationkt.sub7fragment.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_sub7.*

class SubActivity7 : AppCompatActivity() {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub7)

        setUpTabs()
    }

    private fun setUpTabs(){
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(Fragment701(), "씨앗")
        adapter.addFragment(Fragment702(), "모종")
        adapter.addFragment(Fragment703(), "기구")
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)

        tabs.getTabAt(0)!!.setIcon(R.drawable.ic_baseline_accessibility_24)
        tabs.getTabAt(1)!!.setIcon(R.drawable.ic_baseline_email_24)
        tabs.getTabAt(2)!!.setIcon(R.drawable.ic_baseline_leaf)



    }
}