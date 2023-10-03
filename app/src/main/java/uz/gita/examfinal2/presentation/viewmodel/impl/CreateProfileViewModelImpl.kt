package uz.gita.examfinal2.presentation.viewmodel.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.gita.examfinal2.domain.usecase.CreateProfileUseCase
import uz.gita.examfinal2.domain.usecase.LoginUseCase
import uz.gita.examfinal2.presentation.viewmodel.CreateProfileViewModel
import uz.gita.examfinal2.presentation.viewmodel.LoginViewModel
import javax.inject.Inject

@HiltViewModel
class CreateProfileViewModelImpl @Inject constructor(private val createProfileUseCase: CreateProfileUseCase) :
    CreateProfileViewModel, ViewModel() {
    override val openPinScreen = MutableLiveData<Unit>()
    override val backBtn = MutableLiveData<Unit>()


    override fun backFun() {
        backBtn.value = Unit
    }

    override fun saveDates(
        fullName: String,
        nickName: String,
        dateOfBirth: String,
        email: String,
        gender: String
    ) {
        createProfileUseCase.saveFullName(fullName)
        createProfileUseCase.saveNickName(nickName)
        createProfileUseCase.saveDateOfBirth(dateOfBirth)
        createProfileUseCase.saveEmail(email)
        createProfileUseCase.saveGender(gender)

        openPinScreen.value = Unit
    }

}