package com.bcarbonesi.cineapp_atc.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.bcarbonesi.cineapp_atc.Ui.Fragments.DestaqueFragment
import com.bcarbonesi.cineapp_atc.Ui.Fragments.NovidadesFragment
import com.bcarbonesi.cineapp_atc.Ui.Fragments.PraDepoisFragment
import com.bcarbonesi.cineapp_atc.Ui.Fragments.RankingFragment
import androidx.fragment.app.FragmentPagerAdapter
import com.google.android.material.snackbar.Snackbar

class TabPagerAdapter (fm: FragmentManager, private var tabCount: Int) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {

        when (position) {
            0 -> return NovidadesFragment()
            1 -> return DestaqueFragment()
            2 -> return RankingFragment()
            3 -> return PraDepoisFragment()

            else -> return NovidadesFragment()
        }

    }

    override fun getCount(): Int {
        return tabCount
    }
}