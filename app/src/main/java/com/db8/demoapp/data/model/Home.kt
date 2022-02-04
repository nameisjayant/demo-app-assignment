package com.db8.demoapp.data.model

data class Home(
    val availableProducts: List<AvailableProducts>
) {
    data class AvailableProducts(
        val id: String,
        val price: Price,
        val title:String,
        val thumbnailUrl: String
    )

    data class Price(
        val amount: Double
    )
}