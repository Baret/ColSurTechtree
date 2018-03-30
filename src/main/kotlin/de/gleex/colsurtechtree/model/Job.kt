package de.gleex.colsurtechtree.model

class Job (val name: String) {
    private val assignableBuildings: MutableSet<Building> = mutableSetOf()
}