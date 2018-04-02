package de.gleex.colsurtechtree.model

import au.com.console.kassava.kotlinEquals
import java.util.*

class Building(override val name: String) : Entity() {

    private val produced: MutableSet<Recipe> = mutableSetOf()

    fun produces(recipe: Recipe) {
        produced.add(recipe)
        recipe.forProduct.product.producedBy(this)
    }

    override fun toString() = "Building $name produces $produced"

    override fun equals(other: Any?) = kotlinEquals(other, arrayOf(Building::name))

    override fun hashCode() = Objects.hash(name)
}