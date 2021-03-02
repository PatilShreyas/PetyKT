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

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BedroomBaby
import androidx.compose.material.icons.filled.ColorLens
import androidx.compose.material.icons.filled.Female
import androidx.compose.material.icons.filled.Leaderboard
import androidx.compose.material.icons.filled.Male
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import dev.shreyaspatil.petykt.data.repository.PetRepository
import dev.shreyaspatil.petykt.ui.component.Chip
import dev.shreyaspatil.petykt.ui.component.Space
import dev.shreyaspatil.petykt.ui.theme.CloudBurst
import dev.shreyaspatil.petykt.ui.theme.IrisBlue

@Composable
fun PetDetailScreen(
    navController: NavController,
    petId: Int,
    repository: PetRepository = PetRepository
) {
    val pet = repository.findById(petId)

    var isAdopted: Boolean by remember { mutableStateOf(false) }

    Scaffold(
        content = {
            LazyColumn(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    Image(
                        painterResource(id = pet.imageResource),
                        "image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(256.dp)
                    )
                }
                item {
                    Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {

                        Text(pet.name, style = MaterialTheme.typography.h3)

                        Spacer(modifier = Modifier.padding(8.dp))

                        Row(horizontalArrangement = Arrangement.Center) {
                            Chip(
                                text = pet.gender,
                                textColor = Color.White,
                                chipColor = MaterialTheme.colors.primary,
                                icon = {
                                    Icon(
                                        if (pet.gender == "Male") Icons.Filled.Male else Icons.Filled.Female,
                                        "Gender",
                                        tint = Color.White
                                    )
                                }
                            )
                            Space(8.dp)
                            Chip(
                                text = pet.breed,
                                textColor = Color.White,
                                chipColor = MaterialTheme.colors.primary,
                                icon = {
                                    Icon(
                                        Icons.Filled.Pets,
                                        "Breed",
                                        tint = Color.White
                                    )
                                }
                            )
                        }
                        Space(4.dp)
                        Row {
                            Chip(
                                text = pet.color,
                                textColor = Color.White,
                                chipColor = MaterialTheme.colors.primary,
                                icon = {
                                    Icon(
                                        Icons.Filled.ColorLens,
                                        "Color",
                                        tint = Color.White
                                    )
                                }
                            )
                            Space(8.dp)
                            Chip(
                                text = pet.skill,
                                textColor = Color.White,
                                chipColor = MaterialTheme.colors.primary,
                                icon = {
                                    Icon(
                                        Icons.Filled.Star,
                                        "Skill",
                                        tint = Color.White
                                    )
                                }
                            )
                        }
                        Space(4.dp)
                        Row {
                            Chip(
                                text = "${pet.weight} KG",
                                textColor = Color.White,
                                chipColor = MaterialTheme.colors.primary,
                                icon = {
                                    Icon(
                                        Icons.Filled.Leaderboard,
                                        "Weight",
                                        tint = Color.White
                                    )
                                }
                            )
                            Space(8.dp)
                            Chip(
                                text = "${pet.age} Year",
                                textColor = Color.White,
                                chipColor = MaterialTheme.colors.primary,
                                icon = {
                                    Icon(
                                        Icons.Filled.BedroomBaby,
                                        "Age",
                                        tint = Color.White
                                    )
                                }
                            )
                        }
                        Space(16.dp)
                        Text(pet.bio, style = MaterialTheme.typography.body1)
                    }
                }
                item {
                    Button(
                        onClick = { isAdopted = true },
                        enabled = !isAdopted,
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = IrisBlue,
                            disabledBackgroundColor = CloudBurst
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(70.dp)
                    ) {
                        Icon(Icons.Default.Pets, contentDescription = "Adopt", tint = Color.White)
                        Space(8.dp)
                        Text(
                            if (isAdopted) "${pet.name} is coming your home" else "Adopt Me",
                            color = Color.White
                        )
                    }
                }
            }
        }
    )
}
