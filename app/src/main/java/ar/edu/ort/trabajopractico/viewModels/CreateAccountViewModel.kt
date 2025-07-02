import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CreateAccountViewModel : ViewModel() {

    var fullName = mutableStateOf("")
    var email = mutableStateOf("")
    var password = mutableStateOf("")
    var acceptedTerms = mutableStateOf(false)

    var fullNameError = mutableStateOf(false)
    var emailError = mutableStateOf(false)
    var passwordError = mutableStateOf(false)

    val allFieldsValid: Boolean
        get() = fullName.value.isNotBlank() &&
                email.value.isNotBlank() &&
                password.value.isNotBlank() &&
                acceptedTerms.value
}
