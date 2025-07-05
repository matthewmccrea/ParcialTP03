package ar.edu.ort.trabajopractico.screens.profilepage
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import ar.edu.ort.trabajopractico.components.PrimaryButton
import ar.edu.ort.trabajopractico.components.AppTextField
import ar.edu.ort.trabajopractico.ui.theme.AppTypography
import ar.edu.ort.trabajopractico.viewmodels.profilepage.CredentialViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun ChangeCredentialScreen(
    title: String,
    fields: List<String>,
    buttonText: String,
    viewModel: CredentialViewModel = viewModel(),
    navController: NavController
) {
    LaunchedEffect(Unit) {
        viewModel.configureScreen(
            screenTitle = title,
            buttonLabel = buttonText,
            fieldPlaceholders = fields
        )
    }

    val isSubmitted = viewModel.isSubmitted.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(24.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = viewModel.title.value,
                fontWeight = FontWeight.Bold
            )

            IconButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .size(48.dp)
                    .background(Color(0xFFF8F8F8), shape = CircleShape)
            ) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
            }
        }

        viewModel.placeholders.forEachIndexed { index, placeholder ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) {
                Text(
                    text = placeholder,
                    style = AppTypography.settingsItem,
                    modifier = Modifier.padding(bottom = 6.dp)
                )
                AppTextField(
                    value = viewModel.fieldValues[index],
                    onValueChange = { viewModel.updateField(index, it) },
                    placeholder = placeholder,
                    isPassword = placeholder.contains("Password", ignoreCase = true),
                    isError = isSubmitted && viewModel.fieldValues[index].isBlank(),
                    errorMessage = "Required field",
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        PrimaryButton(
            text = viewModel.buttonText.value,
            onClick = {
                viewModel.submit()
                val allFilled = viewModel.fieldValues.all { it.isNotBlank() }
                if (allFilled) {
                }
            },
            modifier = Modifier.fillMaxWidth()
        )
    }
}
