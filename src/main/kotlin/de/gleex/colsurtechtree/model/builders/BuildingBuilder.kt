package de.gleex.colsurtechtree.model.builders

import de.gleex.colsurtechtree.dsl.TechtreeDsl
import de.gleex.colsurtechtree.model.Building
import de.gleex.colsurtechtree.model.Techtree

@TechtreeDsl
class BuildingBuilder(name: String) {
    private val building = Techtree.getBuilding(name)

    fun build(): Building {
        return building
    }

    fun produces(productName: String) {
        produces(1, productName)
    }

    fun produces(count: Int = 1, productName: String, recipeBlock: RecipeBuilder.() -> Unit = {}) {
        val recipe = RecipeBuilder(productName, count).apply(recipeBlock).build()
        building.produces(recipe)
    }
}
