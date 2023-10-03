package uz.gita.examfinal2.presentation.ui.enterscreen.enter

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator
import uz.gita.examfinal2.R
import uz.gita.examfinal2.presentation.adapter.EnterViewAdapter

class EnterViewScreen : Fragment(R.layout.screen_enter_view) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonNext = view.findViewById<AppCompatButton>(R.id.nextBtn)

        val viewPager = view.findViewById<ViewPager2>(R.id.viewPager)
        val adapter = EnterViewAdapter(requireActivity())
        viewPager.adapter = adapter

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when (position) {
                    0 -> {
                        buttonNext.text = "Next"
                    }
                    1 -> {
                        buttonNext.text = "Next"
                    }
                    else -> {

                        buttonNext.text = "Get Started"
                    }
                }
            }
        })

        buttonNext.setOnClickListener {
            if (viewPager.currentItem != 2)
                viewPager.currentItem++
            else {
                findNavController().navigate(R.id.action_enterViewScreen2_to_loginScreen)
            }
        }

//        val dots = view.findViewById<WormDotsIndicator>(R.id.worm_dots_indicator)
//        dots.attachTo(viewPager)
    }
}