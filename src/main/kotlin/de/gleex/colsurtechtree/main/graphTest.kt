package de.gleex.colsurtechtree.main

import com.mxgraph.layout.hierarchical.mxHierarchicalLayout
import com.mxgraph.layout.mxIGraphLayout
import com.mxgraph.swing.mxGraphComponent
import com.mxgraph.view.mxGraph
import de.gleex.colsurtechtree.fulltree.fullTree
import de.gleex.colsurtechtree.model.*
import org.jgrapht.Graph
import org.jgrapht.ext.JGraphXAdapter
import org.jgrapht.graph.DefaultEdge
import org.jgrapht.graph.SimpleGraph
import javax.swing.JFrame

fun main(args: Array<String>) {
    // JgraphT
    println("build JgraphT graph")
    fullTree()
    val g: Graph<Entity, EntityEdge> = buildGraph()


    // JGraphX (other library)
    println("graph built, lets show it")

    val adapter = TechtreeGraph(g)

    showFrame(mxHierarchicalLayout(adapter), "hierarchical", adapter)

}

private fun showFrame(layout: mxIGraphLayout, title: String, adapter: JGraphXAdapter<Entity, EntityEdge>) {
    layout.execute(adapter.defaultParent)

    val frame = JFrame(title)
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    val mxGraphComponent = MyGraphComponent(adapter)
    frame.contentPane.add(mxGraphComponent)
    frame.pack()
    frame.extendedState = frame.extendedState or JFrame.MAXIMIZED_BOTH
    frame.isVisible = true
}

class MyGraphComponent(graph: mxGraph) : mxGraphComponent(graph) {
    override fun isEditing(): Boolean {
        return super.isEditing()
    }
}

fun buildGraph(): Graph<Entity, EntityEdge> {
    val g: Graph<Entity, EntityEdge> = SimpleGraph(EntityEdge::class.java)
    for(s in Techtree.getSciences()) {
        println("Adding ${s.name} with ${s.getRequires().size} edges")
        g.addVertex(s)
        for(req in s.getRequires()) {
            g.addVertex(req)
            g.addEdge(req, s)
        }
    }
    return g
}

class EntityEdge: DefaultEdge() {
    override fun toString(): String {
        return when (source) {
            is Science -> "unlocks"
            is Building -> "produces"
            is Job -> "works in"
            is Product -> "produced by"
            else -> super.toString()
        }
    }
}

class TechtreeGraph(g: Graph<Entity, EntityEdge>) : JGraphXAdapter<Entity, EntityEdge>(g) {
    override fun convertValueToString(cell: Any?): String {
        val value = model.getValue(cell)
        return if(value is Entity) {
            value.name
        } else {
            super.convertValueToString(cell)
        }
    }
}
