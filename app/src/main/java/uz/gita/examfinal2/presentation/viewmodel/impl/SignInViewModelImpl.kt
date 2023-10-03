package uz.gita.examfinal2.presentation.viewmodel.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.examfinal2.domain.usecase.SignInUseCase
import uz.gita.examfinal2.presentation.viewmodel.SignInViewModel
import javax.inject.Inject

@HiltViewModel
class SignInViewModelImpl @Inject constructor(private val signInUseCase: SignInUseCase) :
    SignInViewModel, ViewModel() {

    override val openHomeScreen = MutableLiveData<Unit>()
    override val errorData = MutableLiveData<String>()
    override val correctData = MutableLiveData<String>()
    override val eyeButton = MutableLiveData<Unit>()
    override val openForgot = MutableLiveData<Unit>()
    override val openSignUp = MutableLiveData<Unit>()
    override val backButton = MutableLiveData<Unit>()

    override fun signInUser(email: String, password: String) {

        signInUseCase.signInUser(email, password).onEach { result ->

            result.onSuccess {
                correctData.value = "Currect"
                openHomeScreen.value = Unit
            }

            result.onFailure {
                errorData.value = it.message.toString()
            }

        }.launchIn(viewModelScope)
    }

    override fun eye() {
        eyeButton.value = Unit
    }

    override fun forgot() {
        openForgot.value = Unit
    }

    override fun signUp() {
        openSignUp.value = Unit
    }

    override fun back() {
        backButton.value = Unit
    }

}
