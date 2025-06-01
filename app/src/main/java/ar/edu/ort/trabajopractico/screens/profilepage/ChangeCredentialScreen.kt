package ar.edu.ort.trabajopractico.screens.profilepage
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import ar.edu.ort.trabajopractico.components.PrimaryButton
import ar.edu.ort.trabajopractico.ui.theme.components.AppTextField
import ar.edu.ort.trabajopractico.ui.theme.AppTypography
import ar.edu.ort.trabajopractico.viewmodels.profilepage.CredentialViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ChangeCredentialScreen(
    title: String,
    fields: List<String>,
    buttonText: String,
    viewModel: CredentialViewModel = viewModel()
) {
    val isSubmitted = viewModel.isSubmitted
    val inputs = remember { fields.map { mutableStateOf("") } }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        fields.forEachIndexed { index, label ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) {
                Text(
                    text = label,
                    style = AppTypography.settingsItem,
                    modifier = Modifier.padding(bottom = 6.dp)
                )
                AppTextField(
                    value = inputs[index].value,
                    onValueChange = { inputs[index].value = it },
                    placeholder = "Abdul",
                    isPassword = label.contains("Password", ignoreCase = true),
                    isError = isSubmitted && inputs[index].value.isBlank(),
                    errorMessage = "Required field",
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        PrimaryButton(
            text = buttonText,
            onClick = {
                viewModel.submit()
                val allFilled = inputs.all { it.value.isNotBlank() }

            },
            modifier = Modifier.fillMaxWidth()
        )
    }
}
