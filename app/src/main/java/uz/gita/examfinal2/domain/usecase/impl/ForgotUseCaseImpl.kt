package uz.gita.examfinal2.domain.usecase.impl

import uz.gita.examfinal2.domain.repository.AuthRepository
import uz.gita.examfinal2.domain.usecase.ForgotUseCase
import javax.inject.Inject

class ForgotUseCaseImpl @Inject constructor(private val authRepository: AuthRepository): ForgotUseCase {
}