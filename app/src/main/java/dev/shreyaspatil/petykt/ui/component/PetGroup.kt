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

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.shreyaspatil.petykt.ui.screen.PetAttribute

@ExperimentalAnimationApi
@Composable
fun PetGroup(onGroupSelected: (PetAttribute) -> Unit) {
    var showFilter by remember { mutableStateOf(false) }

    var petGroupBy: PetAttribute by remember { mutableStateOf(PetAttribute.All) }

    AnimatedVisibility(visible = !showFilter) {
        Box(
            modifier = Modifier
                .clip(CutCornerShape(8.dp))
                .clickable { showFilter = showFilter.not() }
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Icon(
                    Icons.Filled.FilterList,
                    "Filter",
                    tint = Color.Black
                )
                Text(
                    "Grouped By: ${petGroupBy.name}",
                    modifier = Modifier
                        .padding(16.dp)
                )
            }
        }
    }

    AnimatedVisibility(visible = showFilter) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            PetAttribute.values().forEach {
                Surface(color = Color.Transparent, modifier = Modifier.padding(4.dp)) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(16.dp))
                            .clickable {
                                petGroupBy = it
                                showFilter = showFilter.not()
                                onGroupSelected(it)
                            }
                    ) {
                        Text(
                            it.name,
                            color = Color.White,
                            style = MaterialTheme.typography.body2,
                            modifier = Modifier
                                .background(MaterialTheme.colors.secondary)
                                .padding(8.dp)
                        )
                    }
                }
            }
        }
    }
}
