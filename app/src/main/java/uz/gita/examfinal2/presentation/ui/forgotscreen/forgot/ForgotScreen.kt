package uz.gita.examfinal2.presentation.ui.forgotscreen.forgot

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.examfinal2.R
import uz.gita.examfinal2.databinding.ScreenForgotBinding
import uz.gita.examfinal2.presentation.viewmodel.ForgotViewModel
import uz.gita.examfinal2.presentation.viewmodel.impl.ForgotViewModelImpl

@AndroidEntryPoint
class ForgotScreen : Fragment(R.layout.screen_forgot) {
    private val binding by viewBinding(ScreenForgotBinding::bind)
    private val viewModel: ForgotViewModel by viewModels<ForgotViewModelImpl>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.openVerifyScreen.observe(this, openVerifyScreenObserver)
        viewModel.backButton.observe(this, backButtonObserver)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {

            card1.setOnClickListener {
                cardDef1.visibility = View.VISIBLE
                cardDef2.visibility = View.INVISIBLE
            }

            card2.setOnClickListener {
                cardDef1.visibility = View.INVISIBLE
                cardDef2.visibility = View.VISIBLE
            }

            continueBtn.setOnClickListener {
                viewModel.verifyScreen()
            }

            backBtn.setOnClickListener {
                viewModel.back()
            }

        }
    }

    private val openVerifyScreenObserver = Observer<Unit> {
        findNavController().navigate(R.id.action_forgotScreen_to_forgotVerify)
    }

    private val backButtonObserver = Observer<Unit> {
        findNavController().navigateUp()
    }
}