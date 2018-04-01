package de.gleex.colsurtechtree.model

import au.com.console.kassava.kotlinEquals
import java.util.*

data class ProductCount(val count: Int, val product: Product) {
    override fun toString(): String = "$count ${product.name}"

    override fun equals(other: Any?) = kotlinEquals(other, arrayOf(ProductCount::product))

    override fun hashCode() = Objects.hash(product)
}
