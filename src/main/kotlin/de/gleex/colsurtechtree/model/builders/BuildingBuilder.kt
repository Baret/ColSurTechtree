package de.gleex.colsurtechtree.model.builders

import de.gleex.colsurtechtree.model.Building

class BuildingBuilder(private val name: String) {
    fun build(): Building {
        return Building(name)
    }

}
