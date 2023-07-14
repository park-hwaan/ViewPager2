package com.example.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentFactory
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(
    private val fragmentActivity: FragmentActivity,
    private val fragments : List<Fragment> = listOf(Fragment1(),Fragment2(),Fragment3())
) : FragmentStateAdapter(fragmentActivity)  {
    private val itemCount = Int.MAX_VALUE

    override fun getItemCount(): Int {
        return itemCount
    }

    override fun createFragment(position: Int): Fragment {
        val realPosition = position % getRealItemCount()
        return fragments[realPosition]
    }

    override fun getItemId(position: Int): Long {
        val realPosition = position % getRealItemCount()
        return fragments[realPosition].hashCode().toLong()
    }

    private fun getRealItemCount(): Int {
        return fragments.size
    }
}
