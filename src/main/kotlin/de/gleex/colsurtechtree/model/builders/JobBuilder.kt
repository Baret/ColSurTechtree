package de.gleex.colsurtechtree.model.builders

import de.gleex.colsurtechtree.model.Job
import de.gleex.colsurtechtree.model.Techtree

class JobBuilder(name: String) {
    private val job = Techtree.getJob(name)

    fun build(): Job {
        return job
    }

    fun worksIn(buildingName: String) {
        job.addAssignableBuildings(Techtree.getBuilding(buildingName))
    }

}
