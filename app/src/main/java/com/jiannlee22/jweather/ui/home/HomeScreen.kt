package com.jiannlee22.jweather.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.jiannlee22.jweather.JWeatherDestination
import com.jiannlee22.jweather.R
import com.jiannlee22.jweather.viewmodel.HomeViewModel

@Composable
fun HomeScreen(onNavToCityScreen: NavHostController) {
    val homeViewModel: HomeViewModel = hiltViewModel()
    homeViewModel.weatherNow()
    Column {
        TopBar(onNavToCityScreen)
        WeatherInfo()
    }
}

@Composable
private fun TopBar(onNavToCityScreen: NavHostController) {
    Box(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        IconButton(
            onClick = { onNavToCityScreen.navigate(JWeatherDestination.CITY_PAGE_ROUTE) },
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_city),
                contentDescription = "add city"
            )
        }
    }
}

@Composable
fun WeatherInfo(homeViewModel: HomeViewModel = viewModel()) {
    val now = homeViewModel.weatherNow?.now?.text
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "",
            fontSize = 34.sp,
        )

        Text(text = now ?: "")
    }
}

@Preview(showBackground = true, name = "Light")
@Composable
fun PreviewTopBar() {
    HomeScreen(onNavToCityScreen = rememberNavController())
}