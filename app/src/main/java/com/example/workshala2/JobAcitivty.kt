package com.example.workshala2


import com.example.workshala2.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener


class JobActivity : AppCompatActivity() {
    var tabLayout: TabLayout? = null
    var viewPager2: ViewPager2? = null
    var myViewPagerAdapter: MyViewPagerAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job)
        tabLayout = findViewById<TabLayout>(R.id.tab_layout)
        viewPager2 = findViewById<ViewPager2>(R.id.view_pager)
        myViewPagerAdapter = MyViewPagerAdapter(this)
        viewPager2?.adapter = myViewPagerAdapter
        tabLayout?.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager2?.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
        viewPager2?.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                tabLayout?.getTabAt(position)?.select()
            }
        })
    }
}