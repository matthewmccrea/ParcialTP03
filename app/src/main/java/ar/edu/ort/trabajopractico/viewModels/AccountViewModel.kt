import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel


class AccountViewModel : ViewModel() {
    var name = mutableStateOf("Abdul")
        private set

    var username = mutableStateOf("Abduldul")
        private set

    var email = mutableStateOf("abdul@example.com")
        private set

}
