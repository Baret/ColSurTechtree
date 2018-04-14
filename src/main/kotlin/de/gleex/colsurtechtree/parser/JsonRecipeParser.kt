package de.gleex.colsurtechtree.parser

import com.fasterxml.jackson.module.kotlin.*
import de.gleex.colsurtechtree.model.Job
import de.gleex.colsurtechtree.model.Techtree
import de.gleex.colsurtechtree.model.Building
import java.io.File
import java.io.BufferedReader
import de.gleex.colsurtechtree.model.Recipe
import de.gleex.colsurtechtree.model.builders.RecipeBuilder
import de.gleex.colsurtechtree.model.ProductCount

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

	fun parseData(json: String): Array<JsonRecipe> {
		val mapper = jacksonObjectMapper()
		return mapper.readValue(json)
	}

	fun convertToBuildings(vararg recipes: JsonRecipe): Array<Building> {
		var buildings: Array<Building> = arrayOf()
		for (recipe in recipes) {
			val buildingName = getBuildingName(recipe.name)
			val building = Techtree.getBuilding(buildingName)
			buildings = buildings.plus(building)
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
			val needs = json.requires.map { r -> toModel(r) }.toSet()
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
