package de.gleex.colsurtechtree.model

import au.com.console.kassava.kotlinEquals
import java.util.*

class Science(override val name: String) : Entity() {
    private val unlocks: MutableSet<Entity> = mutableSetOf()
    private val requires: MutableSet<Science> = mutableSetOf()
    private val costs: MutableSet<ProductCount> = mutableSetOf()

    fun unlocks(entity: Entity) {
        unlocks.add(entity)
        entity.unlockedBy(this)
    }

    fun requires(requiredScience: Science) = requires.add(requiredScience)

    fun costs(count: ProductCount) = costs.add(count)

    fun getUnlocks(): Set<Entity> = unlocks

    fun getRequires(): Set<Science> = requires

    fun getConsts(): Set<ProductCount> = costs

    override fun toShortString() = "Science $name"

    override fun toString(): String {
        return "Science $name requires ${if(requires.isEmpty()) "nothing" else requires.map(Science::toShortString)}, unlocks ${unlocks.map(Entity::toShortString)}, costs $costs"
    }

    override fun equals(other: Any?) = kotlinEquals(other, arrayOf(Science::name))

    override fun hashCode() = Objects.hash(name)
}