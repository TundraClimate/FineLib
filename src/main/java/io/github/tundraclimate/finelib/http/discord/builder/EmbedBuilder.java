package io.github.tundraclimate.finelib.http.discord.builder;

import io.github.tundraclimate.finelib.http.discord.Embed;

import java.util.List;

/**
 * Build Embed of Webhook
 */
public class EmbedBuilder {
    private final Embed embeds = new Embed();

    /**
     * Title setter
     *
     * @param title Title
     * @return this
     */
    public EmbedBuilder setTitle(String title) {
        embeds.setTitle(title);
        return this;
    }

    /**
     * Color setter
     *
     * @param color Color
     * @return this
     */
    public EmbedBuilder setColor(int color) {
        embeds.setColor(color);
        return this;
    }

    /**
     * URL setter
     *
     * @param url URL
     * @return this
     */
    public EmbedBuilder setURL(String url) {
        embeds.setUrl(url);
        return this;
    }

    /**
     * Description setter
     *
     * @param description Description
     * @return this
     */
    public EmbedBuilder setDescription(String description) {
        embeds.setDescription(description);
        return this;
    }

    /**
     * Author setter
     *
     * @param author Author
     * @return this
     */
    public EmbedBuilder setAuthor(Embed.Author author) {
        embeds.setAuthor(author);
        return this;
    }

    /**
     * Fields setter
     *
     * @param fields FieldList
     * @return this
     */
    public EmbedBuilder setFields(List<Embed.Field> fields) {
        embeds.setFields(fields);
        return this;
    }

    /**
     * Image Setter
     *
     * @param image Image
     * @return this
     */
    public EmbedBuilder setImage(String image) {
        embeds.setImage(image);
        return this;
    }

    /**
     * Thumbnail setter
     *
     * @param thumbnail Thumbnail
     * @return this
     */
    public EmbedBuilder setThumbnail(Embed.Thumbnail thumbnail) {
        embeds.setThumbnail(thumbnail);
        return this;
    }

    /**
     * Footer setter
     *
     * @param footer Footer
     * @return this
     */
    public EmbedBuilder setFooter(Embed.Footer footer) {
        embeds.setFooter(footer);
        return this;
    }

    /**
     * Embeds Getter
     *
     * @return Embed
     */
    public Embed getEmbeds() {
        return embeds;
    }
}
