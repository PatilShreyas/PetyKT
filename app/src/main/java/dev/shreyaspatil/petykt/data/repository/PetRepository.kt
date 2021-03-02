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
package dev.shreyaspatil.petykt.data.repository

import dev.shreyaspatil.petykt.R
import dev.shreyaspatil.petykt.data.model.Pet

object PetRepository {

    val pets = listOf(
        Pet(
            0,
            "Pocky",
            "German Shepherd",
            "Male",
            1,
            "Brown",
            15,
            randomSkill,
            R.drawable.german_shef_1
        ),
        Pet(
            1,
            "Qocky",
            "German Shepherd",
            "Male",
            2,
            "Brown",
            16,
            randomSkill,
            R.drawable.german_shef_2
        ),
        Pet(
            2,
            "Rocky",
            "German Shepherd",
            "Female",
            3,
            "Brown",
            20,
            randomSkill,
            R.drawable.german_shef_3
        ),
        Pet(
            3,
            "Socky",
            "Bull Dog",
            "Male",
            4,
            "Black",
            10,
            randomSkill,
            R.drawable.bull_1
        ),
        Pet(
            4,
            "Tocky",
            "Bull Dog",
            "Female",
            5,
            "Brown",
            12,
            randomSkill,
            R.drawable.bull_2
        ),
        Pet(
            5,
            "Vocky",
            "Labrador",
            "Male",
            6,
            "Yellow",
            25,
            randomSkill,
            R.drawable.lab_1
        ),
        Pet(
            6,
            "Wocky",
            "Labrador",
            "Female",
            7,
            "White",
            30,
            randomSkill,
            R.drawable.lab_2
        ),
        Pet(
            7,
            "Xocky",
            "Chow Chow",
            "Male",
            8,
            "White",
            13,
            randomSkill,
            R.drawable.chow_1
        ),
        Pet(
            8,
            "Yocky",
            "Chow Chow",
            "Female",
            9,
            "Brown",
            13,
            randomSkill,
            R.drawable.chow_2
        ),
    )

    fun findById(id: Int): Pet = pets[id]
}

val skills = listOf("Programmer", "Problem solving", "Sharp Shooter", "Cricket", "Football")

val randomSkill: String
    get() = skills.random()
