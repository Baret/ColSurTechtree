package de.gleex.colsurtechtree.model

import au.com.console.kassava.kotlinEquals
import java.util.*

class Job(val name: String) {

    private val assignableBuildings: MutableSet<Building> = mutableSetOf()

    constructor(name: String, vararg buildings: Building) : this(name) {
        assignableBuildings.addAll(buildings)
    }

    init {
        Techtree.addJobs(this)
    }

    override fun toString(): String {
        return "Job $name (assignable buildings: $assignableBuildings"
    }

    override fun equals(other: Any?) = kotlinEquals(other, arrayOf(Job::name))

    override fun hashCode() = Objects.hash(name)
}