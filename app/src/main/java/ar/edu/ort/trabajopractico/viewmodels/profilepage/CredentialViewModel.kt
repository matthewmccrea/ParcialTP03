package ar.edu.ort.trabajopractico.viewmodels.profilepage
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf

class CredentialViewModel : ViewModel() {

    var isSubmitted = mutableStateOf(false)
        private set

    var title = mutableStateOf("")
        private set

    var buttonText = mutableStateOf("")
        private set

    var placeholders = mutableStateListOf<String>()
        private set

    var fieldValues = mutableStateListOf<String>()
        private set

    fun configureScreen(
        screenTitle: String,
        buttonLabel: String,
        fieldPlaceholders: List<String>
    ) {
        title.value = screenTitle
        buttonText.value = buttonLabel
        placeholders.clear()
        placeholders.addAll(fieldPlaceholders)
        fieldValues.clear()
        fieldValues.addAll(List(fieldPlaceholders.size) { "" })
    }

    fun updateField(index: Int, value: String) {
        fieldValues[index] = value
    }

    fun submit() {
        isSubmitted.value = true
    }

    fun reset() {
        isSubmitted.value = false
        fieldValues.replaceAll { "" }
    }
}
