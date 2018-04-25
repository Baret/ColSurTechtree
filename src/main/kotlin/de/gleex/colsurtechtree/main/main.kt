package de.gleex.colsurtechtree.main

import de.gleex.colsurtechtree.dsl.building
import de.gleex.colsurtechtree.dsl.job
import de.gleex.colsurtechtree.dsl.science
import de.gleex.colsurtechtree.fulltree.fullTree
import de.gleex.colsurtechtree.model.Techtree

fun main(args: Array<String>) {

    fullTree()
    //defineTestTechtree()

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
        costs(5, "Copper Parts")
        costs(10, "Nails")
        costs(10, "Berries")
    }

    building("Workbench") {
        produces(2, "Copper Nails") {
            needs("Copper Ore")
        }
        produces("Copper Tools") {
            needs("Copper Ore")
        }
        produces("Copper Parts") {
            needs("Copper Ore")
        }
        produces("Bowstring") {
            needs(2, "Leaves")
        }
        produces("Bed") {
            needs(5, "Straw")
            needs("Plank")
            needs(8, "Copper Nails")
        }
    }

}

