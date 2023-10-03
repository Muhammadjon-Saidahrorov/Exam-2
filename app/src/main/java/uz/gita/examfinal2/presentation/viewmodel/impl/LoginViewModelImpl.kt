package uz.gita.examfinal2.presentation.viewmodel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.gita.examfinal2.domain.usecase.LoginUseCase
import uz.gita.examfinal2.presentation.viewmodel.LoginViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModelImpl @Inject constructor(private val loginUseCase: LoginUseCase): LoginViewModel, ViewModel() {
    override val openSignIn = MutableLiveData<Unit>()
    override val openSignUp = MutableLiveData<Unit>()
    override val backButton = MutableLiveData<Unit>()

    override fun signIn() {
        openSignIn.value = Unit
    }

    override fun signUp() {
        openSignUp.value = Unit
    }

    override fun back() {
        backButton.value = Unit
    }


}