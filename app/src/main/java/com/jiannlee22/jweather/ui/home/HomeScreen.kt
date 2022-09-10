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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.jiannlee22.jweather.JWeatherDestination
import com.jiannlee22.jweather.R

@Composable
fun HomeScreen(onNavToCityScreen: NavHostController) {
    val city = "广州市 白云区"
    Column {
        TopBar(city, onNavToCityScreen)
        WeatherInfo(city)
    }
}

@Composable
private fun TopBar(city: String, onNavToCityScreen: NavHostController) {
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
        Text(
            text = city,
            modifier = Modifier.align(Alignment.Center),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun WeatherInfo(city: String) {
    val weatherInfo = "晴天 33"
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = city,
            fontSize = 34.sp,
        )

        Text(text = weatherInfo)
    }
}

@Preview(showBackground = true, name = "Light")
@Composable
fun PreviewTopBar() {
    HomeScreen(onNavToCityScreen = rememberNavController())
}