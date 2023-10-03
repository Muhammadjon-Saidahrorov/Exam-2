package uz.gita.examfinal2.domain.usecase.impl

import uz.gita.examfinal2.domain.repository.AuthRepository
import uz.gita.examfinal2.domain.usecase.ForgotVerifyUsecase
import javax.inject.Inject

class ForgotVerifyUsecaseImpl @Inject constructor(private val authRepository: AuthRepository) :
    ForgotVerifyUsecase {
}