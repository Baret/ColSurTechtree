package de.gleex.colsurtechtree.model.builders

import de.gleex.colsurtechtree.dsl.TechtreeDsl
import de.gleex.colsurtechtree.model.ProductCount
import de.gleex.colsurtechtree.model.Recipe
import de.gleex.colsurtechtree.model.Techtree

@TechtreeDsl
class RecipeBuilder(productName: String, count: Int) {
    private val forProduct = ProductCount(count, Techtree.getProduct(productName))
    private val needs: MutableSet<ProductCount> = mutableSetOf()

    fun build(): Recipe {
        return Recipe(forProduct, needs)
    }

    fun needs(productName: String) {
        needs(1, productName)
    }

    fun needs(count: Int = 1, productName: String) {
        needs.add(ProductCount(count, Techtree.getProduct(productName)))
    }
}
