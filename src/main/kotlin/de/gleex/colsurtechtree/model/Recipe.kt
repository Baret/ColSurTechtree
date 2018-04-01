package de.gleex.colsurtechtree.model

import au.com.console.kassava.kotlinEquals
import java.util.*

data class Recipe(val forProduct: ProductCount, val needs: Set<ProductCount>) {
    override fun toString(): String {
        var s = "$forProduct"
        if(!needs.isEmpty()) {
            s += " (needs $needs)"
        }
        return s
    }

    override fun equals(other: Any?) = kotlinEquals(other, arrayOf(Recipe::forProduct))

    override fun hashCode() = Objects.hash(forProduct)
}
