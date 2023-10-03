package uz.gita.examfinal2.presentation.viewmodel

import androidx.lifecycle.LiveData

interface CreateProfileViewModel {
    val openPinScreen: LiveData<Unit>
    val backBtn: LiveData<Unit>

    fun backFun()

    fun saveDates(
        fullName: String,
        nickName: String,
        dateOfBirth: String,
        email: String,
        gender: String
    )
}