package uz.gita.examfinal2.domain.usecase

import kotlinx.coroutines.flow.Flow

interface SignUpUseCase {
    fun signUpUser(email: String, password: String): Flow<Result<Unit>>
}