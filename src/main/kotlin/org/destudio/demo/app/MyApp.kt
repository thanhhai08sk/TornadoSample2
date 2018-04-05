package org.destudio.demo.app

import io.objectbox.BoxStore
import io.objectbox.kotlin.boxFor
import javafx.scene.control.TextField
import javafx.scene.layout.VBox
import org.destudio.demo.view.MainView
import tornadofx.*

class HelloWorld : View() {
    override val root = VBox()
    lateinit var noteTitle: TextField
    lateinit var noteText: TextField
    val boxStore: BoxStore = MyObjectBox.builder().name("myBox-db").build()

    init {
        root.apply {
            hbox {
                label("Title")
                noteTitle = textfield()
            }
            hbox {
                label("Text")
                noteText = textfield()
            }
            button("LOGIN") {
                useMaxWidth = true
                action {
                    hello()
                }
            }

            form {
                label("Hello label")
            }
        }

//        val boxStore = MyObjectBox.Builder
    }

    fun hello() {
        val box = boxStore.boxFor(Note::class)
        box.removeAll()
        box.put(Note(title = "Title here", text = "This is text of the note", extra = "Extra"))
        println("box size = ${box.count()}")
        println("note = ${box.all.firstOrNull()}")
    }
}

class MyApp : App(MainView::class, Styles::class) {
    override val primaryView = HelloWorld::class
}