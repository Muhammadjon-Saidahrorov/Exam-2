package uz.gita.examfinal2.presentation.ui.loginscreen.signin

import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.examfinal2.R
import uz.gita.examfinal2.databinding.ScreenSignInBinding
import uz.gita.examfinal2.presentation.viewmodel.SignInViewModel
import uz.gita.examfinal2.presentation.viewmodel.impl.SignInViewModelImpl

@AndroidEntryPoint
class SignInScreen : Fragment(R.layout.screen_sign_in) {
    private val binding by viewBinding(ScreenSignInBinding::bind)
    private val viewModel: SignInViewModel by viewModels<SignInViewModelImpl>()
    private var logic = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.openHomeScreen.observe(this, openHomeScreenObserver)
        viewModel.eyeButton.observe(this, eyeButtonObserver)
        viewModel.openForgot.observe(this, openForgotObserver)
        viewModel.openSignUp.observe(this, openSignUpObserver)
        viewModel.backButton.observe(this, backButtonObserver)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            btnSignIn.setOnClickListener {
                if (emailInput.text.toString().isNotEmpty() && passwordInput.text.toString()
                        .isNotEmpty()
                ) {
                    viewModel.signInUser(emailInput.text.toString(), passwordInput.text.toString())
                }
            }

            eyePassword.setOnClickListener {
                viewModel.eye()
            }

            btnForget.setOnClickListener { viewModel.forgot() }

            btnSignUp.setOnClickListener { viewModel.signUp() }

            btnBack.setOnClickListener { viewModel.back() }

        }
        viewModel.correctData.observe(viewLifecycleOwner, correctObserver)
        viewModel.errorData.observe(viewLifecycleOwner, errorObserver)

    }

    private val openHomeScreenObserver = Observer<Unit> {
        findNavController().navigate(R.id.action_signInScreen_to_homeScreen2)
    }

    private val correctObserver = Observer<String> {
        Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
    }

    private val errorObserver = Observer<String> {
        Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
    }

    private val eyeButtonObserver = Observer<Unit> {
        if (!logic) {
            binding.passwordInput.inputType = 1
            binding.eyePassword.setImageResource(R.drawable.hidden)
            logic = !logic
        } else {
            binding.eyePassword.setImageResource(R.drawable.eye)
            binding.passwordInput.inputType =
                InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            logic = !logic
        }
    }

    private val openForgotObserver = Observer<Unit> {
        findNavController().navigate(R.id.action_signInScreen_to_forgotScreen)
    }

    private val openSignUpObserver = Observer<Unit> {
        findNavController().navigate(R.id.action_signInScreen_to_signUpScreen2)
    }

    private val backButtonObserver = Observer<Unit> {
        findNavController().navigateUp()
    }

}