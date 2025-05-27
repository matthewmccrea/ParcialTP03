package ar.edu.ort.trabajopractico
import android.app.Application
import ar.edu.ort.trabajopractico.core.Config
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TrabajoPracticoApplication: Application(){
    override fun onCreate(){
        super.onCreate()
        Config.apiKey = resources.getString(R.string.api_key)
        Config.baseUrl = resources.getString(R.string.base_url)
    }
}
