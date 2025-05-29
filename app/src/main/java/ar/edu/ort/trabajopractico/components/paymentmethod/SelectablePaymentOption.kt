package ar.edu.ort.trabajopractico.components.paymentmethod

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ar.edu.ort.trabajopractico.ui.theme.fontFamilyPoppins

@Composable
fun SelectablePaymentOption(
    title: String,
    selected: Boolean,
    onSelect: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
            .border(
                width = 1.dp,
                color = Color.Gray,
                shape = RoundedCornerShape(16.dp)
            )
            .clickable { onSelect() }
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodyLarge.copy(
                fontFamily = fontFamilyPoppins,
                color = if (selected) Color.Black else Color.Gray
            )
        )

        RadioButton(
            selected = selected,
            onClick = onSelect
        )
    }
}