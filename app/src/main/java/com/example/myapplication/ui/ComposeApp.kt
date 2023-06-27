package com.example.myapplication.ui

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myapplication.ui.deviceauth.DeviceAuthScreen
import com.example.myapplication.ui.fetch.FetchScreen
import com.example.myapplication.ui.myscreen.MyScreen
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun ComposeApp(
    scope: CoroutineScope,
    snackbarHostState: SnackbarHostState
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavigationRoute.FETCH
    ) {
        composable(
            route = NavigationRoute.FETCH
        ) {
            FetchScreen(
                onClick = { identifier ->
                    navController.navigate("${NavigationRoute.MY_SCREEN_UI}/${identifier}")
                },
                deviceAuthClick = {
                    navController.navigate(NavigationRoute.DEVICE_AUTH_SCREEN)
                }
            )
        }
        composable(
            route = "${NavigationRoute.MY_SCREEN_UI}/{${NavigationArgument.ID}}",
            arguments = listOf(
                navArgument(NavigationArgument.ID) {
                    type = NavType.LongType
                }
            )
        ) {
            MyScreen(
                onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar(
                            "Button clicked"
                        )
                    }
                }
            )
        }
        composable(
            route = NavigationRoute.DEVICE_AUTH_SCREEN
        ) {
            DeviceAuthScreen(
                onClick = { }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeAppPreview(
    scope: CoroutineScope = rememberCoroutineScope(),
    snackbarHostState: SnackbarHostState = remember { SnackbarHostState() }
) {
    MyApplicationTheme {
        ComposeApp(scope, snackbarHostState)
    }
}
