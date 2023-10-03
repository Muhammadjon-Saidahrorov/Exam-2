package uz.gita.examfinal2.domain.repository.impl

import uz.gita.examfinal2.data.source.LocalStorage
import uz.gita.examfinal2.domain.repository.AppRepository
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor() : AppRepository {
    private val localStorage = LocalStorage.getInstance()

    override fun saveFirstLogic(b: Boolean) {
        localStorage.saveFirstLogic(b)
    }

    override fun getFirstLogic(): Boolean {
        return localStorage.getFirstLogic()
    }

    override fun saveFullName(str: String) {
        localStorage.saveFullName(str)
    }

    override fun getFullName(): String {
        return localStorage.getFullName()
    }

    override fun saveNickName(str: String) {
        localStorage.saveNickName(str)
    }

    override fun getNickName(): String {
        return localStorage.getNickName()
    }


    override fun saveDateOfBirth(str: String) {
        localStorage.saveDateOfBirth(str)
    }

    override fun getDateOfBirth(): String {
        return localStorage.getDateOfBirth()
    }

    override fun saveEmail(str: String) {
        localStorage.saveEmail(str)
    }

    override fun getEmail(): String {
        return localStorage.getEmail()
    }

    override fun saveGender(str: String) {
        localStorage.saveGender(str)
    }

    override fun getGender(): String {
        return localStorage.getGender()
    }

    override fun savePin(str: String) {
        localStorage.savePin(str)
    }

    override fun getPin(): String {
        return localStorage.getPin()
    }

}