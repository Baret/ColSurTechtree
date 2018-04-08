package de.gleex.colsurtechtree.main

import com.mxgraph.swing.mxGraphComponent
import org.jgrapht.Graph
import org.jgrapht.ext.JGraphXAdapter
import org.jgrapht.graph.DefaultEdge
import org.jgrapht.graph.SimpleGraph
import javax.swing.JFrame

fun main(args: Array<String>) {
    // JgraphT
    println("build JgraphT graph")
    val g: Graph<String, DefaultEdge> = SimpleGraph(DefaultEdge::class.java)
    g.addVertex("Farm")
    g.addVertex("Wheat")
    g.addEdge("Farm", "Wheat")

    // JGraphX (other library)
    println("graph built, lets show it")

    val foo = JGraphXAdapter<String, DefaultEdge>(g)

    val frame = JFrame("JGraphX test")
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    val mxGraphComponent = mxGraphComponent(foo)
    frame.contentPane.add(mxGraphComponent)
    frame.isVisible = true


}