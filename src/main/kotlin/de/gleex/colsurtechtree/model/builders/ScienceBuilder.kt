package de.gleex.colsurtechtree.model.builders

import de.gleex.colsurtechtree.dsl.TechtreeDsl
import de.gleex.colsurtechtree.model.Science
import de.gleex.colsurtechtree.model.Techtree

@TechtreeDsl
class ScienceBuilder(val name: String) {
    private val science = Techtree.getScience(name)

    fun build(): Science {
        return science
    }

    fun unlocksJobs(vararg jobNames: String) {
        for(jobName in jobNames) {
            science.unlocks(Techtree.getJob(jobName))
        }
    }

    fun requires(vararg scienceNames: String) {
        scienceNames.forEach { science.requires(Techtree.getScience(it)) }
    }

}