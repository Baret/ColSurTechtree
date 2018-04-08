# DSL to define techtree and production lines

This project is written in Kotlin. This offers the possibility to create a simple DSL that describes production dependencies of the game Colony Survival.

**Example:**
```
  job("Berry Farmer") {
        worksIn("Berryfarm") {
            produces("Berry Seed")
            produces("Berries") {
                needs("Berry Seed")
            }
        }
    }

    job("Forester") {
        worksIn("Forest") {
            produces(2, "Log") {
                needs("Sapling")
            }
            produces("Sapling")
        }
    }

    science("Bread Production") {
        unlocksJobs("Farmer", "Miller", "Baker")
    }
```

This snippet creates *buildings*, *jobs*, *products* and *science*. These are all entities saved in a singleton *techtree* object. It can be written to the console via `println(Techtree)`. The output would be:

```
Full techtree:
	Jobs (5):
		Job Baker (assignable buildings: [])
		Job Berry Farmer (assignable buildings: [Building Berryfarm produces [1 Berry Seed, 1 Berries (needs [1 Berry Seed])]])
		Job Farmer (assignable buildings: [])
		Job Forester (assignable buildings: [Building Forest produces [2 Log (needs [1 Sapling]), 1 Sapling]])
		Job Miller (assignable buildings: [])
	Buildings (2):
		Building Berryfarm produces [1 Berry Seed, 1 Berries (needs [1 Berry Seed])]
		Building Forest produces [2 Log (needs [1 Sapling]), 1 Sapling]
	Products (4):
		Product Berries
		Product Berry Seed
		Product Log
		Product Sapling
	Science (1):
		Science Bread Production requires nothing, unlocks [Job Farmer (assignable buildings: []), Job Miller (assignable buildings: []), Job Baker (assignable buildings: [])]
```
