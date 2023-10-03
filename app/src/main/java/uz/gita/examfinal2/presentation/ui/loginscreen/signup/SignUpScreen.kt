package uz.gita.examfinal2.presentation.ui.loginscreen.signup

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
import uz.gita.examfinal2.databinding.ScreenSignUpBinding
import uz.gita.examfinal2.presentation.viewmodel.SignInViewModel
import uz.gita.examfinal2.presentation.viewmodel.SignUpViewModel
import uz.gita.examfinal2.presentation.viewmodel.impl.SignInViewModelImpl
import uz.gita.examfinal2.presentation.viewmodel.impl.SignUpViewModelImpl

@AndroidEntryPoint
class SignUpScreen : Fragment(R.layout.screen_sign_up) {
    private val binding by viewBinding(ScreenSignUpBinding::bind)
    private val viewModel: SignUpViewModel by viewModels<SignUpViewModelImpl>()
    private var logic = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.openProfileScreen.observe(this, openProfileScreenObserver)
        viewModel.eyeButton.observe(this, eyeButtonObserver)
        viewModel.openSignIn.observe(this, openSignInObserver)
        viewModel.backButton.observe(this, backButtonObserver)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            btnSignUp.setOnClickListener {
                if (emailInput.text.toString().isNotEmpty() && passwordInput.text.toString()
                        .isNotEmpty()
                ) {
                    viewModel.signUpUser(emailInput.text.toString(), passwordInput.text.toString())
                }
            }

            eyePassword.setOnClickListener {
                viewModel.eye()
            }

            btnSignIn.setOnClickListener { viewModel.signIn() }

            btnBack.setOnClickListener { viewModel.back() }

        }
        viewModel.correctData.observe(viewLifecycleOwner, correctObserver)
        viewModel.errorData.observe(viewLifecycleOwner, errorObserver)

    }

    private val openProfileScreenObserver = Observer<Unit> {
        findNavController().navigate(R.id.action_signUpScreen_to_profileScreen2)
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


    private val openSignInObserver = Observer<Unit> {
        findNavController().navigate(R.id.action_signUpScreen_to_signInScreen3)
    }

    private val backButtonObserver = Observer<Unit> {
        findNavController().navigateUp()
    }
}