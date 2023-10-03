package uz.gita.examfinal2.presentation.ui.createprofilscreen.createprofilepin

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
import kotlinx.coroutines.*
import uz.gita.examfinal2.R
import uz.gita.examfinal2.databinding.ScreenCreateProfilePinBinding
import uz.gita.examfinal2.presentation.viewmodel.CreateProfilePinViewModel
import uz.gita.examfinal2.presentation.viewmodel.impl.CreateProfilePinViewModelImpl
import uz.gita.examfinal2.utils.myLog

@AndroidEntryPoint
class CreateProfilePinScreen : Fragment(R.layout.screen_create_profile_pin) {
    private val binding by viewBinding(ScreenCreateProfilePinBinding::bind)
    private val viewModel: CreateProfilePinViewModel by viewModels<CreateProfilePinViewModelImpl>()
    private var code = StringBuilder("")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.openHomeScreen.observe(this, openHomeScreenObserver)
        viewModel.backBtn.observe(this, backBtnObserver)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {

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
                        viewModel.savePin(code.toString())
                    }

                }
            }

            btnContinue.setOnClickListener {
                if (code.length == 4) {

                    val viewDialog: View = LayoutInflater.from(requireContext())
                        .inflate(R.layout.dialog_congrats, null)
                    val dialog = androidx.appcompat.app.AlertDialog.Builder(requireContext())
                        .setCancelable(false)
                        .setView(viewDialog)
                        .create()
                    dialog.window?.setBackgroundDrawable(null)
                    dialog.show()

                    lifecycleScope.launch {
                        delay(1500)

                        viewDialog.findViewById<ImageView>(R.id.imgChecked).visibility = View.VISIBLE
                        viewDialog.findViewById<ProgressBar>(R.id.progressDialog).visibility = View.GONE
                        delay(1000)

                        dialog.dismiss()
                        viewModel.savePin(code.toString())
                    }

                }
            }

            btnBack.setOnClickListener {
                viewModel.backFun()
            }

        }
    }

    private val openHomeScreenObserver = Observer<Unit> {
        findNavController().navigate(R.id.action_profilePinScreen_to_homeScreen2)
    }

    private val backBtnObserver = Observer<Unit> {
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