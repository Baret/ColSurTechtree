package de.gleex.colsurtechtree.parser

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import de.gleex.colsurtechtree.model.*
import java.io.BufferedReader
import java.io.File

/**
 * Parses JSON files which contain recipes. That's the common gamedata.
 */
class JsonRecipeParser {

	fun parse(jsonFile: File): Job {
		val bufferedReader: BufferedReader = jsonFile.bufferedReader()
		val inputString = bufferedReader.use { it.readText() }
		return parse(inputString)
	}

	fun parse(json: String): Job {
		val gameRecipes: Array<JsonRecipe> = parseData(json)

		val buildings = convertToBuildings(*gameRecipes)

		val job = Techtree.getJob("Laborer")
		job.addAssignableBuildings(*buildings)
		return job
	}

	private fun parseData(json: String): Array<JsonRecipe> = jacksonObjectMapper().readValue(json)

	private fun convertToBuildings(vararg recipes: JsonRecipe): Array<Building> {
		var buildings: Array<Building> = arrayOf()
		for (recipe in recipes) {
			val buildingName = getBuildingName(recipe.name)
			val building = Techtree.getBuilding(buildingName)
			buildings += building
			addRecipe(building, recipe)
		}
		return buildings
	}

	// get the middle part of 'pipliz.building.item'
	fun getBuildingName(recipeName: String): String {
		val firstDotIndex = recipeName.indexOf('.')
		val lastDotIndex = recipeName.indexOf('.', firstDotIndex + 1)
		return recipeName.substring(firstDotIndex + 1, lastDotIndex)
	}

	fun addRecipe(building: Building, json: JsonRecipe) {
		// at the moment only a single entity can be the result, so we add multipe recipes
		for (jsonResult in json.results) {
			val forProduct = toModel(jsonResult)
			val needs = json.requires.map(::toModel).toSet()
			val recipe = Recipe(forProduct, needs)
			building.produces(recipe)
		}
	}

	fun toModel(json: JsonIngredient): ProductCount {
		return ProductCount(json.amount, Techtree.getProduct(json.type))
	}

}

// only for testing
fun main(args: Array<String>) {
	//val jsonFile = File("src/test/resources/baking.json")
	val jsonFile = File("src/test/resources/metalsmithing.json")
	val job = JsonRecipeParser().parse(jsonFile)
	println(job)
	
    println(Techtree)

}
