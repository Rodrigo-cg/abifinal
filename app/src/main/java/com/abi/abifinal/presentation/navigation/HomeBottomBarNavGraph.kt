package com.abi.abifinal.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.List
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.abi.abifinal.presentation.screens.profile.ProfileScreen

@Composable
fun HomeBottomBarNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = HomeBottomBarScreen.Posts.route
    ){

        composable(route = HomeBottomBarScreen.Profile.route){
            ProfileScreen(navController)
        }

        composable(route = HomeBottomBarScreen.Posts.route){
            //PostsScreen(navController)
        }

        composable(route = HomeBottomBarScreen.MyPosts.route){
            //MyPostsScreen(navController)
        }

        detailsNavGraph(navController)
    }

}

sealed class HomeBottomBarScreen(
    val route: String,
    var tittle: String,
    var icon: ImageVector
) {

    object Posts : HomeBottomBarScreen(
        route = "posts_list",
        tittle = "Auxilio",
        icon = Icons.Outlined.List
    )

    object MyPosts : HomeBottomBarScreen(
        route = "my_posts",
        tittle = "Dashboard",
        icon = Icons.Outlined.List
    )

    object Profile :
        HomeBottomBarScreen(route = "profile", tittle = "Perfil", icon = Icons.Default.Person)

}
