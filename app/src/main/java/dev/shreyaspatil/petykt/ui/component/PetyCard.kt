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
package dev.shreyaspatil.petykt.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.shreyaspatil.petykt.data.model.Pet
import dev.shreyaspatil.petykt.data.repository.PetRepository

@Composable
fun PetyCard(pet: Pet, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp, 4.dp)
            .clickable { onClick() }
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Image(
                painterResource(id = pet.imageResource),
                "image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(128.dp)
            )

            Column(modifier = Modifier.padding(16.dp)) {
                Text(pet.name, textAlign = TextAlign.Center, style = MaterialTheme.typography.h5)

                Spacer(modifier = Modifier.size(16.dp))

                GenderChip(gender = pet.gender)

                Spacer(modifier = Modifier.size(8.dp))

                Text(
                    pet.breed,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.overline
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PetyCardPreview() {
    PetyCard(
        pet = PetRepository.pets.first(),
        onClick = { }
    )
}
