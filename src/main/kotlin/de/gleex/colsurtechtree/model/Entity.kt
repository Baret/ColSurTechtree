package de.gleex.colsurtechtree.model

import java.io.Serializable

abstract class Entity: Comparable<Entity>, Serializable {
    abstract val name: String
    private val unlockedBy: MutableSet<Science> = mutableSetOf()

    fun unlockedBy(science: Science) {
        unlockedBy.add(science)
    }

    abstract fun toShortString(): String

    override fun compareTo(other: Entity): Int = name.compareTo(other.name)
}
