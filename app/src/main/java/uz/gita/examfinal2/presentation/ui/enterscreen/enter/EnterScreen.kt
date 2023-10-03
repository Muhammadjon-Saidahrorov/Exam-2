package uz.gita.examfinal2.presentation.ui.enterscreen.enter

import android.os.Bundle
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uz.gita.examfinal2.R

class EnterScreen: Fragment(R.layout.screen_enter) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<ConstraintLayout>(R.id.container).setOnClickListener {
            findNavController().navigate(R.id.action_enterScreen3_to_enterViewScreen2)
        }
    }

}