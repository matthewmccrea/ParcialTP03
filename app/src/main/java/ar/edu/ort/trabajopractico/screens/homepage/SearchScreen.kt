package ar.edu.ort.trabajopractico.screens.homepage

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ar.edu.ort.trabajopractico.components.HomeButtons
import ar.edu.ort.trabajopractico.ui.theme.components.AppTextField


@Composable
fun SearchScreen(
    navController: NavController,
    searchText: String,
    onSearchTextChange: (String) -> Unit,
    selectedCategory: String,
    onCategorySelected: (String) -> Unit,
    recentSearches: List<String>,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 24.dp)
    ) {
        Spacer(modifier = Modifier.height(24.dp))


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Box(modifier = Modifier.width(40.dp)) {

            }

            Text(
                text = "Search",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center
            )

            Box(modifier = Modifier.width(40.dp)) {

            }
        }

        Spacer(modifier = Modifier.height(24.dp))


        AppTextField(
            value = searchText,
            onValueChange = onSearchTextChange,
            placeholder = "Search your Product",
            trailingIcon = {
                Icon(Icons.Default.Search, contentDescription = null, tint = Color.Gray)
            }
        )

        Spacer(modifier = Modifier.height(24.dp))


        HomeButtons(
            selectedCategory = selectedCategory,
            onCategorySelected = onCategorySelected
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Recent",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(16.dp))


        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(recentSearches) { item ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = item,
                        fontSize = 14.sp,
                        color = Color(0xFFB3B1B0)
                    )

                    Box(
                        modifier = Modifier
                            .size(28.dp)
                            .background(Color.White, shape = RoundedCornerShape(8.dp))
                            .border(
                                width = 1.5.dp,
                                color = Color(0xFFB3B1B0),
                                shape = RoundedCornerShape(8.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Remove",
                            tint = Color(0xFFB3B1B0),
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            }
        }
    }
}