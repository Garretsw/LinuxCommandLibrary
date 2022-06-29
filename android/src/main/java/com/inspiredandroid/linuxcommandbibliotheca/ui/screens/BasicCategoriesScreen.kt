@file:OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class)

package com.inspiredandroid.linuxcommandbibliotheca.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.ListItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.inspiredandroid.linuxcommandbibliotheca.getIconResource
import databases.BasicCategory
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

/* Copyright 2022 Simon Schubert
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/

@Composable
fun BasicCategoriesScreen(basicCategories: List<BasicCategory>, onNavigate: (String) -> Unit = {}) {
    LazyVerticalGrid(cells = GridCells.Adaptive(minSize = 300.dp)) {
        items(items = basicCategories) { basicCategory ->
            ListItem(
                text = { Text(basicCategory.title) },
                icon = {
                    Icon(
                        painterResource(basicCategory.getIconResource()),
                        contentDescription = null,
                        modifier = Modifier.size(40.dp)
                    )
                },
                modifier = Modifier.clickable {
                    onNavigate(
                        "basicgroups?categoryId=${basicCategory.id}&categoryName=${
                            URLEncoder.encode(basicCategory.title, StandardCharsets.UTF_8.toString())
                        }"
                    )
                })
        }
    }
}