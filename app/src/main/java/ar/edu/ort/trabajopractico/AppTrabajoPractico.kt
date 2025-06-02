package ar.edu.ort.trabajopractico
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.material3.rememberDrawerState
import ar.edu.ort.trabajopractico.components.TopBar
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import ar.edu.ort.trabajopractico.ui.theme.TrabajoPracticoTheme
import ar.edu.ort.trabajopractico.components.BottomNavBar
//import ar.edu.ort.trabajopractico.components.AppDrawer
import kotlinx.coroutines.launch
import androidx.compose.foundation.layout.systemBars


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTrabajoPractico(
    viewModel: MainActivityViewModel = hiltViewModel()
) {
    TrabajoPracticoTheme {
        val navController = rememberNavController()
        val scope = rememberCoroutineScope()
        val snackbarHostState = remember { SnackbarHostState() }

        val title by viewModel.titleBar.observeAsState("Inicio")
        val showTopBar by viewModel.showTopBar.observeAsState(true)
        val showBottomBar by viewModel.showBottomBar.observeAsState(true)
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

        var navActions = remember(navController) {
            MainNavActions(navController, scope, drawerState)
        }
//        if (drawerState.isOpen) {
//            BackHandler {
//                scope.launch {
//                    drawerState.close()
//                }
//            }
//        }

//        AppDrawer(
//            drawerState = drawerState,
//            navActions = navActions
//        ) {
            Scaffold(
                topBar = {
                    if (showTopBar) {
                        TopBar(
                            title = title,
                            scope = scope,
                            onMenuClick = { scope.launch { drawerState.open() } }
                        )
                    }
                },
                bottomBar = {
                    if (showBottomBar) {
                        BottomNavBar(navActions, viewModel)
                    }
                },
                snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
                containerColor = MaterialTheme.colorScheme.background,
                contentWindowInsets = WindowInsets.systemBars,
                modifier = Modifier.fillMaxSize()

            ) { innerPadding ->
                MainRouteNavGraph(
                    modifier = Modifier.padding(innerPadding),
                    navController = navController,
                    viewModel = viewModel
                )
            }
        }
    }

