package de.gleex.colsurtechtree.model.interfaces

import de.gleex.colsurtechtree.model.Product

abstract class Producing {

    protected val produced: MutableMap<Product, Int> = mutableMapOf()

    fun produces(count: Int, product: Product) {
        produced.put(product, count)
        println("setting produced by")
        product.producedBy(this)
    }

    override fun toString() = "produces $produced"
}