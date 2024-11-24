package tat.mukhutdinov.lesson10.domain

import tat.mukhutdinov.lesson10.model.Dessert

class DetermineDessert {
    fun execute(desserts: List<Dessert>, dessertsSold: Int): Dessert {
        var dessertToShow = desserts.first()
        for (dessert in desserts) {
            if (dessertsSold >= dessert.startProductionAmount) {
                dessertToShow = dessert
            } else {
                break
            }
        }
        return dessertToShow
    }
}
