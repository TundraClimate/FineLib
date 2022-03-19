package com.tundra.finelib.util;

import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Bidirectional Base64 Encoding
 */
public class Base64Connector {
    /**
     * Object Convert to ByteArray
     *
     * @param obj Converting Object
     * @return ByteArray
     */
    public static byte[] ObjectToByteArray(Object obj) {
        try (ByteArrayOutputStream os = new ByteArrayOutputStream();
             BukkitObjectOutputStream bos = new BukkitObjectOutputStream(os)) {
            bos.writeObject(obj);
            return os.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * ByteArray Convert to Object
     *
     * @param byteArray Converting ByteArray
     * @return Convert Object
     */
    public static Object ByteArrayToObject(byte[] byteArray) {
        try (ByteArrayInputStream is = new ByteArrayInputStream(byteArray);
             BukkitObjectInputStream bis = new BukkitObjectInputStream(is)) {
            return bis.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * String Convert to Object
     *
     * @param str Converting String
     * @return Convert Object
     */
    public static Object StringToObject(String str) {
        try (ByteArrayInputStream is = new ByteArrayInputStream(Base64Coder.decodeLines(str));
             BukkitObjectInputStream bis = new BukkitObjectInputStream(is)) {
            return bis.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
