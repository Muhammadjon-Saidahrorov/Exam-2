package uz.gita.examfinal2.presentation.viewmodel.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.gita.examfinal2.domain.usecase.ForgotVerifyUsecase
import uz.gita.examfinal2.domain.usecase.SignInUseCase
import uz.gita.examfinal2.presentation.viewmodel.ForgotVerifyViewModel
import uz.gita.examfinal2.presentation.viewmodel.SignInViewModel
import javax.inject.Inject

@HiltViewModel
class ForgotVerifyViewmodelImpl @Inject constructor(private val forgotVerifyUsecase: ForgotVerifyUsecase) :
    ForgotVerifyViewModel, ViewModel() {
    override val openNewPasswordScreen = MutableLiveData<Unit>()
    override val backButton = MutableLiveData<Unit>()

    override fun newPasswordScreen() {
        openNewPasswordScreen.value = Unit
    }

    override fun back() {
        backButton.value = Unit
    }
}