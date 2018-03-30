package de.gleex.colsurtechtree.main

import de.gleex.colsurtechtree.model.Building
import de.gleex.colsurtechtree.model.Job
import de.gleex.colsurtechtree.model.Product
import de.gleex.colsurtechtree.model.Techtree
import de.gleex.colsurtechtree.model.builders.JobBuilder

fun main(args: Array<String>) {

    val farmer = job("farmer") {
        worksIn("Farm") {
        }
    }

    println(Techtree)
}

fun job(name: String, block: JobBuilder.() -> Unit): Job {
    return JobBuilder(name).apply(block).build()
}
