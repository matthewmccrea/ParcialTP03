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
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "Add New Payment",
            style = AppTypography.sectionTitle,
            modifier = Modifier.align(Alignment.Start)
        )

        Spacer(modifier = Modifier.height(16.dp))

        val fieldValues = listOf(
            viewModel.cardNumber,
            viewModel.cardName,
            viewModel.expiry,
            viewModel.cvv
        )

        val fieldSetters = listOf<
                    (String) -> Unit>(
            { viewModel.cardNumber = it },
            { viewModel.cardName = it },
            { viewModel.expiry = it },
            { viewModel.cvv = it }
        )

        viewModel.cardPlaceholders.forEachIndexed { index, placeholder ->
            AppTextField(
                value = fieldValues[index],
                onValueChange = fieldSetters[index],
                placeholder = placeholder,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp)
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        PrimaryButton(
            text = "Save",
            onClick = { viewModel.submit() },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

