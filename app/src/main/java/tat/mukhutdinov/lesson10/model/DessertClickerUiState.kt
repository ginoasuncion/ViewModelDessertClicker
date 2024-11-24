package tat.mukhutdinov.lesson10.model

/**
 * [DessertClickerUiState] represents the current state of the UI for the DessertClickerApp.
 */

data class DessertClickerUiState(
    val revenue: Int = 0,
    val dessertsSold: Int = 0,
    val currentDessertPrice: Int = 0,
    val currentDessertImageId: Int = 0
)

