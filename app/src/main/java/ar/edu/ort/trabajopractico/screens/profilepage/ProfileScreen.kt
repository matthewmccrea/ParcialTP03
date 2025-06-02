package ar.edu.ort.trabajopractico.screens.profilepage
import androidx.lifecycle.viewmodel.compose.viewModel
import ar.edu.ort.trabajopractico.viewmodels.profilepage.ProfilePageVM
import ar.edu.ort.trabajopractico.components.profilepage.SellerStatsSection
import ar.edu.ort.trabajopractico.components.profilepage.HeaderSection
import ar.edu.ort.trabajopractico.components.profilepage.ActionTabs
import ar.edu.ort.trabajopractico.components.SegmentedToggle
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ar.edu.ort.trabajopractico.MainActivityViewModel
import ar.edu.ort.trabajopractico.R
import ar.edu.ort.trabajopractico.components.ProductGrid
import ar.edu.ort.trabajopractico.data.Product
import ar.edu.ort.trabajopractico.navigation.LeafScreen


@Composable
fun ProfileScreen(navController: NavController, viewModel: ProfilePageVM = viewModel(), mainViewModel: MainActivityViewModel) {
    val isSeller = viewModel.isSeller
    val selectedTab = viewModel.selectedTab


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        SegmentedToggle(
            options = listOf("Profile", "Seller Mode"),
            selectedIndex = if (isSeller) 1 else 0,
            onOptionSelected = { index ->
                if ((index == 1) != isSeller) viewModel.toggleMode()
            },
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .padding(16.dp)
                .align(Alignment.CenterHorizontally)
        )


        Box(modifier = Modifier.fillMaxWidth()) {

        HeaderSection(
            isSeller = isSeller,
            username = if (isSeller) "Pittashop" else "Abduldul",
            onToggleMode = viewModel::toggleMode,
            isEdit = false,
            navController = navController
        )


        }
        if (isSeller) {
            SellerStatsSection()
        }

        ActionTabs(
            tabs = if (isSeller) listOf("Product", "Sold", "Stats") else listOf("Saved", "Edit Profile"),
            selectedTab = selectedTab,
            onTabSelected = viewModel::selectTab
        )

        Spacer(modifier = Modifier.weight(1f))

        if (selectedTab == "Product" || selectedTab == "Saved" ||  selectedTab=="Sold"  ) {
            ProductGrid(products = mockProducts ,  onProductClick = {})
        }
    }
}
val mockProducts = listOf(
    Product("RC Kitten", "20,99", R.drawable.food_1),
    Product("RC Persian", "22,99", R.drawable.food_1),
    Product("RC Kitten", "20,99", R.drawable.food_2),
    Product("RC Persian", "22,99", R.drawable.food_2)
)
