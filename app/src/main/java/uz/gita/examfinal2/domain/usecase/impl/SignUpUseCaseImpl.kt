package uz.gita.examfinal2.domain.usecase.impl

import kotlinx.coroutines.flow.Flow
import uz.gita.examfinal2.domain.repository.AuthRepository
import uz.gita.examfinal2.domain.usecase.SignUpUseCase
import javax.inject.Inject

class SignUpUseCaseImpl @Inject constructor(private val authRepository: AuthRepository) :
    SignUpUseCase {
    override fun signUpUser(email: String, password: String): Flow<Result<Unit>> {
        return authRepository.signUpUser(email, password)
    }

}