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
        worksIn("Farm")
    }

    building("Farm") {
        produces("Wheat")
        produces("Straw")
    }

    building("Grindstone") {
        produces(2, "Flour") {
            needs(2, "Wheat")
        }
    }

    building("Oven") {
        produces(2, "Bread") {
            needs(5, "Flour")
            needs("Firewood")
        }
    }

    job("Grinder") {
        worksIn("Grindstone")
    }

    job("Forester") {
        worksIn("Forest")
    }

    building("Forest") {
        produces("Log")
    }


}

