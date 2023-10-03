package uz.gita.examfinal2.domain.usecase.impl

import uz.gita.examfinal2.domain.repository.AuthRepository
import uz.gita.examfinal2.domain.usecase.ForgotNewPasswordUseCase
import javax.inject.Inject

class ForgotNewPasswordUseCaseImpl @Inject constructor(private val authRepository: AuthRepository): ForgotNewPasswordUseCase {
}