package de.gleex.colsurtechtree.model

abstract class Entity {
    abstract val name: String
    protected val unlockedBy: MutableSet<Science> = mutableSetOf()

    fun unlockedBy(science: Science) {
        unlockedBy.add(science)
    }

}
