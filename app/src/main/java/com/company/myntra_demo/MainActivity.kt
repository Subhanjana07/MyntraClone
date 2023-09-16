package com.company.myntra_demo
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.company.myntra_demo.Fragments.EverydayFragment
import com.company.myntra_demo.Fragments.HomeFragment
import com.company.myntra_demo.Fragments.LuxeFragment
import com.company.myntra_demo.Fragments.ProfileFragment
import com.company.myntra_demo.Fragments.TrendsFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.statusBarColor = ContextCompat.getColor(this, R.color.white)

        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
        val tabIcons = intArrayOf(
            R.drawable.myntra,
            R.drawable.fwdmyntra,
            R.drawable.tshirt,
            R.drawable.diamond,
            R.drawable.subhanjana
        )

        val tabTitles = arrayOf("Home", "Hot Trends", "Everyday", "Luxe", "Subhanjana")

        for (i in 0 until tabLayout.tabCount) {
            val tab = tabLayout.getTabAt(i)
            val customTabView = layoutInflater.inflate(R.layout.custom_tab_item_layout, null)

            val tabIcon = customTabView.findViewById<ImageView>(R.id.tab_icon)
            val tabText = customTabView.findViewById<TextView>(R.id.tab_text)

            tabIcon.setImageResource(tabIcons[i])
            tabText.text = tabTitles[i]

            tab?.customView = customTabView
        }

        val defaultTab = tabLayout.getTabAt(0)
        setTabColors(defaultTab, true)
        loadFragment(HomeFragment())

        tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val tabIcon = tab?.customView?.findViewById<ImageView>(R.id.tab_icon)
                val tabText = tab?.customView?.findViewById<TextView>(R.id.tab_text)

                if (tab?.position == 0 || tab?.position == 4) {
                    tabText?.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.pink))
                } else {
                    tabText?.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.pink))
                    tabIcon?.setColorFilter(
                        ContextCompat.getColor(this@MainActivity, R.color.pink),
                        PorterDuff.Mode.SRC_IN
                    )
                }

                when (tab?.position) {
                    0 -> loadFragment(HomeFragment())
                    1 -> loadFragment(TrendsFragment())
                    2 -> loadFragment(EverydayFragment())
                    3 -> loadFragment(LuxeFragment())
                    4 -> loadFragment(ProfileFragment())
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                val tabIcon = tab?.customView?.findViewById<ImageView>(R.id.tab_icon)
                val tabText = tab?.customView?.findViewById<TextView>(R.id.tab_text)

                if (tab?.position == 0 || tab?.position == 4) {
                    tabText?.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.black))
                } else {
                    tabText?.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.black))
                    tabIcon?.setColorFilter(
                        ContextCompat.getColor(this@MainActivity, R.color.black),
                        PorterDuff.Mode.SRC_IN
                    )
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                // Not needed for this example
            }
        })

    }

    private fun setTabColors(tab: TabLayout.Tab?, isSelected: Boolean) {
        val tabText = tab?.customView?.findViewById<TextView>(R.id.tab_text)
        val textColorResId = if (isSelected) R.color.pink else R.color.black
        tabText?.setTextColor(ContextCompat.getColor(this@MainActivity, textColorResId))
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }
}

