package com.example.dailypulse.android.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.dailypulse.articles.ArticlesViewModel

@Composable
fun ApplicationScaffold(articlesViewModel: ArticlesViewModel) {
    Scaffold {
        AppNavHost( modifier = Modifier
                .fillMaxSize()
                .padding(it), articlesViewModel
        )

    }
}

@Composable
fun AppNavHost(modifier: Modifier, articlesViewModel: ArticlesViewModel)
{
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screens.ARTICLES.route,
        modifier = modifier,
    ) {
        composable(Screens.ARTICLES.route) {
            ArticlesScreen(
                onAboutButtonClick = { navController.navigate(Screens.ABOUT.route) },
                articlesViewModel,
            )
        }

        composable(Screens.ABOUT.route) {
            AboutScreen(
                onUpButtonClick = { navController.popBackStack() }
            )
        }
    }

}