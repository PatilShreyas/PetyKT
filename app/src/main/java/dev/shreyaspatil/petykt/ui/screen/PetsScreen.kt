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
package dev.shreyaspatil.petykt.ui.screen

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import dev.shreyaspatil.petykt.Screen
import dev.shreyaspatil.petykt.data.repository.PetRepository
import dev.shreyaspatil.petykt.ui.component.PetGroup
import dev.shreyaspatil.petykt.ui.component.PetsList

@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@Composable
fun PetsScreen(navController: NavController) {

    val pets = PetRepository.pets.shuffled()

    var petGroupBy: PetAttribute by remember { mutableStateOf(PetAttribute.All) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Pety",
                        textAlign = TextAlign.Start,
                        color = MaterialTheme.colors.onPrimary,
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = MaterialTheme.colors.onPrimary,
                elevation = 0.dp
            )
        },
        content = {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                PetGroup(onGroupSelected = { petGroupBy = it })

                val groupedPets = when (petGroupBy) {
                    PetAttribute.All -> mapOf("All" to pets)
                    PetAttribute.Breed -> pets.groupBy { it.breed }
                    PetAttribute.Gender -> pets.groupBy { it.gender }
                    PetAttribute.Color -> pets.groupBy { it.color }
                    PetAttribute.Skill -> pets.groupBy { it.skill }
                }

                PetsList(groupedPets) {
                    navController.navigate(Screen.PetDetail.route(it.id))
                }
            }
        }
    )
}

enum class PetAttribute { All, Breed, Gender, Color, Skill }
