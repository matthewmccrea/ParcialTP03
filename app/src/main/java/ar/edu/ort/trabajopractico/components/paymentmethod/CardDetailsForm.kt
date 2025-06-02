package ar.edu.ort.trabajopractico.components.paymentmethod
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ar.edu.ort.trabajopractico.components.PrimaryButton
import ar.edu.ort.trabajopractico.components.AppTextField
import ar.edu.ort.trabajopractico.viewmodels.paymentmethod.PaymentViewModel
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import ar.edu.ort.trabajopractico.ui.theme.AppTypography

@Composable
fun CardDetailsForm(viewModel: PaymentViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()

    ) {
        Text(
            text = "Add New Payment",
            style = AppTypography.sectionTitle,
            modifier = Modifier.align(Alignment.Start)
        )

        Spacer(modifier = Modifier.height(16.dp))

        AppTextField(
            value = viewModel.cardNumber,
            onValueChange = { viewModel.cardNumber = it },
            placeholder = "Card Number",
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp)
        )

        AppTextField(
            value = viewModel.cardName,
            onValueChange = { viewModel.cardName = it },
            placeholder = "Card Name",
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp)
        )

        AppTextField(
            value = viewModel.expiry,
            onValueChange = { viewModel.expiry = it },
            placeholder = "Expired",
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp)
        )

        AppTextField(
            value = viewModel.cvv,
            onValueChange = { viewModel.cvv = it },
            placeholder = "CVV",
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp)
        )

        Spacer(modifier = Modifier.weight(1f))

        PrimaryButton(
            text = "Save",
            onClick = {  },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

