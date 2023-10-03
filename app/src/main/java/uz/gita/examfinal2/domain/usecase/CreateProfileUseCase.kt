package uz.gita.examfinal2.domain.usecase

interface CreateProfileUseCase {
    fun saveFullName(str: String)
    fun saveNickName(str: String)
    fun saveDateOfBirth(str: String)
    fun saveEmail(str: String)
    fun saveGender(str: String)
}