package ar.edu.ort.trabajopractico.viewmodels.paymentmethod

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel


class PaymentViewModel : ViewModel() {
    var selectedOption by mutableStateOf("")
        private set

    var isSubmitted by mutableStateOf(false)
        private set

    var cardNumber by mutableStateOf("")
    var cardName by mutableStateOf("")
    var expiry by mutableStateOf("")
    var cvv by mutableStateOf("")

    fun selectOption(option: String) {
        selectedOption = option
    }

    fun submit() {
        isSubmitted = true
    }

    fun reset() {
        isSubmitted = false
        selectedOption = ""
        cardNumber = ""
        cardName = ""
        expiry = ""
        cvv = ""
    }
}
