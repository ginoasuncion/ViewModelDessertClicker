package tat.mukhutdinov.lesson10.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import tat.mukhutdinov.lesson10.data.Datasource
import tat.mukhutdinov.lesson10.domain.DetermineDessert
import tat.mukhutdinov.lesson10.model.DessertClickerUiState

class DessertViewModel : ViewModel() {

    private val determineDessert = DetermineDessert()

    private val _uiState = MutableStateFlow(
        DessertClickerUiState(
            currentDessertPrice = Datasource.dessertList.first().price,
            currentDessertImageId = Datasource.dessertList.first().imageId
        )
    )

    val uiState: StateFlow<DessertClickerUiState> = _uiState
    private val desserts = Datasource.dessertList

    fun onDessertClicked() {
        val newRevenue = _uiState.value.revenue + _uiState.value.currentDessertPrice
        val newDessertsSold = _uiState.value.dessertsSold + 1
        val dessertToShow = determineDessert.execute(desserts, newDessertsSold)

        _uiState.value = _uiState.value.copy(
            revenue = newRevenue,
            dessertsSold = newDessertsSold,
            currentDessertPrice = dessertToShow.price,
            currentDessertImageId = dessertToShow.imageId
        )
    }
}
