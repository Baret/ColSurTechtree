package de.gleex.colsurtechtree.parser

data class JsonIngredient(
		val type: String,
		val amount: Int = 1
)

data class JsonRecipe(
		val name: String,
		val results: Array<JsonIngredient>,
		val requires: Array<JsonIngredient>,
		val defaultLimit: Int,
		val defaultPriority: Int,
		val isOptional: Boolean
)
