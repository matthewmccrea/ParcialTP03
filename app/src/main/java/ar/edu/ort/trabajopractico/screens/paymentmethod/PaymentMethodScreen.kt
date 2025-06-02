package ar.edu.ort.trabajopractico.screens.paymentmethodscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ar.edu.ort.trabajopractico.components.PrimaryButton
import ar.edu.ort.trabajopractico.components.paymentmethod.SelectablePaymentOption
import ar.edu.ort.trabajopractico.components.AppTextField
import ar.edu.ort.trabajopractico.viewmodels.paymentmethod.PaymentViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import ar.edu.ort.trabajopractico.components.paymentmethod.CardDetailsForm
import ar.edu.ort.trabajopractico.components.paymentmethod.PaymentMethodSelector
import ar.edu.ort.trabajopractico.ui.theme.AppTypography

@Composable
fun PaymentMethodScreen(viewModel: PaymentViewModel = viewModel()) {
    val isSubmitted = viewModel.isSubmitted

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (!isSubmitted) {
            PaymentMethodSelector(viewModel)
        } else {
            CardDetailsForm(viewModel)
        }
    }
}

