package io.github.tundraclimate.finelib.database.file

import java.io.File
import java.lang.IllegalArgumentException

/**
 * load .csv
 */
class CSVLoader(val file: File) {
    private val lines = file.readLines()

    /**
     * check extension
     */
    init {
        if (file.isDirectory || file.extension != "csv") throw IllegalArgumentException("invalid file to ${file.path}")
    }

    /**
     * select CSV Line
     *
     * @return CSV Value of [line]
     */
    fun select(line: Int): CSVValue = CSVValue(lines[line].split(",").toMutableList())

    /**
     * select All CSV Line
     *
     * @return List of All line
     */
    fun selectAll(): List<CSVValue> {
        val values = mutableListOf<CSVValue>()
        lines.indices.forEach {
            values.add(select(it))
        }
        return values
    }

    /**
     * [column] contain a [value]?
     */
    fun contain(column: Int, value: String): Boolean {
        var isContain = false
        forEach {
            val array = it.split(",")
            if (array[column] == value) isContain = true
        }
        return isContain
    }

    fun forEach(action: (String) -> Unit) {
        lines.forEach(action)
    }
}