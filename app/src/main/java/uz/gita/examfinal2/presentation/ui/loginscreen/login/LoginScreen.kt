package uz.gita.examfinal2.presentation.ui.loginscreen.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer

import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.examfinal2.R
import uz.gita.examfinal2.databinding.ScreenLoginBinding
import uz.gita.examfinal2.presentation.viewmodel.LoginViewModel
import uz.gita.examfinal2.presentation.viewmodel.impl.LoginViewModelImpl

@AndroidEntryPoint
class LoginScreen : Fragment(R.layout.screen_login) {
    private val binding by viewBinding(ScreenLoginBinding::bind)
    private val viewModel: LoginViewModel by viewModels<LoginViewModelImpl>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.openSignIn.observe(this, openSignInObserver)
        viewModel.openSignUp.observe(this, openSignUpObserver)
        viewModel.backButton.observe(this, backButtonObserver)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSignIn.setOnClickListener {
            viewModel.signIn()
        }

        binding.btnSignUp.setOnClickListener {
            viewModel.signUp()
        }

        binding.btnBack.setOnClickListener {
            viewModel.back()
        }


    }

    private val openSignInObserver = Observer<Unit> {
        findNavController().navigate(R.id.action_loginScreen_to_signInScreen2)
    }

    private val openSignUpObserver = Observer<Unit> {
        findNavController().navigate(R.id.action_loginScreen_to_signUpScreen3)
    }

    private val backButtonObserver = Observer<Unit> {
        findNavController().navigateUp()
    }
}