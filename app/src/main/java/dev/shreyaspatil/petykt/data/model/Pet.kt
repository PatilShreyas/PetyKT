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
package dev.shreyaspatil.petykt.data.model

data class Pet(
    val id: Int,
    val name: String,
    val breed: String,
    val gender: String,
    val age: Int,
    val color: String,
    val weight: Int,
    val skill: String,
    val imageResource: Int
) {
    val bio = """
        Hey there! I'm $gender $breed and my name is $name.
        I'm $age years old having beautiful $color skin color. 
        I'm $weight KGs in weight and I'm expert in $skill.
        If you adopt me, I'll change your life for sure :)
    """.trimIndent()
}
