package com.tundra.finelib.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Create Randomizer
 * @param <E> Output classType
 */
public class Randomizer<E> {
    List<E> table = new ArrayList<>();

    /**
     * add Random Element
     * @param element adding Element
     */
    public void addElement(E element) {
        table.add(element);
    }

    /**
     * remove Random Element
     * @param e Removed Element
     */
    public void removeElement(E e) {
        if (table.isEmpty()) return;
        table.remove(e);
    }

    /**
     * Random LootTable getter
     * @return Loot
     */
    public List<E> getTable() {return table;}

    /**
     * Randomize
     * @return Random Element
     */
    public E getRandom() {
        if (table.isEmpty()) return null;
        return table.get(new Random().nextInt(0, table.size()-1));
    }
}
