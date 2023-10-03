package uz.gita.examfinal2.presentation.viewmodel

import androidx.lifecycle.LiveData

interface ForgotVerifyViewModel {
    val openNewPasswordScreen : LiveData<Unit>
    val backButton : LiveData<Unit>

    fun newPasswordScreen()
    fun back()
}