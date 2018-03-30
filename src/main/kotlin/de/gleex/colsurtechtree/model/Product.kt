package de.gleex.colsurtechtree.model

import au.com.console.kassava.kotlinEquals
import de.gleex.colsurtechtree.model.interfaces.Producing
import java.util.*

class Product(val name: String) {

    private val producedBy: MutableSet<Producing> = mutableSetOf()

    fun getProducedBy() = setOf(producedBy)

    init {
        Techtree.addProducts(this)
    }

    fun producedBy(producing: Producing) {
        if(!producedBy.contains(producing)) {
            producedBy.add(producing)
        }
    }

    override fun toString() = "Product $name"

    override fun equals(other: Any?) = kotlinEquals(other, arrayOf(Product::name))

    override fun hashCode() = Objects.hash(name)
}
