package de.gleex.colsurtechtree.model

import au.com.console.kassava.kotlinEquals
import java.util.*

class Building(override val name: String) : Entity {

    private val produced: MutableMap<Product, Int> = mutableMapOf()

    fun produces(count: Int, product: Product) {
        produced[product] = count
        product.producedBy(this)
    }

    override fun toString() = "Building $name produces $produced"

    override fun equals(other: Any?) = kotlinEquals(other, arrayOf(Building::name))

    override fun hashCode() = Objects.hash(name)
}