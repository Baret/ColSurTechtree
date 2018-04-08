package de.gleex.colsurtechtree.fulltree

import de.gleex.colsurtechtree.dsl.science

// This function will create the (possibly) full tech/production tree of colony survival
fun fullTree() {
    // Science
    science("Bread Production") {
        unlocksJobs("Wheat Farmer", "Miller", "Baker")
    }
    science("Bronze Anvil") {
        unlocksJobs("Bronzesmith")
    }
    science("Flax Farming") {
        unlocksJobs("Flax Farmer")
    }
    science("Tailor") {
        requires("Flax Farming")
        unlocksJobs("Tailor")
    }
    science("Technologist") {
        requires("Tailor")
        unlocksJobs("Technologist")
    }
    science("Basic Science Bag") {
        requires("Technologist")
        // TODO: unlocks product
    }
    science("Digger") {
        requires("Basic Science Bag")
        unlocksJobs("Construction Worker")
    }
    science("Kiln") {
        requires("Basic Science Bag")
        unlocksJobs("Charburner")
    }
    science("Splitting Stump") {
        requires("Basic Science Bag")
        unlocksJobs("Lumberjack")
    }
    science("Stonemason's Workshop") {
        requires("Basic Science Bag")
        unlocksJobs("Stonemason")
    }
    science("Herb Farming") {
        requires("Basic Science Bag")
        unlocksJobs("Herb Farmer")
    }
    science("Mints & Shops") {
        requires("Basic Science Bag")
        unlocksJobs("Trader", "Coiner")
    }
    science("Archery") {
        requires("Bronze Anvil", "Flax Farming")
        unlocksJobs("Archer")
    }
    science("Bloomery") {
        requires("Kiln")
        unlocksJobs("Iron Smelter")
    }
    science("Wooden Quarter Block") {
        requires("Splitting Stump")
    }
    science("Dyer's Table") {
        requires("Herb Farming")
        unlocksJobs("Dyer")
    }
    science("Grey Quarter Blocks") {
        requires("Stonemason's Workshop")
    }
    science("Finery Forge") {
        requires("Bloomery")
        unlocksJobs("Goldsmith")
    }
    science("Lanterns") {
        requires("Bloomery")
    }
    science("Life Science Bag") {
        requires("Technologist", "Bread Production")
    }
    science("Military Science Bag") {
        requires("Technologist", "Bloomery", "Archery")
    }
    science("Digger Limit I") {
        requires("Digger")
    }
    science("Builder") {
        requires("Digger", "Stonemason's Workbench")
    }

    // Jobs
}