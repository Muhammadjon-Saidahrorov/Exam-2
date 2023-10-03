package uz.gita.examfinal2.domain.usecase.impl

import uz.gita.examfinal2.domain.repository.AppRepository
import uz.gita.examfinal2.domain.usecase.CreateProfilePinUseCase
import javax.inject.Inject

class CreateProfilePinUseCaseImpl @Inject constructor(private val appRepository: AppRepository) :
    CreateProfilePinUseCase {
    override fun savePin(str: String) {
        appRepository.savePin(str)
    }
}