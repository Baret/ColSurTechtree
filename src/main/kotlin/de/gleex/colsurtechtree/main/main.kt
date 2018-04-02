package de.gleex.colsurtechtree.main

import de.gleex.colsurtechtree.dsl.job
import de.gleex.colsurtechtree.dsl.science
import de.gleex.colsurtechtree.model.Techtree

fun main(args: Array<String>) {

    defineTechtree()

    println(Techtree)
}

private fun defineTechtree() {

    job("Farmer") {
        worksIn("Farm") {
            produces("Wheat")
            produces("Straw")
        }
    }

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
            produces("Log") {
                needs("Sapling")
            }
            produces("Sapling")
        }
    }

    science("Bread Production") {
        unlocksJobs("Farmer", "Grinder", "Baker")
    }

}
