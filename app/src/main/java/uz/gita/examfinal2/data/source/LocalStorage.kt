package uz.gita.examfinal2.data.source

import android.content.Context
import android.content.SharedPreferences

class LocalStorage(context: Context) {

    private var preferences: SharedPreferences? = null
    private var editor: SharedPreferences.Editor? = null

    init {
        preferences = context.getSharedPreferences("EXAM", Context.MODE_PRIVATE)
        editor = preferences?.edit()
    }


    companion object {
        private var localStorge: LocalStorage? = null

        fun getInstance(): LocalStorage {
            return localStorge!!
        }

        fun init(context: Context) {
            if (localStorge == null) localStorge = LocalStorage(context)
        }

    }

    fun saveFirstLogic(str: Boolean) {
        editor?.putBoolean("LOGIC", str)?.apply()
    }

    fun getFirstLogic(): Boolean {
        return preferences?.getBoolean("LOGIC", false)!!
    }

    fun saveFullName(str: String) {
        editor?.putString("FullName", str)?.apply()
    }

    fun getFullName(): String {
        return preferences?.getString("FullName", "Full Name")!!
    }

    fun saveNickName(str: String) {
        editor?.putString("NickName", str)?.apply()
    }

    fun getNickName(): String {
        return preferences?.getString("NickName", "")!!
    }

    fun saveDateOfBirth(str: String) {
        editor?.putString("DateOfBirth", str)?.apply()
    }

    fun getDateOfBirth(): String {
        return preferences?.getString("DateOfBirth", "")!!
    }

    fun saveEmail(str: String) {
        editor?.putString("Email", str)?.apply()
    }

    fun getEmail(): String {
        return preferences?.getString("Email", "")!!
    }

    fun saveGender(str: String) {
        editor?.putString("Gender", str)?.apply()
    }

    fun getGender(): String {
        return preferences?.getString("Gender", "")!!
    }

    fun savePin(str: String) {
        editor?.putString("Pin", str)?.apply()
    }

    fun getPin(): String {
        return preferences?.getString("Pin", "")!!
    }

}