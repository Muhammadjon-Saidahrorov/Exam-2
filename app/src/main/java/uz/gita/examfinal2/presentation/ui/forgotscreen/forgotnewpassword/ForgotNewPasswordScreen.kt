package uz.gita.examfinal2.presentation.ui.forgotscreen.forgotnewpassword

import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uz.gita.examfinal2.R
import uz.gita.examfinal2.databinding.ScreenForgotNewPasswordBinding
import uz.gita.examfinal2.presentation.viewmodel.ForgotNewPasswordViewModel
import uz.gita.examfinal2.presentation.viewmodel.impl.ForgotNewPasswordViewModelImpl

@AndroidEntryPoint
class ForgotNewPasswordScreen : Fragment(R.layout.screen_forgot_new_password) {
    private val binding by viewBinding(ScreenForgotNewPasswordBinding::bind)
    private val viewModel: ForgotNewPasswordViewModel by viewModels<ForgotNewPasswordViewModelImpl>()
    private var logic1 = false
    private var logic2 = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.openHomeScreen.observe(this, openHomeScreenObserver)
        viewModel.eyeButton1.observe(this, eyeButtonObserver1)
        viewModel.eyeButton2.observe(this, eyeButtonObserver2)
        viewModel.backButton.observe(this, backButtonObserver)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {

            continueBtn.setOnClickListener {
                if (passwordInput1.text.toString() != passwordInput2.text.toString()) {
                    Toast.makeText(
                        requireContext(),
                        "Password =? Confirm Password",
                        Toast.LENGTH_SHORT
                    ).show()
                } else if (passwordInput1.text.isNotEmpty() && passwordInput1.text.toString().length >= 6) {

                    val viewDialog: View = LayoutInflater.from(requireContext())
                        .inflate(R.layout.dialog_congrats, null)
                    val dialog = androidx.appcompat.app.AlertDialog.Builder(requireContext())
                        .setCancelable(false)
                        .setView(viewDialog)
                        .create()
                    dialog.show()
                    dialog.window?.setBackgroundDrawable(null)

                    lifecycleScope.launch {
                        delay(1500)

                        viewDialog.findViewById<ImageView>(R.id.imgChecked).visibility =
                            View.VISIBLE
                        viewDialog.findViewById<ProgressBar>(R.id.progressDialog).visibility =
                            View.GONE
                        delay(1000)

                        dialog.dismiss()
                        viewModel.homeScreen()

                    }

                } else {
                    Toast.makeText(requireContext(), "Password leangth >= 6", Toast.LENGTH_SHORT)
                        .show()
                }
            }

            eyePassword1.setOnClickListener { viewModel.eye1() }
            eyePassword2.setOnClickListener { viewModel.eye2() }

            backBtn.setOnClickListener {
                viewModel.back()
            }

        }
    }

    private val openHomeScreenObserver = Observer<Unit> {
        findNavController().navigate(R.id.action_forgotNewPasswordScreen_to_homeScreen2)
    }

    private val eyeButtonObserver1 = Observer<Unit> {
        if (!logic1) {
            binding.passwordInput1.inputType = 1
            binding.eyePassword1.setImageResource(R.drawable.hidden)
            logic1 = !logic1
        } else {
            binding.eyePassword1.setImageResource(R.drawable.eye)
            binding.passwordInput1.inputType =
                InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            logic1 = !logic1
        }
    }

    private val eyeButtonObserver2 = Observer<Unit> {
        if (!logic2) {
            binding.passwordInput2.inputType = 1
            binding.eyePassword2.setImageResource(R.drawable.hidden)
            logic2 = !logic2
        } else {
            binding.eyePassword2.setImageResource(R.drawable.eye)
            binding.passwordInput2.inputType =
                InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            logic2 = !logic2
        }
    }

    private val backButtonObserver = Observer<Unit> {
        findNavController().navigateUp()
    }
}