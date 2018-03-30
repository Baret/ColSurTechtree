package de.gleex.colsurtechtree.model.builders

import de.gleex.colsurtechtree.model.Building
import de.gleex.colsurtechtree.model.Job
import java.util.*

class JobBuilder(private val name: String) {
    private val buildings: MutableSet<Building> = mutableSetOf()

    fun build(): Job {
        return Job(name, *buildings.toTypedArray())
    }

    fun worksIn(buildingName: String, block: BuildingBuilder.() -> Unit) {
        buildings.add(BuildingBuilder(buildingName).apply(block).build())
    }

}
