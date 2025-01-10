package com.rufino.ididit.datasource

import com.rufino.ididit.ui.model.Task

class MockData {
    object data {
        fun getTasks(): List<Task> {
            return listOf(
                Task("Commit new changes", "High", "2025-01-09"),
                Task("Set up room database", "High", "2025-01-09"),
                Task("CRUD operations", "High", "2025-01-09"),
                Task("Create a google play profile", "Medium", "2025-01-09"),
                Task("Deploy the project", "High", "2025-01-09"),
            )
        }
    }
}