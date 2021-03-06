package com.db8.demoapp.data.model

data class Home(
    val workDetails: WorkDetails
) {

    data class WorkDetails(
        val availableProducts: List<AvailableProducts>,
        val id: String,
        val artist:Artist
    )

    data class Artist(
        val id:String
    )

    data class AvailableProducts(
        val id: String,
        val price: Price,
        val title: String,
        val thumbnailUrl: String
    )

    data class Price(
        val amount: Double
    )
}



