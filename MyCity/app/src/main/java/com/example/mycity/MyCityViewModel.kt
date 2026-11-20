package com.example.mycity

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MyCityViewModel : ViewModel() {
    private val _allPlaces = MutableStateFlow(DataSource.places)
    val allPlaces: StateFlow<List<Place>> = _allPlaces.asStateFlow()

    val categories = DataSource.places.map { it.category }.distinct()

    fun getPlacesByCategory(category: String): List<Place> {
        return _allPlaces.value.filter { it.category == category }
    }
}