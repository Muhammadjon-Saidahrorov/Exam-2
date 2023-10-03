package uz.gita.examfinal2.domain.usecase.impl

import uz.gita.examfinal2.domain.repository.AppRepository
import uz.gita.examfinal2.domain.usecase.CreateProfileUseCase
import javax.inject.Inject

class CreateProfileUseCaseImpl @Inject constructor(private val appRepository: AppRepository) :
    CreateProfileUseCase {

    override fun saveFullName(str: String) {
        appRepository.saveFullName(str)
    }

    override fun saveNickName(str: String) {
        appRepository.saveNickName(str)
    }

    override fun saveDateOfBirth(str: String) {
        appRepository.saveDateOfBirth(str)
    }

    override fun saveEmail(str: String) {
        appRepository.saveEmail(str)
    }

    override fun saveGender(str: String) {
        appRepository.saveGender(str)
    }
}