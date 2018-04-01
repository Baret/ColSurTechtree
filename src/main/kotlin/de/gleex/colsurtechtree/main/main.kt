package de.gleex.colsurtechtree.main

import de.gleex.colsurtechtree.dsl.job
import de.gleex.colsurtechtree.model.Job
import de.gleex.colsurtechtree.model.Techtree
import de.gleex.colsurtechtree.model.builders.JobBuilder

fun main(args: Array<String>) {

    val farmer = job("Farmer") {
        worksIn("Farm")
        worksIn("Tailorshop")
    }

    println(Techtree)
}

