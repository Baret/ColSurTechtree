package de.gleex.colsurtechtree.model

import au.com.console.kassava.kotlinEquals
import au.com.console.kassava.kotlinToString
import de.gleex.colsurtechtree.model.interfaces.Producing
import java.util.*

class Building(val name: String): Producing() {

    override fun toString() = "Building $name produces $produced"

    override fun equals(other: Any?) = kotlinEquals(other, arrayOf(Building::name))

    override fun hashCode() = Objects.hash(name)
}