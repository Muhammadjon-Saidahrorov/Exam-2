package uz.gita.examfinal2.presentation.viewmodel

import androidx.lifecycle.LiveData

interface SignInViewModel {

    val openHomeScreen: LiveData<Unit>
    val errorData: LiveData<String>
    val correctData: LiveData<String>
    val eyeButton: LiveData<Unit>
    val openForgot: LiveData<Unit>
    val openSignUp: LiveData<Unit>
    val backButton: LiveData<Unit>

    fun signInUser(email: String, password: String)
    fun eye()
    fun forgot()
    fun signUp()
    fun back()
}