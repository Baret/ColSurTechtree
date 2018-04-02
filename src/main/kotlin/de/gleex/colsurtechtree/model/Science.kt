package de.gleex.colsurtechtree.model

import au.com.console.kassava.kotlinEquals
import java.util.*

class Science(override val name: String) : Entity() {
    private val unlocks: MutableSet<Entity> = mutableSetOf()
    private val requires: MutableSet<Science> = mutableSetOf()

    fun unlocks(entity: Entity) {
        unlocks.add(entity)
        entity.unlockedBy(this)
    }

    fun requires(requiredScience: Science) = requires.add(requiredScience)

    override fun toString(): String = "Science $name requires ${if(requires.isEmpty()) "nothing" else requires}, unlocks $unlocks"

    override fun equals(other: Any?) = kotlinEquals(other, arrayOf(Science::name))

    override fun hashCode() = Objects.hash(name)
}