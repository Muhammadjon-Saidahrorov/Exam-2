package uz.gita.examfinal2.presentation.ui.createprofilscreen.createprofile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.examfinal2.R
import uz.gita.examfinal2.databinding.ScreenCreateProfileBinding
import uz.gita.examfinal2.databinding.ScreenSignInBinding
import uz.gita.examfinal2.presentation.viewmodel.CreateProfileViewModel
import uz.gita.examfinal2.presentation.viewmodel.SignInViewModel
import uz.gita.examfinal2.presentation.viewmodel.impl.CreateProfileViewModelImpl
import uz.gita.examfinal2.presentation.viewmodel.impl.SignInViewModelImpl

@AndroidEntryPoint
class CreateProfileScreen : Fragment(R.layout.screen_create_profile) {
    private val binding by viewBinding(ScreenCreateProfileBinding::bind)
    private val viewModel: CreateProfileViewModel by viewModels<CreateProfileViewModelImpl>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.openPinScreen.observe(this, openPinScreenObserver)
        viewModel.backBtn.observe(this, backBtnObserver)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            btnContinue.setOnClickListener {
                if (etFullName.text.isNotEmpty() && etNickName.text.isNotEmpty() && etDateOfBirth.text.isNotEmpty() && etEmail.text.isNotEmpty() && etGender.text.isNotEmpty()) {
                    viewModel.saveDates(
                        etFullName.text.toString(),
                        etNickName.text.toString(),
                        etDateOfBirth.text.toString(),
                        etEmail.text.toString(),
                        etGender.text.toString()
                    )
                }
            }

            btnBack.setOnClickListener {
                viewModel.backFun()
            }

        }
    }

    private val openPinScreenObserver = Observer<Unit> {
        findNavController().navigate(R.id.action_profileScreen2_to_profilePinScreen)
    }

    private val backBtnObserver = Observer<Unit> {
        findNavController().navigateUp()
    }
}