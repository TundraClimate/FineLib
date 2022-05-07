package io.github.tundraclimate.finelib.database.file

import java.lang.IllegalArgumentException

/**
 * CSV wrapper
 */
data class CSVValue(val value: MutableList<String>) {

    /**
     * [value] getter
     */
    fun get(index: Int) = value[index]

    /**
     * [value] element setter
     *
     * @throws IllegalArgumentException invalid [values] size
     */
    fun set(vararg values: String) {
        if (value.size != values.size) throw IllegalArgumentException("invalid value to ${values.toList()}")
        values.forEachIndexed { index, s -> value[index] = s }
    }
}
