package de.gleex.colsurtechtree.main

import de.gleex.colsurtechtree.dsl.building
import de.gleex.colsurtechtree.dsl.job
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
                needs("Berry Seedb")
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



}

