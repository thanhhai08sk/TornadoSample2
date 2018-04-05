package org.destudio.demo.app

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
data class Note(
        @Id var id: Long = 0,
        val title: String,
        val text: String,
        val extra: String
)