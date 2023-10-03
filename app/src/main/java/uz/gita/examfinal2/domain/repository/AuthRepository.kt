package uz.gita.examfinal2.domain.repository

import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    fun signInUser(email: String, password: String): Flow<Result<Unit>>
    fun signUpUser(email: String, password: String): Flow<Result<Unit>>

}