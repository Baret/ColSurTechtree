package de.gleex.colsurtechtree.main

import de.gleex.colsurtechtree.dsl.job
import de.gleex.colsurtechtree.dsl.science
import de.gleex.colsurtechtree.fulltree.fullTree
import de.gleex.colsurtechtree.model.Techtree

fun main(args: Array<String>) {

    fullTree()

    println(Techtree)
}

private fun defineTestTechtree() {
    job("Berry Farmer") {
        worksIn("Berryfarm") {
            produces("Berry Seed")
            produces("Berries") {
                needs("Berry Seed")
            }
        }
    }

    job("Forester") {
        worksIn("Forest") {
            produces(2, "Log") {
                needs("Sapling")
            }
            produces("Sapling")
        }
    }

    science("Bread Production") {
        unlocksJobs("Farmer", "Miller", "Baker")
    }

}

