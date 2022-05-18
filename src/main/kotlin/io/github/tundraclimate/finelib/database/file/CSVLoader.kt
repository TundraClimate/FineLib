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
     * select [column] values
     */
    fun selectColumn(column: String): List<String>? {
        val columns = lines[0].split(",")
        if (!columns.contains(column)) return null
        val index = columns.indexOf(column)
        val values = mutableListOf<String>()
        lines.forEach {
            val split = it.split(",")
            values.add(split[index])
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