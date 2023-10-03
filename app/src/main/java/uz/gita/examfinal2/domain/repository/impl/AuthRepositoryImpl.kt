package uz.gita.examfinal2.domain.repository.impl

import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import uz.gita.examfinal2.data.source.LocalStorage
import uz.gita.examfinal2.domain.repository.AuthRepository
import uz.gita.examfinal2.utils.myLog
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor() : AuthRepository {
    private val auth = Firebase.auth
    private val localStorage = LocalStorage.getInstance()

    override fun signInUser(email: String, password: String): Flow<Result<Unit>> {
        return callbackFlow {
            auth.signInWithEmailAndPassword(
                email, password
            ).addOnSuccessListener {
                localStorage.saveFirstLogic(true)
                trySend(Result.success(Unit))
            }.addOnFailureListener {
                trySend(Result.failure(it))
            }
            awaitClose()
        }
    }

    override fun signUpUser(email: String, password: String): Flow<Result<Unit>> {
        return callbackFlow {
            auth.createUserWithEmailAndPassword(
                email, password
            ).addOnSuccessListener {
                localStorage.saveFirstLogic(true)
                trySend(Result.success(Unit))
            }.addOnFailureListener {
                trySend(Result.failure(it))
            }
            awaitClose()
        }
    }

}