package com.alliebe.mastersejin

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.alliebe.mastersejin.com.alliebe.mastersejin.LookaroundFragment
import com.alliebe.mastersejin.com.alliebe.mastersejin.QuestionFragment
import com.alliebe.mastersejin.com.alliebe.mastersejin.RecommendFragment

class ViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm){
    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> RecommendFragment()
            1 -> LookaroundFragment()
            else -> QuestionFragment()
        }
    }

    override fun getCount() = 3

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        super.destroyItem(container, position, `object`)
    }
}