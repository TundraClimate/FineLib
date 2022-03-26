package com.tundra.finelib.http.discord;

/**
 * EmbedField of JavaObject
 */
public class EmbedField {
    private final String name;
    private final String value;
    private final boolean inline;

    /**
     * construct EmbedField
     *
     * @param name   Field Name
     * @param value  Field Value
     * @param inline is Field Inline
     */
    public EmbedField(String name, String value, boolean inline) {
        this.name = name;
        this.value = value;
        this.inline = inline;
    }

    /**
     * construct EmbedField
     *
     * @param name  Field Name
     * @param value Field Value
     */
    public EmbedField(String name, String value) {
        this.name = name;
        this.value = value;
        this.inline = false;
    }
}
