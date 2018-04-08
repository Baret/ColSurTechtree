package de.gleex.colsurtechtree.main

import com.mxgraph.swing.mxGraphComponent
import com.mxgraph.view.mxGraph
import javax.swing.JFrame

fun main(args: Array<String>) {
    // JGraphX (other library)
    println("building mx graph")
    var mxGraph = mxGraph()
    var model = mxGraph.model
    try {
        model.beginUpdate()

        var a = mxGraph.insertVertex(mxGraph.defaultParent, null, "Farm", 10.0, 10.0, 50.0, 50.0)
        var b = mxGraph.insertVertex(mxGraph.defaultParent, null, "Bread", 10.0, 110.0, 50.0, 50.0)

        var edge = mxGraph.insertEdge(mxGraph.defaultParent, null, "produces", a, b)
    } finally {
        model.endUpdate()
    }
    println("graph built, lets show it")

    var frame = JFrame("JGraphX test")
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    frame.contentPane.add(mxGraphComponent(mxGraph))
    frame.isVisible = true

}