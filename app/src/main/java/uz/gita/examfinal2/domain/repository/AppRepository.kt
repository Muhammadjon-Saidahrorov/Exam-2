package uz.gita.examfinal2.domain.repository

interface AppRepository {

    fun saveFirstLogic(b: Boolean)
    fun getFirstLogic(): Boolean

    fun saveFullName(str: String)
    fun getFullName(): String

    fun saveNickName(str: String)
    fun getNickName(): String

    fun saveDateOfBirth(str: String)
    fun getDateOfBirth(): String

    fun saveEmail(str: String)
    fun getEmail(): String

    fun saveGender(str: String)
    fun getGender(): String

    fun savePin(str: String)
    fun getPin(): String

}