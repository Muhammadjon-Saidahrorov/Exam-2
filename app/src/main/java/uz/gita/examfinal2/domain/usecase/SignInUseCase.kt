package uz.gita.examfinal2.domain.usecase

import kotlinx.coroutines.flow.Flow

interface SignInUseCase {
    fun signInUser(email: String, password: String): Flow<Result<Unit>>
}