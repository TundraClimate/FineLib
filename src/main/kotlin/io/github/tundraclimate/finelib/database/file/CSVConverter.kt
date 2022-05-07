package io.github.tundraclimate.finelib.database.file

import io.github.tundraclimate.finelib.FineLib
import java.io.File

/**
 * Convert String
 */
class CSVConverter(columnSize: Int, private vararg val columns: String) {
    val size: Int = columnSize
    private val csv = mutableListOf(columns.toList())

    /**
     * check size
     */
    init {
        if (columns.size != size) throw IllegalArgumentException("invalid columnSize")
    }

    /**
     * insert [value]
     */
    fun insertRecord(vararg value: String) {
        if (value.size != size) throw IllegalArgumentException("invalid ValueSize")
        csv.add(value.toList())
    }

    /**
     * insert [value]
     */
    fun insertRecord(vararg value: Any) {
        if (value.size != size) throw IllegalArgumentException("invalid ValueSize")
        val wrapValue = mutableListOf<String>()
        value.forEach { wrapValue.add(it.toString()) }
        csv.add(wrapValue)
    }

    /**
     * insert [value]
     */
    fun insertRecord(value: CSVValue) {
        if (value.value.size != size) throw IllegalArgumentException("invalid ValueSize")
        csv.add(value.value)
    }

    /**
     * drop [line]
     */
    fun dropRecord(line: Int) {
        if (line == 0) csv.removeAt(1)
        csv.removeAt(line)
    }

    /**
     * clear CSV
     */
    fun clear() {
        csv.clear()
        csv.add(columns.toList())
    }

    /**
     * to FileObject
     */
    fun toFile(name: String, dir: File = FineLib.getPlugin().dataFolder): File {
        var fileName = name
        if (File(fileName).extension != "csv") fileName = "$fileName.csv"
        val file = File(dir, fileName).absoluteFile
        file.writeText(toString())
        return file
    }

    /**
     * output csv
     */
    fun output(name: String, dir: File = FineLib.getPlugin().dataFolder) {
        toFile(name, dir).createNewFile()
    }

    override fun toString(): String = buildString {
        csv.forEach { list ->
            val column = list.toString()
            appendLine(column.substring(1, column.length - 1).replace(" ", ""))
        }
    }
}