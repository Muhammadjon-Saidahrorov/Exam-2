package uz.gita.examfinal2.presentation.ui.enterscreen

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import uz.gita.examfinal2.R

class EnterViewPage: Fragment(R.layout.screen_enter_page) {
    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val pos = requireArguments().getInt("POS")
        val img = view.findViewById<ImageView>(R.id.imagePage)
        val textTitle = view.findViewById<AppCompatTextView>(R.id.textPage)

        when(pos) {
            0 -> {
                img.setImageResource(R.drawable.imgpage)
                textTitle.text = "Thousands of\n doctors and experts to\n help your health!"
            }
            1 -> {
                img.setImageResource(R.drawable.imgpage_1)
                textTitle.text = "Health chech &\n consutations easly\nanywhere anytime"
            }
            else -> {
                img.setImageResource(R.drawable.imgpage_2)
                textTitle.text = "Let's start living\nhealthy and well\nwith us right now"
            }
        }
    }
}