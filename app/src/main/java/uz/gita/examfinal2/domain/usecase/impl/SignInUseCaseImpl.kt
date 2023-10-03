package uz.gita.examfinal2.domain.usecase.impl

import kotlinx.coroutines.flow.Flow
import uz.gita.examfinal2.domain.repository.AuthRepository
import uz.gita.examfinal2.domain.usecase.SignInUseCase
import javax.inject.Inject

class SignInUseCaseImpl @Inject constructor(private val authRepository: AuthRepository): SignInUseCase {
    override fun signInUser(email: String, password: String): Flow<Result<Unit>> {
        return authRepository.signInUser(email, password)
    }
}