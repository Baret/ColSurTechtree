@file:Suppress("UNCHECKED_CAST")

package de.gleex.colsurtechtree.model

object Techtree {

    private val buildings: MutableSet<Building> = mutableSetOf()
    private val products: MutableSet<Product> = mutableSetOf()
    private val jobs: MutableSet<Job> = mutableSetOf()
    private val sciences: MutableSet<Science> = mutableSetOf()

    override fun toString(): String {
        var str = "Full techtree:\n"
        str += textBlock("Jobs", jobs.toList())
        str += textBlock("Buildings", buildings.toList())
        str += textBlock("Products", products.toList())
        str += textBlock("Science", sciences.toList())
        return str
    }

    private fun textBlock(description: String, set: List<Entity>): String {
        var str1 = "\t$description (${set.size}):\n"
        for (p in set.sortedBy(Entity::name)) {
            str1 += "\t\t$p\n"
        }
        return str1
    }

    fun getProduct(productName: String): Product =
            getEntity(products as MutableSet<Entity>, productName, {Product(productName)}) as Product

    fun getJob(jobName: String): Job =
            getEntity(jobs as MutableSet<Entity>, jobName, {Job(jobName)}) as Job

    fun getBuilding(buildingName: String): Building =
            getEntity(buildings as MutableSet<Entity>, buildingName, {Building(buildingName)}) as Building

    fun getScience(scienceName: String): Science =
            getEntity(sciences as MutableSet<Entity>, scienceName, {Science(scienceName)}) as Science

    private fun getEntity(set: MutableSet<Entity>, name: String, newObjectProvider: () -> Entity): Entity {
        val entity = set.find { it.name == name }
        return if (entity != null) {
            entity
        } else {
            val newObject = newObjectProvider.invoke()
            set.add(newObject)
            newObject
        }
    }

    fun getSciences(): Set<Science> = sciences

    fun getBuildings(): Set<Building> = buildings

    fun getJobs(): Set<Job> = jobs

    fun getProducts(): Set<Product> = products
}