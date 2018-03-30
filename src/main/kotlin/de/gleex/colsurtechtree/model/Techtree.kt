package de.gleex.colsurtechtree.model

object Techtree {

    private val buildings: MutableSet<Building> = mutableSetOf()
    private val products: MutableSet<Product> = mutableSetOf()
    private val jobs: MutableSet<Job> = mutableSetOf()

    fun addBuildings(vararg buildings: Building) = this.buildings.addAll(buildings)
    fun addProducts(vararg products: Product) = this.products.addAll(products)
    fun addJobs(vararg jobs: Job) = this.jobs.addAll(jobs)

    override fun toString(): String {
        var str = "Full techtree:\n"
        str += textBlock("Jobs", jobs)
        str += textBlock("Buildings", buildings)
        str += textBlock("Products", products)
        return str
    }

    private fun textBlock(description: String, set: Set<Any>): String {
        var str1 = "\t$description (${set.size}):\n"
        for (p in set) {
            str1 += "\t\t$p\n"
        }
        return str1
    }
}