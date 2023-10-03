package uz.gita.examfinal2.presentation.viewmodel

import androidx.lifecycle.LiveData

interface SignUpViewModel {

    val openProfileScreen: LiveData<Unit>
    val errorData: LiveData<String>
    val correctData: LiveData<String>
    val eyeButton: LiveData<Unit>
    val openSignIn: LiveData<Unit>
    val backButton: LiveData<Unit>

    fun signUpUser(email: String, password: String)
    fun eye()
    fun signIn()
    fun back()

}