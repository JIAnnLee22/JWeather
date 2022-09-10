package com.jiannlee22.jweather

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jiannlee22.jweather.ui.city.CityScreen
import com.jiannlee22.jweather.ui.home.HomeScreen

@Composable
fun NavGraph(
    startDestination: String = JWeatherDestination.HOME_PAGE_ROUTE,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(JWeatherDestination.HOME_PAGE_ROUTE) {
            HomeScreen(onNavToCityScreen = navController)
        }
        composable(JWeatherDestination.CITY_PAGE_ROUTE) { CityScreen() }
    }
}

object JWeatherDestination {
    const val HOME_PAGE_ROUTE = "home_page_route"
    const val CITY_PAGE_ROUTE = "city_page_route"
}