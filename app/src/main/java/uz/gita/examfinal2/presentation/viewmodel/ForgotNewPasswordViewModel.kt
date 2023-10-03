package uz.gita.examfinal2.presentation.viewmodel

import androidx.lifecycle.LiveData

interface ForgotNewPasswordViewModel {
    val openHomeScreen : LiveData<Unit>
    val eyeButton1: LiveData<Unit>
    val eyeButton2: LiveData<Unit>
    val backButton : LiveData<Unit>

    fun homeScreen()
    fun eye1()
    fun eye2()
    fun back()
}