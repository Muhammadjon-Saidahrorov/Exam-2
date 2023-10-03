package uz.gita.examfinal2.presentation.viewmodel.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.examfinal2.domain.usecase.SignUpUseCase
import uz.gita.examfinal2.presentation.viewmodel.SignUpViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModelImpl @Inject constructor(private val signUpUseCase: SignUpUseCase): SignUpViewModel, ViewModel() {

    override val openProfileScreen = MutableLiveData<Unit>()
    override val errorData = MutableLiveData<String>()
    override val correctData = MutableLiveData<String>()
    override val eyeButton = MutableLiveData<Unit>()
    override val openSignIn = MutableLiveData<Unit>()
    override val backButton = MutableLiveData<Unit>()


    override fun signUpUser(email: String, password: String) {

        signUpUseCase.signUpUser(email, password).onEach { result ->

            result.onSuccess {
                correctData.value = "Currect"
                openProfileScreen.value = Unit
            }

            result.onFailure {
                errorData.value = it.message.toString()
            }

        }.launchIn(viewModelScope)
    }

    override fun eye() {
        eyeButton.value = Unit
    }

    override fun signIn() {
        openSignIn.value = Unit
    }

    override fun back() {
        backButton.value = Unit
    }
}