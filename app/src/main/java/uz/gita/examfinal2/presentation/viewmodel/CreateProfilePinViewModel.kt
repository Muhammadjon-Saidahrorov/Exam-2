package uz.gita.examfinal2.presentation.viewmodel

import androidx.lifecycle.LiveData

interface CreateProfilePinViewModel {
    val openHomeScreen: LiveData<Unit>
    val backBtn: LiveData<Unit>

    fun backFun()
    fun savePin(str: String)
}