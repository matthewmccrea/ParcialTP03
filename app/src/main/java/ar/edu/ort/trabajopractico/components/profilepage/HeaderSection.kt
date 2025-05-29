package ar.edu.ort.trabajopractico.components.profilepage
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ar.edu.ort.trabajopractico.R
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.graphicsLayer
import ar.edu.ort.trabajopractico.ui.theme.AppTypography
import ar.edu.ort.trabajopractico.ui.theme.fontFamilyPoppins


@Composable
fun HeaderSection(
    isSeller: Boolean,
    username: String,
    onToggleMode: () -> Unit
) {
    val bannerRes = R.drawable.banner_seller

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
                .background(color = Color(0xFFF2F2F2), shape = CircleShape),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {}

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Image(
                painter = painterResource(id = R.drawable.banner_seller),
                contentDescription = "Banner",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .clip(RoundedCornerShape(20.dp))
                    ,
                contentScale = ContentScale.Crop
            )

            // Overlay naranja si está en modo Seller
            if (isSeller) {
                Box(
                    modifier = Modifier
                        .matchParentSize()
                        .clip(RoundedCornerShape(20.dp))
                        .background(Color(0xFFF26C0D).copy(alpha = 0.5f))
                )
            }

            Image(
                painter = painterResource(
                    id = if (isSeller) R.drawable.p else R.drawable.profile_picture
                ),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(100.dp)
                    .offset(y = 50.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.height(68.dp))

        Text(
            text = username,
            style = AppTypography.profileName

        )

        Spacer(modifier = Modifier.height(30.dp))
    }
}
