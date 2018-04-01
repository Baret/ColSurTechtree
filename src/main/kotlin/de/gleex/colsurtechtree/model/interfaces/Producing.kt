package de.gleex.colsurtechtree.model.interfaces

import de.gleex.colsurtechtree.model.Entity
import de.gleex.colsurtechtree.model.Product

abstract class Producing: Entity {

    protected val produced: MutableMap<Product, Int> = mutableMapOf()

    fun produces(count: Int, product: Product) {
        produced.put(product, count)
        product.producedBy(this)
    }

    override fun toString() = "produces $produced"
}