package de.gleex.colsurtechtree.model.builders

import de.gleex.colsurtechtree.dsl.TechtreeDsl
import de.gleex.colsurtechtree.model.Job
import de.gleex.colsurtechtree.model.Techtree

@TechtreeDsl
class JobBuilder(name: String) {
    private val job = Techtree.getJob(name)

    fun build(): Job {
        return job
    }

    fun worksIn(buildingName: String, buildingBlock: BuildingBuilder.() -> Unit = {}) {
        val building = BuildingBuilder(buildingName).apply(buildingBlock).build()
        job.addAssignableBuildings(building)
    }

}
