package ar.edu.ort.trabajopractico.components
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ar.edu.ort.trabajopractico.MainActivityViewModel
import ar.edu.ort.trabajopractico.MainNavActions
import ar.edu.ort.trabajopractico.navigation.RootScreen
import ar.edu.ort.trabajopractico.R


@Composable
fun BottomNavBar(
    navActions: MainNavActions,
    viewModel: MainActivityViewModel
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp),
        shape = RoundedCornerShape(topStart = 45.dp, topEnd = 45.dp),
        color = Color(0xFFF8F8F8),
        tonalElevation = 8.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = navActions.navigateToHome) {
                Icon(
                    painter = painterResource(R.drawable.icon_home),
                    contentDescription = null,
                    tint = if (viewModel.getRoute() == RootScreen.Home) Color(0xFF7140FD) else Color.Black
                )
            }

            IconButton(onClick = {  }) {
                Icon(
                    painter = painterResource(R.drawable.icon_time),
                    contentDescription = null,
                    tint = Color(0xFFB3B1B0)
                )
            }

            IconButton(onClick = navActions.navigateToCart) {
                Icon(
                    painter = painterResource(R.drawable.icon_bag),
                    contentDescription = null,
                    tint = Color(0xFFB3B1B0)
                )
            }

            IconButton(onClick = navActions.navigateToProfile) {
                Icon(
                    painter = painterResource(R.drawable.icon_user2),
                    contentDescription = null,
                    tint = Color(0xFFB3B1B0)
                )
            }
        }
    }
}
