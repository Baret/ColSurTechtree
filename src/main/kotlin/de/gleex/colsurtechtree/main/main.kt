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
        worksIn("Tailorshop")
    }

    building("Farm") {
        produces(3, "Wheat")
        produces(1, "Straw")
    }

    building("Tailorshop") {
        produces(1, "Cloth")
    }

    building("Tailorshop") {
        produces(2, "Linen bags")
    }

    // future plan
/*    building("Oven") {
        produces(2, "Bread") {
            needs(5, "Flour")
            needs("Firewood")
        }
    }*/
}

