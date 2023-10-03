package uz.gita.examfinal2.presentation.viewmodel

import androidx.lifecycle.LiveData

interface ForgotViewModel {
    val openVerifyScreen : LiveData<Unit>
    val backButton : LiveData<Unit>

    fun verifyScreen()
    fun back()
}