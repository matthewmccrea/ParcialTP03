package ar.edu.ort.trabajopractico

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.MutableLiveData
import ar.edu.ort.trabajopractico.navigation.RootScreen

@HiltViewModel
class MainActivityViewModel @Inject constructor() : ViewModel() {

    private val _titleBar = MutableLiveData("Home")
    val titleBar: LiveData<String> = _titleBar

    private val _showTopBar = MutableLiveData(true)
    val showTopBar: LiveData<Boolean> = _showTopBar

    private val _showBottomBar = MutableLiveData(true)
    val showBottomBar: LiveData<Boolean> = _showBottomBar

    private val _currentRoute = MutableLiveData<RootScreen>(RootScreen.Home)
    val currentRoute: LiveData<RootScreen> = _currentRoute

    fun setTitleBar(title: String) {
        _titleBar.value = title
    }

    fun setShowTopBar(visible: Boolean) {
        _showTopBar.value = visible
    }

    fun setShowBottomBar(visible: Boolean) {
        _showBottomBar.value = visible
    }

    fun setRoute(route: RootScreen) {
        _currentRoute.value = route
    }

    fun getRoute(): RootScreen? = _currentRoute.value
}
