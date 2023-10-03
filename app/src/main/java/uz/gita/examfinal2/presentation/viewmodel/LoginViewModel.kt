package uz.gita.examfinal2.presentation.viewmodel

import androidx.lifecycle.LiveData

interface LoginViewModel {
    val openSignIn: LiveData<Unit>
    val openSignUp: LiveData<Unit>
    val backButton: LiveData<Unit>


    fun signIn()
    fun signUp()
    fun back()

}