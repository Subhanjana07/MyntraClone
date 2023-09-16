package com.company.myntra_demo
import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager2.widget.ViewPager2

class ClickableViewPager2 @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {

    private lateinit var viewPager2: ViewPager2

    fun setViewPager2(viewPager2: ViewPager2) {
        this.viewPager2 = viewPager2
        addView(viewPager2)
    }

    init {
        setOnClickListener {
            // Handle the click event here
            // You can trigger a custom action when the ViewPager is clicked
            // For example, open an activity
            // Replace with your desired logic
        }
    }
}
