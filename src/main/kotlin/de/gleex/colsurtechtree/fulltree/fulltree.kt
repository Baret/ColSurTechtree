package de.gleex.colsurtechtree.fulltree

import de.gleex.colsurtechtree.dsl.*

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
    job("Berry Farmer") {
    }
    job("Flax Farmer") {
    }
    job("Alkanet Farmer") {
    }
    job("Hollyhock Farmer") {
    }
    job("Wolfsbane Farmer") {
    }
    job("Forester") {
    }
    job("Laborer") {
        // baking.json
        worksIn("Baker") {
            produces(2, "Bread") {
                needs(5, "Flour")
                needs("Firewood")
            }
        }
        // bloomery.json
        worksIn("Bloomery") {
            produces("Iron ingot") {
                needs("Iron ore")
                needs("Charcoal")
            }
            produces("Lead") {
                needs("Galena lead")
                needs("Charcoal")
            }
            produces("Silver ingot"/*, "Crystal"*/) {
                needs("Galena silver")
                needs("Charcoal")
            }
            // TODO same as above, but multiple outputs are currently not supported
            produces(/*"Silver ingot", */"Crystal") {
                needs("Galena silver")
                needs("Charcoal")
            }
        }
        // dyeing.json
        worksIn("Dyer") {
            produces(4, "Quarterblock black") {
                needs(4, "Quarterblock grey")
                needs("Charcoal")
            }
            produces(4, "Quarterblock white") {
                needs(4, "Quarterblock grey")
                needs("Gypsum")
            }
            produces(5, "Planks red") {
                needs(5, "Planks")
                needs(3, "Hollyhock")
            }
            produces(5, "Planks green") {
                needs(5, "Planks")
                needs(2, "Alkanet")
                needs(2, "Wolfsbane")
            }
            produces(5, "Planks cyan") {
                needs(5, "Planks")
                needs(2, "Alkanet")
                needs(1, "Wolfsbane")
            }
            produces(5, "Planks blue") {
                needs(5, "Planks")
                needs(3, "Alkanet")
            }
            produces(5, "Planks yellow") {
                needs(5, "Planks")
                needs(3, "Wolfsbane")
            }
            produces(5, "Planks pink") {
                needs(5, "Planks")
                needs(2, "Alkanet")
                needs(2, "Hollyhock")
            }
            produces(5, "Planks grey") {
                needs(5, "Planks")
                needs("Charcoal")
                needs(2, "Gypsum")
            }
            produces(5, "Red planks") {
                needs(5, "Coated planks")
                needs(3, "Hollyhock")
            }
            produces(5, "Black planks") {
                needs(5, "Coated planks")
                needs(2, "Charcoal")
            }
            produces(5, "Carpet red") {
                needs(5, "Carpet white")
                needs(3, "Hollyhock")
            }
            produces(5, "Carpet blue") {
                needs(5, "Carpet white")
                needs(3, "Alkanet")
            }
            produces(5, "Carpet yellow") {
                needs(5, "Carpet white")
                needs(3, "Wolfsbane")
            }
            produces(5, "Stonebricks white") {
                needs(5, "Stonebricks")
                needs(5, "Gypsum")
            }
            produces(5, "Stonebricks black") {
                needs(5, "Stonebricks")
                needs("Charcoal")
            }
            produces("Lantern white") {
                needs("Lantern yellow")
                needs(3, "Gypsum")
            }
            produces("Lantern green") {
                needs("Lantern yellow")
                needs("Alkanet")
                needs("Wolfsbane")
            }
            produces("Lantern blue") {
                needs("Lantern yellow")
                needs(2, "Alkanet")
            }
            produces("Lantern red") {
                needs("Lantern yellow")
                needs(2, "Hollyhock")
            }
            produces("Lantern orange") {
                needs("Lantern yellow")
                needs("Hollyhock")
                needs("Wolfsbane")
            }
            produces("Lantern cyan") {
                needs("Lantern yellow")
                needs(2, "Alkanet")
                needs("Wolfsbane")
            }
            produces("Lantern pink") {
                needs("Lantern yellow")
                needs("Alkanet")
                needs("Hollyhock")
            }
            produces(5, "Cobblestone red") {
                needs(5, "Cobblestone grey")
                needs(2, "Hollyhock")
            }
        }
        // fineryforge.json
        worksIn("Finery Forge") {
            produces("Steel ingot") {
                needs(2, "Iron wrought")
                needs("Cokes")
            }
            produces("Gold ingot") {
                needs("Gold ore")
                needs("Cokes")
            }
        }
        // grinding.json
        worksIn("Grinder") {
            produces(2, "Flour") {
                needs(2, "Wheat")
            }
        }
        // gunsmith.json
        worksIn("Gunsmith") {
            produces(3, "Lead bullet") {
                needs("Lead")
            }
            produces("Gunpowder") {
                needs("Salpeter")
                needs("Charcoal")
            }
            produces(3, "Gunpowder pouch") {
                needs("Gunpowder")
                needs(3, "Linen pouch")
            }
            produces("Matchlockgun") {
                needs(3, "Steel parts")
                needs("Coated planks")
                needs("Copper parts")
            }
        }
        // kiln.json
        worksIn("Kiln") {
            produces(2, "Charcoal") {
                needs(7, "Firewood")
            }
            produces(2, "Cokes") {
                needs("Coal ore")
                needs(2, "Firewood")
            }
        }
    }
    job("Wheat Farmer") {
    }
}