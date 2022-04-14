package io.github.tundraclimate.finelib.builder;

import org.bukkit.ChatColor;

/**
 * build ColorString
 */
public class ColorStringBuilder {
    private final StringBuilder builder;

    /**
     * set EarlyString
     *
     * @param string Early String
     */
    public ColorStringBuilder(String string) {
        this.builder = new StringBuilder(colorStringTranslate(string));
    }

    /**
     * String append
     *
     * @param addString append String
     * @return this
     */
    public ColorStringBuilder append(String addString) {
        this.builder.append(colorStringTranslate(addString));
        return this;
    }

    /**
     * insert String
     *
     * @param offset       insert offset
     * @param insertString insert String
     * @return this
     */
    public ColorStringBuilder insert(int offset, String insertString) {
        this.builder.insert(offset, colorStringTranslate(insertString));
        return this;
    }

    /**
     * delete String
     *
     * @param start start index
     * @param end   end index
     * @return this
     */
    public ColorStringBuilder delete(int start, int end) {
        this.builder.delete(start, end);
        return this;
    }

    /**
     * replace String
     *
     * @param start         start index
     * @param end           end index
     * @param replaceString replace String
     * @return this
     */
    public ColorStringBuilder replace(int start, int end, String replaceString) {
        this.builder.replace(start, end, colorStringTranslate(replaceString));
        return this;
    }

    /**
     * delete char at index
     *
     * @param index delete index
     * @return this
     */
    public ColorStringBuilder deleteCharAt(int index) {
        this.builder.deleteCharAt(index);
        return this;
    }

    @Override
    public String toString() {
        return builder.toString();
    }

    /**
     * private method
     * translate rawString
     *
     * @param rawStr raw String
     * @return translate String
     */
    private String colorStringTranslate(String rawStr) {
        return ChatColor.translateAlternateColorCodes('&', rawStr);
    }
}
