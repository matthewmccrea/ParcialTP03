package ar.edu.ort.trabajopractico.components
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ar.edu.ort.trabajopractico.MainNavActions
import ar.edu.ort.trabajopractico.R

@Composable
fun AppDrawer(
    drawerState: DrawerState,
    navActions: MainNavActions,
    content: @Composable () -> Unit
) {
    ModalNavigationDrawer(

        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier
                .widthIn(max = 200.dp),
                drawerShape = RoundedCornerShape(topEnd = 24.dp, bottomEnd = 24.dp),
                drawerContainerColor = MaterialTheme.colorScheme.surface,
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        text = "Menú",
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    NavigationDrawerItem(
                        label = { Text("Settings", fontSize = 16.sp) },
                        selected = false,
                        onClick = navActions.navigateToSettings,
                        icon = {
                            Icon(
                                painter = painterResource(id = R.drawable.settings),
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                    )


                }
            }
        },
        content = content
    )
}