import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel


class ResetPasswordViewModel : ViewModel() {
    var newPassword = mutableStateOf("")
        private set

    var confirmPassword = mutableStateOf("")
        private set

    val isPasswordValid: Boolean
        get() = newPassword.value.length >= 6

    val doPasswordsMatch: Boolean
        get() = newPassword.value == confirmPassword.value

    val isFormValid: Boolean
        get() = isPasswordValid && doPasswordsMatch
}