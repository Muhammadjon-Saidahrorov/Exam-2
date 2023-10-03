package uz.gita.examfinal2.domain.usecase.impl

import uz.gita.examfinal2.domain.repository.AppRepository
import uz.gita.examfinal2.domain.usecase.HomeUseCase
import javax.inject.Inject

class HomeUseCaseImpl @Inject constructor(private val appRepository: AppRepository): HomeUseCase {
    override fun getFullName(): String {
        return appRepository.getFullName()
    }
}