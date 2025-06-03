package ar.edu.ort.trabajopractico.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ar.edu.ort.trabajopractico.R
import ar.edu.ort.trabajopractico.data.CartProduct
import ar.edu.ort.trabajopractico.data.Product

@Composable
fun CartItemCard(
    cartProduct: CartProduct,
    showDelete: Boolean,
    modifier: Modifier,
    onRemoveClick: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .shadow(4.dp, shape = RoundedCornerShape(16.dp))
            .background(Color.White, shape = RoundedCornerShape(16.dp))
            .padding(12.dp)
    ) {
        Image(
            painter = painterResource(cartProduct.imageRes),
            contentDescription = cartProduct.title,
            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color(0xFFF8F8F8)),
            contentScale = ContentScale.Fit
        )
        Spacer(modifier = Modifier.width(12.dp))

        Column(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
        ) {
            Text(text = cartProduct.title, fontWeight = FontWeight.Bold)
            Text(text = "Quantity: ${cartProduct.quantity}", color = Color.Gray)
            Text(
                text = "$${cartProduct.price}",
                color = Color(0xFF7140FD),
                fontWeight = FontWeight.Bold
            )
        }

        if (showDelete) {
            Box(
                modifier = Modifier
                    .width(46.dp)
                    .height(112.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color(0xFFF8F8F8)),
                contentAlignment = Alignment.Center
            ) {
                IconButton(onClick = onRemoveClick) {
                    Icon(
                        painter = painterResource(R.drawable.trash),
                        contentDescription = "Remove",
                        tint = Color.Red,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
    }
}


