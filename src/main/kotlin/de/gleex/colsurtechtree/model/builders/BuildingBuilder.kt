package de.gleex.colsurtechtree.model.builders

import de.gleex.colsurtechtree.model.Building
import de.gleex.colsurtechtree.model.Product
import de.gleex.colsurtechtree.model.Techtree

class BuildingBuilder(private val name: String) {
    protected val products: MutableMap<Product, Int> = mutableMapOf()

    private var building: Building

    init {
        building = Building(name)
    }

    fun build(): Building {
        return building
    }

    fun produces(count: Int, productName: String) {
        building.produces(count, Techtree.getProduct(productName))
    }
}
