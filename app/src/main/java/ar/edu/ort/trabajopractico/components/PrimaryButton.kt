package ar.edu.ort.trabajopractico.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ar.edu.ort.trabajopractico.ui.theme.buttonLarge


@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .height(60.dp),
        shape = RoundedCornerShape(30.5.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF7140FD)
        )
    ) {
        Text(
            text = text,
            color = Color.White,
            style = buttonLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),

        )
    }
}
