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

    fun getProduct(productName: String): Product {
        val product = products.find { it.name == productName }
        return if (product == null) {
            val newProduct = Product(productName)
            products.add(newProduct)
            newProduct
        } else {
            product
        }
    }

    fun getJob(jobName: String): Job {
        val job = jobs.find { it.name == jobName }
        return if (job == null) {
            val newJob = Job(jobName)
            jobs.add(newJob)
            newJob
        } else {
            job
        }
    }

    fun getBuilding(buildingName: String): Building {
        val building = buildings.find { it.name == buildingName }
        return if (building == null) {
            val newBuilding = Building(buildingName)
            buildings.add(newBuilding)
            newBuilding
        } else {
            building
        }
    }

}