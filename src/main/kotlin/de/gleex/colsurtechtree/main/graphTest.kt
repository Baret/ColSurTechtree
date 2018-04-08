package de.gleex.colsurtechtree.main

import com.mxgraph.layout.hierarchical.mxHierarchicalLayout
import com.mxgraph.layout.mxIGraphLayout
import com.mxgraph.swing.mxGraphComponent
import de.gleex.colsurtechtree.fulltree.fullTree
import de.gleex.colsurtechtree.model.Techtree
import org.jgrapht.Graph
import org.jgrapht.ext.JGraphXAdapter
import org.jgrapht.graph.DefaultEdge
import org.jgrapht.graph.SimpleGraph
import javax.swing.JFrame

fun main(args: Array<String>) {
    // JgraphT
    println("build JgraphT graph")
    fullTree()
    val g: Graph<String, DefaultEdge> = buildGraph()

    // JGraphX (other library)
    println("graph built, lets show it")

    val adapter = JGraphXAdapter<String, DefaultEdge>(g)

    showFrame(mxHierarchicalLayout(adapter), "hierarchical", adapter)

}

private fun showFrame(layout: mxIGraphLayout, title: String, adapter: JGraphXAdapter<String, DefaultEdge>) {
    layout.execute(adapter.defaultParent)

    val frame = JFrame(title)
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    val mxGraphComponent = mxGraphComponent(adapter)
    frame.contentPane.add(mxGraphComponent)
    frame.pack()
    frame.isVisible = true
}

fun buildGraph(): Graph<String, DefaultEdge> {
    val g: Graph<String, DefaultEdge> = SimpleGraph(DefaultEdge::class.java)
    for(s in Techtree.getSciences()) {
        println("Adding ${s.name} with ${s.getRequires().size} edges")
        g.addVertex(s.name)
        for(req in s.getRequires()) {
            g.addVertex(req.name)
            g.addEdge(req.name, s.name)
        }
    }
    return g
}
