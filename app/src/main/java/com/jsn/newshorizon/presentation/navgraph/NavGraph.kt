package com.jsn.newshorizon.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.jsn.newshorizon.presentation.onboarding.OnBoardingScreen
import com.jsn.newshorizon.presentation.onboarding.OnBoardingViewModel
import com.jsn.newshorizon.presentation.search.SearchScreen
import com.jsn.newshorizon.presentation.search.SearchViewModel

@Composable
fun NavGraph(startDestination: String) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ) {
            composable(route = Route.OnBoardingScreen.route) {
                val onBoardingViewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(
                    event = onBoardingViewModel::onEvent
                )
            }
        }

        navigation(
            route = Route.NewsNavigation.route,
            startDestination = Route.NewsNavigatorScreen.route
        ) {
            composable(route = Route.NewsNavigatorScreen.route) {
                //  Text(text = "News Navigator Screen")
//                val viewModel: HomeViewModel = hiltViewModel()
//                val articles = viewModel.news.collectAsLazyPagingItems()
//                HomeScreen(articles = articles, navigate = {})
                val viewModel: SearchViewModel = hiltViewModel()
                SearchScreen(
                    state = viewModel.state.value,
                    event = {
                        viewModel.onEvent(it)
//                        viewModel::onEvent
                    }

                    , navigate = {})
            }
        }

    }

}