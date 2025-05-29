package ar.edu.ort.trabajopractico.components.paymentmethod


import androidx.compose.foundation.layout.Column
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ar.edu.ort.trabajopractico.components.PrimaryButton
import ar.edu.ort.trabajopractico.ui.theme.AppTypography
import ar.edu.ort.trabajopractico.viewmodels.paymentmethod.PaymentViewModel

@Composable
fun PaymentMethodSelector(viewModel: PaymentViewModel) {
    val selectedOption = viewModel.selectedOption

    Column(
        modifier = Modifier
            .fillMaxSize()

    ) {
        Text(
            text = "Choose your Payment Method",
            style = AppTypography.sectionTitle,
            modifier = Modifier.align(Alignment.Start)
        )

        Spacer(modifier = Modifier.height(10.dp))

        SelectablePaymentOption(
            title = "Paypal",
            selected = selectedOption == "Paypal",
            onSelect = { viewModel.selectOption("Paypal") }
        )

        Spacer(modifier = Modifier.height(12.dp))

        SelectablePaymentOption(
            title = "Credit Card",
            selected = selectedOption == "Credit Card",
            onSelect = { viewModel.selectOption("Credit Card") }
        )

        Spacer(modifier = Modifier.weight(1f)) // <-- Empuja el botón hacia abajo

        PrimaryButton(
            text = "Checkout",
            onClick = { viewModel.submit() },
            modifier = Modifier.fillMaxWidth()
        )
    }
}
