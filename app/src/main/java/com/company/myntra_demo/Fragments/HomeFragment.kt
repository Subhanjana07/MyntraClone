package com.company.myntra_demo.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.company.myntra_demo.EmptyActivity
import com.company.myntra_demo.R

class HomeFragment : Fragment() {

    private lateinit var fragmentManager: FragmentManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_home, container, false)

        fragmentManager = childFragmentManager

        val cardFashion = view.findViewById<CardView>(R.id.card_fashion)
        val cardBeauty = view.findViewById<CardView>(R.id.card_beauty)
        val textViewFashion = view.findViewById<TextView>(R.id.textViewFashion)
        val textViewBeauty = view.findViewById<TextView>(R.id.textViewBeauty)
        val fabContainer = view.findViewById<FrameLayout>(R.id.fabContainer)
        val cardViewSearch = view.findViewById<CardView>(R.id.cardViewSearch)
        val linearLayoutInsider = view.findViewById<LinearLayout>(R.id.linearLayoutInsider)
        val imageViewBell = view.findViewById<ImageView>(R.id.imageViewBell)
        val imageViewHeart = view.findViewById<ImageView>(R.id.imageViewHeart)
        val imageViewCart = view.findViewById<ImageView>(R.id.imageViewCart)

        linearLayoutInsider.setOnClickListener {
            requireActivity().run{
                startActivity(Intent(this, EmptyActivity::class.java))
            }
        }

        imageViewBell.setOnClickListener {
            requireActivity().run{
                startActivity(Intent(this, EmptyActivity::class.java))
            }
        }

        imageViewHeart.setOnClickListener {
            requireActivity().run{
                startActivity(Intent(this, EmptyActivity::class.java))
            }
        }

        imageViewCart.setOnClickListener {
            requireActivity().run{
                startActivity(Intent(this, EmptyActivity::class.java))
            }
        }

        cardViewSearch.setOnClickListener {
            requireActivity().run{
                startActivity(Intent(this, EmptyActivity::class.java))
            }
        }
        val customFab = inflater.inflate(R.layout.custom_fab_layout, fabContainer, false)
        customFab.setOnClickListener {
                requireActivity().run {
                    startActivity(Intent(this, EmptyActivity::class.java))
                }
        }

        fabContainer.addView(customFab)

        replaceFragment(FashionFragment())
        cardFashion.setCardBackgroundColor(resources.getColor(android.R.color.black))
        textViewFashion.setTextColor(resources.getColor(android.R.color.white))

        cardFashion.setOnClickListener {

            cardFashion.setCardBackgroundColor(resources.getColor(android.R.color.black))
            textViewFashion.setTextColor(resources.getColor(android.R.color.white))
            cardBeauty.setCardBackgroundColor(resources.getColor(android.R.color.white))
            textViewBeauty.setTextColor(resources.getColor(android.R.color.black))

            replaceFragment(FashionFragment())
        }

        cardBeauty.setOnClickListener {

            cardBeauty.setCardBackgroundColor(resources.getColor(android.R.color.black))
            textViewBeauty.setTextColor(resources.getColor(android.R.color.white))
            cardFashion.setCardBackgroundColor(resources.getColor(android.R.color.white))
            textViewFashion.setTextColor(resources.getColor(android.R.color.black))

            replaceFragment(BeautyFragment())
        }

        return view
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
