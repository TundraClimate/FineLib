package io.github.tundraclimate.finelib.util.container;

import io.github.tundraclimate.finelib.FineLib;
import org.bukkit.NamespacedKey;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import javax.annotation.Nonnull;

/**
 * DataContainer Utility
 */
public class DataContainer {
    /**
     * Container set Data
     *
     * @param container Container to put data
     * @param key       Data Key
     * @param type      Data Type
     * @param name      Data Name
     * @param <T>       Param Type
     * @param <Z>       Param Type
     */
    public static <T, Z> void setDataContainer(
            @Nonnull PersistentDataContainer container,
            @Nonnull String key,
            @Nonnull PersistentDataType<T, Z> type,
            @Nonnull Z name) {
        NamespacedKey nameKey = new NamespacedKey(FineLib.getPlugin(), key);
        container.set(nameKey, type, name);
    }

    /**
     * Container get Data
     *
     * @param container Container to get data
     * @param key       Data key
     * @param type      Data type
     * @param <T>       Param Type
     * @param <Z>       Param Type
     * @return Data associated with the key
     */
    public static <T, Z> Z getDataContainer(
            @Nonnull PersistentDataContainer container,
            @Nonnull String key,
            @Nonnull PersistentDataType<T, Z> type) {
        return container.get(new NamespacedKey(FineLib.getPlugin(), key), type);
    }

    /**
     * Container to check if there is data
     *
     * @param container Container to check data
     * @param key       Data key
     * @param type      Data Type
     * @param <T>       Data Param
     * @param <Z>       Data Param
     * @return result of check
     */
    public static <T, Z> boolean hasDataContainer(
            @Nonnull PersistentDataContainer container,
            @Nonnull String key,
            @Nonnull PersistentDataType<T, Z> type
    ) {
        return container.has(new NamespacedKey(FineLib.getPlugin(), key), type);
    }

    /**
     * Container remove Data
     *
     * @param container Container to remove data
     * @param key       Data key
     * @param <T>       Data Param
     * @param <Z>       Data Param
     */
    public static <T, Z> void removeDataContainer(
            @Nonnull PersistentDataContainer container,
            @Nonnull String key
    ) {
        container.remove(new NamespacedKey(FineLib.getPlugin(), key));
    }
}
