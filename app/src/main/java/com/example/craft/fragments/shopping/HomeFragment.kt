package com.example.craft.fragments.shopping

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.craft.R
import com.example.craft.adapters.HomeViewpagerAdapter
import com.example.craft.databinding.FragmentHomeBinding
import com.example.craft.fragments.categories.LuggageBagFragment
import com.example.craft.fragments.categories.SlingBagFragments
import com.example.craft.fragments.categories.DuffelBagFragment
import com.example.craft.fragments.categories.MainCategoryFragment
import com.example.craft.fragments.categories.SchoolBagFragment
import com.example.craft.fragments.categories.HandbagFragment
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categoriesFragments = arrayListOf(
            MainCategoryFragment(),
            DuffelBagFragment(),
            LuggageBagFragment(),
            SchoolBagFragment(),
            SlingBagFragments(),
            HandbagFragment()
        )

        binding.viewpagerHome.isUserInputEnabled = false

        val viewPager2Adapter =
            HomeViewpagerAdapter(categoriesFragments, childFragmentManager, lifecycle)
        binding.viewpagerHome.adapter = viewPager2Adapter
        TabLayoutMediator(binding.tabLayout, binding.viewpagerHome) { tab, position ->
            when (position) {
                0 -> tab.text = "Home"
                1 -> tab.text = "Duffel's"
                2 -> tab.text = "Luggage's"
                3 -> tab.text = "School Bags"
                4 -> tab.text = "Sling Bag"
                5 -> tab.text = "Handbags"
            }
        }.attach()
    }
}