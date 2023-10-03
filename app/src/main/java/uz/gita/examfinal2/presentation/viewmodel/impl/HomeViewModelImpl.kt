package uz.gita.examfinal2.presentation.viewmodel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.gita.examfinal2.domain.usecase.HomeUseCase
import uz.gita.examfinal2.presentation.viewmodel.HomeViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModelImpl @Inject constructor(private val homeUseCase: HomeUseCase) :
    HomeViewModel, ViewModel() {
    override val fullName = MutableLiveData<String>()

    init {
        fullName.value = homeUseCase.getFullName()
    }
}

