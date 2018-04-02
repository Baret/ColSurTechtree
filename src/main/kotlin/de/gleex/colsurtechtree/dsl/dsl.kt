package de.gleex.colsurtechtree.dsl

import de.gleex.colsurtechtree.model.Building
import de.gleex.colsurtechtree.model.Job
import de.gleex.colsurtechtree.model.Science
import de.gleex.colsurtechtree.model.builders.BuildingBuilder
import de.gleex.colsurtechtree.model.builders.JobBuilder
import de.gleex.colsurtechtree.model.builders.ScienceBuilder

@TechtreeDsl
fun job(name: String, block: JobBuilder.() -> Unit): Job {
    return JobBuilder(name).apply(block).build()
}

@TechtreeDsl
fun building(name: String, block: BuildingBuilder.() -> Unit = {}): Building {
    return BuildingBuilder(name).apply(block).build()
}

@TechtreeDsl
fun science(name: String, block: ScienceBuilder.() -> Unit): Science {
    return ScienceBuilder(name).apply(block).build()
}