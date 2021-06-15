/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dev.shreyaspatil.petykt

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import dev.shreyaspatil.petykt.ui.screen.PetDetailScreen
import dev.shreyaspatil.petykt.ui.screen.PetsScreen

@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@ExperimentalAnimationApi
@Composable
fun PetyNavigation() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = Screen.Pets.route) {
        composable(Screen.Pets.route) {
            PetsScreen(navController)
        }
        composable(
            Screen.PetDetail.route,
            arguments = listOf(
                navArgument("id") { type = NavType.IntType }
            )
        ) {
            val id = it.arguments?.getInt("id")
                ?: throw IllegalStateException("'id' shouldn't be null")
            PetDetailScreen(navController, petId = id)
        }
        //this is a test comment please don't merge it
    }
}

sealed class Screen(val route: String) {
    object Pets : Screen("pets")
    object PetDetail : Screen("pets/{id}") {
        fun route(id: Int) = "pets/$id"
    }
}
