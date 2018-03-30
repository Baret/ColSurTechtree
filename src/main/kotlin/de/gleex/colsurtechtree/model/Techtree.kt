package de.gleex.colsurtechtree.model

object Techtree {

    private val buildings: MutableSet<Building> = mutableSetOf()
    private val products: MutableSet<Product> = mutableSetOf()

    fun addBuildings(vararg buildings: Building) = this.buildings.addAll(buildings)
    fun addProducts(vararg products: Product) = this.products.addAll(products)

    override fun toString(): String {
        var str = "Full techtree:\n"
        str += "\tBuildings (${buildings.size}):\n"
        for(b in buildings) {
            str += "\t\t$b\n"
        }
        str += "\tProducts (${products.size}):\n"
        for(p in products) {
            str += "\t\t$p\n"
        }
        return str
    }
}