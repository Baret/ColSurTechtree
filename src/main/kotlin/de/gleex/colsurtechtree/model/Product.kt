package de.gleex.colsurtechtree.model

import au.com.console.kassava.kotlinEquals
import java.util.*

class Product(override val name: String): Entity {

    private val producedBy: MutableSet<Building> = mutableSetOf()

    fun producedBy(producing: Building) {
        if(!producedBy.contains(producing)) {
            producedBy.add(producing)
        }
    }

    override fun toString() = "Product $name"

    override fun equals(other: Any?) = kotlinEquals(other, arrayOf(Product::name))

    override fun hashCode() = Objects.hash(name)
}
