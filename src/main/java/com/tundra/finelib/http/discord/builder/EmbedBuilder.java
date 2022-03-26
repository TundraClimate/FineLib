package com.tundra.finelib.http.discord.builder;

import com.tundra.finelib.http.discord.EmbedField;

import java.util.*;

/**
 * Build Embed of Webhook
 */
public class EmbedBuilder {
    private final Map<String, Object> embeds = new HashMap<>();

    /**
     * set Title of Embed
     *
     * @param title Title of Embed
     * @return this
     */
    public EmbedBuilder setTitle(String title) {
        if (embeds.containsKey("title")) return this;
        embeds.put("title", title);
        return this;
    }

    /**
     * set Color of Embed
     *
     * @param colorCode ColorCode of the Color to Embed
     * @return this
     */
    public EmbedBuilder setColor(String colorCode) {
        if (embeds.containsKey("color")) return this;
        embeds.put("color", String.valueOf(Integer.parseInt(colorCode, 16)));
        return this;
    }

    /**
     * set URL of Embed
     *
     * @param url URL of Embed
     * @return this
     */
    public EmbedBuilder setEmbedURL(String url) {
        if (!embeds.containsKey("title")) return this;
        if (embeds.containsKey("url")) return this;
        embeds.put("url", url);
        return this;
    }

    /**
     * set Description of Embed
     *
     * @param description Description of Embed
     * @return this
     */
    public EmbedBuilder setDescription(String description) {
        if (embeds.containsKey("description")) return this;
        embeds.put("description", description);
        return this;
    }

    /**
     * set info of the Author of Embed
     *
     * @param name    Author Name
     * @param url     URL of Author of Embed
     * @param iconUrl Author Icon of Embed
     * @return this
     */
    public EmbedBuilder setAuthor(String name, String url, String iconUrl) {
        if (embeds.containsKey("author")) return this;
        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        map.put("url", url);
        map.put("icon_url", iconUrl);
        embeds.put("author", map);
        return this;
    }

    /**
     * set info of the Author of Embed
     *
     * @param name    Author Name
     * @param iconUrl Author Icon of Embed
     * @return this
     */
    public EmbedBuilder setAuthor(String name, String iconUrl) {
        if (embeds.containsKey("author")) return this;
        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        map.put("icon_url", iconUrl);
        embeds.put("author", map);
        return this;
    }

    /**
     * set info of the Author of Embed
     *
     * @param name Author Name
     * @return this
     */
    public EmbedBuilder setAuthor(String name) {
        if (embeds.containsKey("author")) return this;
        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        embeds.put("author", map);
        return this;
    }

    /**
     * set Fields of Embed
     *
     * @param fields Fields of Embed
     * @return this
     */
    public EmbedBuilder setFields(EmbedField... fields) {
        if (embeds.containsKey("fields")) return this;
        List<EmbedField> fieldJson = Arrays.asList(fields);
        embeds.put("fields", fieldJson);
        return this;
    }

    /**
     * set Image of Embed
     *
     * @param url Image of Embed
     * @return this
     */
    public EmbedBuilder setImage(String url) {
        if (embeds.containsKey("image")) return this;
        embeds.put("image", Collections.singletonMap("url", url));
        return this;
    }

    /**
     * set Thumbnail Image of Embed
     *
     * @param url Thumbnail URL
     * @return this
     */
    public EmbedBuilder setThumbnail(String url) {
        if (embeds.containsKey("thumbnail")) return this;
        embeds.put("thumbnail", Collections.singletonMap("url", url));
        return this;
    }

    /**
     * set Footer of Embed
     *
     * @param text    Footer Text
     * @param iconUrl URL of Footer Icon
     * @return this
     */
    public EmbedBuilder setFooter(String text, String iconUrl) {
        if (embeds.containsKey("footer")) return this;
        Map<String, String> footer = new HashMap<>();
        footer.put("text", text);
        footer.put("icon_url", iconUrl);
        embeds.put("footer", footer);
        return this;
    }

    /**
     * set Footer of Embed
     *
     * @param text Footer Text
     * @return this
     */
    public EmbedBuilder setFooter(String text) {
        if (embeds.containsKey("footer")) return this;
        embeds.put("footer", Collections.singletonMap("text", text));
        return this;
    }

    /**
     * set TimeStamp of Embed
     *
     * @param timeStamp TimeStamp of Embed
     * @return this
     */
    public EmbedBuilder setTimeStamp(String timeStamp) {
        if (embeds.containsKey("timestamp")) return this;
        embeds.put("timestamp", timeStamp);
        return this;
    }

    /**
     * get EmbedsMap
     *
     * @return EmbedsMap
     */
    public Map<String, Object> getEmbeds() {
        return embeds;
    }
}
