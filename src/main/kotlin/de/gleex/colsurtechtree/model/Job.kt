package de.gleex.colsurtechtree.model

import au.com.console.kassava.kotlinEquals
import java.util.*

class Job(override val name: String): Entity() {

    private val assignableBuildings: MutableSet<Building> = mutableSetOf()

    fun addAssignableBuildings(vararg buildings: Building) {
        assignableBuildings.addAll(buildings)
    }

    override fun toShortString() = "Job $name"

    override fun toString(): String = "Job $name (assignable buildings: ${assignableBuildings.map(Building::toShortString)}"

    override fun equals(other: Any?) = kotlinEquals(other, arrayOf(Job::name))

    override fun hashCode() = Objects.hash(name)
}