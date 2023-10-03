package uz.gita.examfinal2.app

import android.app.Application
import com.google.firebase.FirebaseApp
import dagger.hilt.android.HiltAndroidApp
import uz.gita.examfinal2.data.source.LocalStorage

@HiltAndroidApp
class App: Application() {
    override fun onCreate() {
        super.onCreate()

        LocalStorage.init(this)
    }
}