package com.example.workshala2


import android.annotation.SuppressLint
import android.content.Intent
import com.example.workshala2.R
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
class JobActivity : AppCompatActivity() {
    var tabLayout: TabLayout? = null
    var viewPager2: ViewPager2? = null
    var myViewPagerAdapter: MyViewPagerAdapter? = null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job)

        val apply = findViewById<Button>(R.id.buttonn)
        apply.setOnClickListener{
            val intent = Intent(this, ui_ux1::class.java)
            startActivity(intent)
        }
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


        val shareToOtherApps = findViewById<ImageView>(R.id.shareToOtherApps)

        val message = "Hello, this is the message to share!"

        shareToOtherApps.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type = "text/plain"
            startActivity(Intent.createChooser(intent, "Share to: "))
        }

    }
}