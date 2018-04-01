package de.gleex.colsurtechtree.model.builders

import de.gleex.colsurtechtree.model.Building
import de.gleex.colsurtechtree.model.Techtree

class BuildingBuilder(name: String) {
    private val building = Techtree.getBuilding(name)

    fun build(): Building {
        return building
    }

    fun produces(count: Int, productName: String) {
        building.produces(count, Techtree.getProduct(productName))
    }
}
