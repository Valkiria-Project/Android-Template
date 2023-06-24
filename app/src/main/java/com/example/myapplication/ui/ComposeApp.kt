package com.example.myapplication.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myapplication.ui.fetch.FetchScreen
import com.example.myapplication.ui.myscreen.MyScreen
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun ComposeApp() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavigationRoute.FETCH
    ) {
        composable(NavigationRoute.FETCH) { backStackEntry ->
            FetchScreen(
                onClick = { congratsSDModel ->
                    navController.navigate("${NavigationRoute.SERVER_DRIVEN_UI}/${congratsSDModel.type.name}")
                }
            )
        }
        composable(
            route = "${NavigationRoute.SERVER_DRIVEN_UI}/{${NavigationArgument.MESSAGE}}",
            arguments = listOf(
                navArgument(NavigationArgument.MESSAGE) {
                    type = NavType.StringType
                }
            ),
        ) {
            MyScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeAppPreview() {
    MyApplicationTheme {
        ComposeApp()
    }
}
