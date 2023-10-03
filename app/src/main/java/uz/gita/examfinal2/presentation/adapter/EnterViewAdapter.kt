package uz.gita.examfinal2.presentation.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.gita.examfinal2.presentation.ui.enterscreen.EnterViewPage

class EnterViewAdapter(fmActivity: FragmentActivity): FragmentStateAdapter(fmActivity) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        val fm = EnterViewPage()
        val bundle = Bundle()
        bundle.putInt("POS", position)
        fm.arguments = bundle
        return fm
    }

}