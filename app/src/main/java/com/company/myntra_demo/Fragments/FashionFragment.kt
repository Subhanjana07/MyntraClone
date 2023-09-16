package com.company.myntra_demo.Fragments

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.company.myntra_demo.EmptyActivity
import com.company.myntra_demo.SliderAdapters.ImageSliderAdapter
import com.company.myntra_demo.R
import com.company.myntra_demo.SliderAdapters.TextSliderAdapter
import java.util.*

class FashionFragment : Fragment(), ViewPager.OnPageChangeListener {

    private lateinit var viewPager: ViewPager2
    private lateinit var imageSliderAdapter: ImageSliderAdapter
    private lateinit var indicatorLayout: LinearLayout
    private lateinit var textSlider: ViewPager2
    private lateinit var textSliderAdapter: TextSliderAdapter
    private val textList = listOf(
        "SPONSERED BY LAKMÉ",
        "ℕ\uD835\uDD3C\uD835\uDD4E \uD835\uDD4A\uD835\uDD3C\uD835\uDD38\uD835\uDD4A\uD835\uDD46ℕ",
        "\uD83C\uDF6A  \uD83C\uDF80  \uD835\uDCAF\uD835\uDC45\uD835\uDC38\uD835\uDCA9\uD835\uDC9F\uD835\uDCAE \uD835\uDC45\uD835\uDC38\uD835\uDC39\uD835\uDC45\uD835\uDC38\uD835\uDCAE\uD835\uDC3B \uD835\uDC9C\uD835\uDC3F\uD835\uDC38\uD835\uDC45\uD835\uDCAF  \uD83C\uDF80  \uD83C\uDF6A",
        "Ａｕｔｕｍｎ－Ｗｉｎｔｅｒ＇２３"
    )
    private val imageList = listOf(
        "https://static.toiimg.com/photo/msid-89989830/89989830.jpg",
        "https://mir-s3-cdn-cf.behance.net/project_modules/hd/87495881231087.5cf900ed157f2.jpg",
        "https://img.paisawapas.com/ovz3vew9pw/2023/08/09111213/myntra-PaisaWapas-Deal-1.jpg",
        "https://indian-retailer.s3.ap-south-1.amazonaws.com/s3fs-public/2022-09/BFF%20Fb%20Cover%20celeb%20%281%29.jpg",
        "https://www.grabon.in/indulge/wp-content/uploads/2023/09/Fashion-Bazaar-Myntra-Upcoming-Sale.jpg",
        "https://assets.myntassets.com/f_auto,q_auto:eco,dpr_1.3,w_600,c_limit,fl_progressive/assets/images/retaillabs/2023/8/29/96308965-a40a-449b-aeff-52f4f65ccf711693319762267-PB-Banner_3.png"
    )

    private val handler = Handler(Looper.getMainLooper())
    private val imageSwitchRunnable = Runnable {
        viewPager.currentItem = (viewPager.currentItem + 1) % imageList.size
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_fashion, container, false)

        viewPager = view.findViewById(R.id.viewPager)
        indicatorLayout = view.findViewById(R.id.indicatorLayout)
        imageSliderAdapter = ImageSliderAdapter(imageList, indicatorLayout)
        val linearLayoutTopOffers = view.findViewById<LinearLayout>(R.id.linearLayoutTopOffers)
        val linearLayoutMen = view.findViewById<LinearLayout>(R.id.linearLayoutMen)
        val linearLayoutWomen = view.findViewById<LinearLayout>(R.id.linearLayoutWomen)
        val linearLayoutKids = view.findViewById<LinearLayout>(R.id.linearLayoutKids)
        val linearLayoutFootwear = view.findViewById<LinearLayout>(R.id.linearLayoutFootwear)
        val linearLayoutRakhi = view.findViewById<LinearLayout>(R.id.linearLayoutRakhi)
        val linearLayoutBeauty = view.findViewById<LinearLayout>(R.id.linearLayoutBeauty)
        val linearLayoutHome = view.findViewById<LinearLayout>(R.id.linearLayoutHome)
        val linearLayoutAccessories = view.findViewById<LinearLayout>(R.id.linearLayoutAccessories)
        val linearLayoutGadgets = view.findViewById<LinearLayout>(R.id.linearLayoutGadgets)

        linearLayoutTopOffers.setOnClickListener {
            requireActivity().run{
                startActivity(Intent(this, EmptyActivity::class.java))
            }
        }
        linearLayoutMen.setOnClickListener {
            requireActivity().run{
                startActivity(Intent(this, EmptyActivity::class.java))
            }
        }
        linearLayoutWomen.setOnClickListener {
            requireActivity().run{
                startActivity(Intent(this, EmptyActivity::class.java))
            }
        }
        linearLayoutKids.setOnClickListener {
            requireActivity().run{
                startActivity(Intent(this, EmptyActivity::class.java))
            }
        }
        linearLayoutFootwear.setOnClickListener {
            requireActivity().run{
                startActivity(Intent(this, EmptyActivity::class.java))
            }
        }
        linearLayoutRakhi.setOnClickListener {
            requireActivity().run{
                startActivity(Intent(this, EmptyActivity::class.java))
            }
        }
        linearLayoutBeauty.setOnClickListener {
            requireActivity().run{
                startActivity(Intent(this, EmptyActivity::class.java))
            }
        }
        linearLayoutHome.setOnClickListener {
            requireActivity().run{
                startActivity(Intent(this, EmptyActivity::class.java))
            }
        }
        linearLayoutAccessories.setOnClickListener {
            requireActivity().run{
                startActivity(Intent(this, EmptyActivity::class.java))
            }
        }
        linearLayoutGadgets.setOnClickListener {
            requireActivity().run{
                startActivity(Intent(this, EmptyActivity::class.java))
            }
        }

        viewPager.setOnClickListener {
            // Handle image slider click here
            val currentItem = viewPager.currentItem
            // Determine the destination activity based on the current item or any other logic
            val destinationActivity = when (currentItem) {
                0 -> EmptyActivity::class.java // Example: Open EmptyActivity for the first item
                1 -> EmptyActivity::class.java::class.java // Add more cases as needed
                else -> EmptyActivity::class.java // Default to EmptyActivity
            }

            // Start the selected activity
            startActivity(Intent(context, destinationActivity))
        }

        viewPager.adapter = imageSliderAdapter

        textSlider = view.findViewById(R.id.textViewPager)
        textSliderAdapter = TextSliderAdapter(textList)
        textSlider.adapter = textSliderAdapter

        val autoSlideDelayMillis = 3000L // 3 seconds
        val textSliderHandler = Handler(Looper.getMainLooper())
        val textSlideSwitchRunnable = Runnable {
            textSlider.currentItem = (textSlider.currentItem + 1) % textList.size
        }

        val textSliderTimer = Timer()
        textSliderTimer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                textSliderHandler.post(textSlideSwitchRunnable)
            }
        }, autoSlideDelayMillis, autoSlideDelayMillis)

        val timer = Timer()
        timer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                handler.post(imageSwitchRunnable)
            }
        }, autoSlideDelayMillis, autoSlideDelayMillis)

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                updateIndicators(position)
            }
        })
        initializeIndicators()

        return view
    }
    private fun initializeIndicators() {
        for (i in 0 until imageList.size) {
            val indicator = ImageView(requireContext())
            indicator.setImageResource(R.drawable.indicator_dot_selector)
            val layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            layoutParams.setMargins(8, 0, 8, 0) // Adjust margin as needed
            indicator.layoutParams = layoutParams
            indicator.isSelected = i == 0
            indicatorLayout.addView(indicator)
        }
    }

    private fun updateIndicators(selectedPosition: Int) {
        for (i in 0 until indicatorLayout.childCount) {
            val indicator = indicatorLayout.getChildAt(i) as ImageView
            indicator.isSelected = i == selectedPosition
        }
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        TODO("Not yet implemented")
    }

    override fun onPageSelected(position: Int) {
        TODO("Not yet implemented")
    }

    override fun onPageScrollStateChanged(state: Int) {
        TODO("Not yet implemented")
    }

}
