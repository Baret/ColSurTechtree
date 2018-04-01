package de.gleex.colsurtechtree.model

import au.com.console.kassava.kotlinEquals
import java.util.*

class Job(override val name: String): Entity {

    private val assignableBuildings: MutableSet<Building> = mutableSetOf()

    fun addAssignableBuildings(vararg buildings: Building) {
        assignableBuildings.addAll(buildings)
    }

    override fun toString(): String {
        return "Job $name (assignable buildings: $assignableBuildings"
    }

    override fun equals(other: Any?) = kotlinEquals(other, arrayOf(Job::name))

    override fun hashCode() = Objects.hash(name)
}