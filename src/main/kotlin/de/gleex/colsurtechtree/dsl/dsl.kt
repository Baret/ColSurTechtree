package de.gleex.colsurtechtree.dsl

import de.gleex.colsurtechtree.model.Job
import de.gleex.colsurtechtree.model.builders.JobBuilder

fun job(name: String, block: JobBuilder.() -> Unit): Job {
    return JobBuilder(name).apply(block).build()
}