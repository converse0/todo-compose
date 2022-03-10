/*
 * Copyright (C) 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.codelabs.state.todo

import com.codelabs.state.util.generateRandomTodoItem
import com.google.common.truth.Truth.assertThat
import org.junit.Test


class TodoViewModelTest {

    @Test
    fun whenRemovingItem_updatesList() {
        val viewModel = TodoViewModel()
        val item1 = generateRandomTodoItem()
        val item2 = generateRandomTodoItem()
        viewModel.addItem(item1)
        viewModel.addItem(item2)

        viewModel.removeItem(item1)

        assertThat(viewModel.todoItems).isEqualTo(listOf(item2))
    }

    @Test
    fun whenAddItem_updateList() {
        val viewModel = TodoViewModel()
        val item = generateRandomTodoItem()
        viewModel.addItem(item)

        assertThat(viewModel.todoItems).isEqualTo(listOf(item))
    }

    @Test
    fun whenNotEditing_currentEditItemIsNull() {
        val viewModel = TodoViewModel()
        val item = generateRandomTodoItem()
        viewModel.addItem(item)

        assertThat(viewModel.currentEditItem).isNull()
    }

    @Test
    fun whenEditing_currentEditItemIsItem() {
        val viewModel = TodoViewModel()
        val item1 = generateRandomTodoItem()
        val item2 = generateRandomTodoItem()

        viewModel.addItem(item1)
        viewModel.addItem(item2)

        viewModel.onEditItemSelected(item2)

        assertThat(viewModel.currentEditItem).isEqualTo(item2)
    }
}
