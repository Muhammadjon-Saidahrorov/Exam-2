package uz.gita.examfinal2.presentation.viewmodel.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.gita.examfinal2.domain.usecase.ForgotUseCase
import uz.gita.examfinal2.domain.usecase.SignInUseCase
import uz.gita.examfinal2.presentation.viewmodel.ForgotViewModel
import uz.gita.examfinal2.presentation.viewmodel.SignInViewModel
import javax.inject.Inject

@HiltViewModel
class ForgotViewModelImpl @Inject constructor(private val forgotUseCase: ForgotUseCase) :
    ForgotViewModel, ViewModel() {
    override val openVerifyScreen = MutableLiveData<Unit>()
    override val backButton = MutableLiveData<Unit>()

    override fun verifyScreen() {
        openVerifyScreen.value = Unit
    }

    override fun back() {
        backButton.value = Unit
    }
}