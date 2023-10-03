package uz.gita.examfinal2.presentation.ui.forgotscreen.forgotverify

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
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
import uz.gita.examfinal2.databinding.ScreenForgotCodeVerificationBinding
import uz.gita.examfinal2.presentation.viewmodel.ForgotVerifyViewModel
import uz.gita.examfinal2.presentation.viewmodel.ForgotViewModel
import uz.gita.examfinal2.presentation.viewmodel.impl.ForgotVerifyViewmodelImpl
import uz.gita.examfinal2.presentation.viewmodel.impl.ForgotViewModelImpl
import uz.gita.examfinal2.utils.myLog

@AndroidEntryPoint
class ForgotVerify : Fragment(R.layout.screen_forgot_code_verification) {

    private val binding by viewBinding(ScreenForgotCodeVerificationBinding::bind)
    private val viewModel: ForgotVerifyViewModel by viewModels<ForgotVerifyViewmodelImpl>()
    private var code = StringBuilder("")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.openNewPasswordScreen.observe(this, openNewPasswordScreenObserver)
        viewModel.backButton.observe(this, backButtonObserver)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            code.clear()

            keyboard.btOne.setOnClickListener {
                setNumber("1", firstNum, secondNum, thirdNum, fourthNum)
            }
            keyboard.btTwo.setOnClickListener {
                setNumber("2", firstNum, secondNum, thirdNum, fourthNum)
            }
            keyboard.btThree.setOnClickListener {
                setNumber("3", firstNum, secondNum, thirdNum, fourthNum)
            }
            keyboard.btFour.setOnClickListener {
                setNumber("4", firstNum, secondNum, thirdNum, fourthNum)
            }
            keyboard.btFive.setOnClickListener {
                setNumber("5", firstNum, secondNum, thirdNum, fourthNum)
            }
            keyboard.btSix.setOnClickListener {
                setNumber("6", firstNum, secondNum, thirdNum, fourthNum)
            }
            keyboard.btSeven.setOnClickListener {
                setNumber("7", firstNum, secondNum, thirdNum, fourthNum)
            }
            keyboard.btEight.setOnClickListener {
                setNumber("8", firstNum, secondNum, thirdNum, fourthNum)
            }
            keyboard.btNine.setOnClickListener {
                setNumber("9", firstNum, secondNum, thirdNum, fourthNum)
            }
            keyboard.btZero.setOnClickListener {
                setNumber("0", firstNum, secondNum, thirdNum, fourthNum)
            }
            keyboard.btClear.setOnClickListener {

                if (fourthNum.text.isNotEmpty()) {
                    fourthNum.text = ""
                    code.deleteCharAt(code.length - 1)
                } else if (thirdNum.text.isNotEmpty()) {
                    thirdNum.text = ""
                    code.deleteCharAt(code.length - 1)
                } else if (secondNum.text.isNotEmpty()) {
                    secondNum.text = ""
                    code.deleteCharAt(code.length - 1)
                } else if (firstNum.text.isNotEmpty()) {
                    firstNum.text = ""
                    code.deleteCharAt(code.length - 1)
                }

            }

            keyboard.btConfirm.setOnClickListener {
                if (code.length == 4) {
                    viewModel.newPasswordScreen()
                }
            }

            verifyBtn.setOnClickListener {
                if (code.length == 4) {
                    viewModel.newPasswordScreen()
                }
            }

            backBtn.setOnClickListener {
                viewModel.back()
            }

        }
    }

    private val openNewPasswordScreenObserver = Observer<Unit> {
        findNavController().navigate(R.id.action_forgotVerify_to_forgotNewPasswordScreen)
    }

    private val backButtonObserver = Observer<Unit> {
        findNavController().navigateUp()
    }

    private fun setNumber(
        str: String,
        textView1: TextView,
        textView2: TextView,
        textView3: TextView,
        textView4: TextView
    ) {
        if (textView1.text.isEmpty()) {
            textView1.text = str
            code.append(str)
        } else if (textView2.text.isEmpty()) {
            textView2.text = str
            code.append(str)
        } else if (textView3.text.isEmpty()) {
            textView3.text = str
            code.append(str)
        } else if (textView4.text.isEmpty()) {
            textView4.text = str
            code.append(str)
        }
    }
}