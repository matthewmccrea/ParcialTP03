package ar.edu.ort.trabajopractico.components
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
    BottomAppBar(
        containerColor = MaterialTheme.colorScheme.background
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(R.drawable.icon_home),
                    contentDescription = stringResource(R.string.bottom_title_home)
                )
            },
            label = {
                Text(stringResource(R.string.bottom_title_home), fontSize = 12.sp)
            },
            selected = viewModel.getRoute() == RootScreen.Home,
            onClick = navActions.navigateToHome
        )
        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(R.drawable.icon_user),
                    contentDescription = stringResource(R.string.bottom_title_profile)
                )
            },
            label = {
                Text(stringResource(R.string.bottom_title_profile), fontSize = 12.sp)
            },
            selected = viewModel.getRoute() == RootScreen.Profile,
            onClick = navActions.navigateToProfile
        )
    }
}
