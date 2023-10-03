package uz.gita.examfinal2.presentation.viewmodel.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.gita.examfinal2.domain.usecase.CreateProfilePinUseCase
import uz.gita.examfinal2.domain.usecase.CreateProfileUseCase
import uz.gita.examfinal2.presentation.viewmodel.CreateProfilePinViewModel
import uz.gita.examfinal2.presentation.viewmodel.CreateProfileViewModel
import javax.inject.Inject

@HiltViewModel
class CreateProfilePinViewModelImpl @Inject constructor(private val createProfilePinUseCase: CreateProfilePinUseCase) :
    CreateProfilePinViewModel, ViewModel() {

    override val openHomeScreen = MutableLiveData<Unit>()
    override val backBtn = MutableLiveData<Unit>()

    override fun backFun() {
        backBtn.value = Unit
    }

    override fun savePin(str: String) {
        createProfilePinUseCase.savePin(str)

        openHomeScreen.value = Unit
    }

}