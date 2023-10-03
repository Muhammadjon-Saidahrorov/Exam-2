package uz.gita.examfinal2.domain.usecase.impl

import uz.gita.examfinal2.domain.repository.AppRepository
import uz.gita.examfinal2.domain.usecase.LoginUseCase
import javax.inject.Inject

class LoginUseCaseImpl @Inject constructor(private val appRepository: AppRepository): LoginUseCase {
}