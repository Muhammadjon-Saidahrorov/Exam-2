package uz.gita.examfinal2.presentation.viewmodel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.gita.examfinal2.domain.usecase.ForgotNewPasswordUseCase
import uz.gita.examfinal2.presentation.viewmodel.ForgotNewPasswordViewModel
import javax.inject.Inject

@HiltViewModel
class ForgotNewPasswordViewModelImpl @Inject constructor(private val forgotNewPasswordUseCase: ForgotNewPasswordUseCase) :
    ForgotNewPasswordViewModel, ViewModel() {
    override val openHomeScreen = MutableLiveData<Unit>()
    override val eyeButton1 = MutableLiveData<Unit>()
    override val eyeButton2 = MutableLiveData<Unit>()
    override val backButton = MutableLiveData<Unit>()

    override fun homeScreen() {
        openHomeScreen.value = Unit
    }

    override fun eye1() {
        eyeButton1.value = Unit
    }

    override fun eye2() {
        eyeButton2.value = Unit
    }

    override fun back() {
        backButton.value = Unit
    }
}