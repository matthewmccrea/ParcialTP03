import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ForgotPasswordViewModel : ViewModel() {
    var email = mutableStateOf("")
        private set

    val isEmailValid: Boolean
        get() = email.value.isNotBlank() && "@" in email.value
}