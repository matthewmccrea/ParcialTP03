package ar.edu.ort.trabajopractico.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ar.edu.ort.trabajopractico.R

@Composable
fun Banner() {
    Spacer(modifier = Modifier.height(24.dp))
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(139.dp)
            .padding(horizontal = 24.dp)
    ) {

        Image(
            painter = painterResource(id = R.drawable.banner_background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(24.dp))
        )

        Column(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 24.dp)
                .width(160.dp)
        ) {
            Text(
                text = "Royal Canin\nAdult Pomeraniann",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Get an interesting promo here, without conditions",
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = Color.White,
                lineHeight = 15.6.sp // 130%
            )
        }

        Image(
            painter = painterResource(id = R.drawable.food_front),
            contentDescription = "Front Product",
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = (-25).dp, y = 0.dp)
                .height(177.dp)
                .width(177.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.food_back),
            contentDescription = "Back Product",
            modifier = Modifier
                .align(Alignment.CenterStart)
                .offset(x = 0.dp, y = 25.dp)
                .height(177.dp)
                .width(177.dp)
        )
    }
}