package de.gleex.colsurtechtree.main

import de.gleex.colsurtechtree.model.Building
import de.gleex.colsurtechtree.model.Product
import de.gleex.colsurtechtree.model.Techtree

fun main(args: Array<String>) {
    var wheat = Product("Wheat")
    var log = Product("Log")
    var farm = Building("Farm")
    farm.produces(1, wheat)
    farm.produces(3, log)

    println("wheat: $wheat")
    println("farm:  $farm")
    println("$log is produced by  ${log.getProducedBy()}")

    Techtree.addBuildings(farm)
    Techtree.addProducts(log, wheat)
    println(Techtree)
}