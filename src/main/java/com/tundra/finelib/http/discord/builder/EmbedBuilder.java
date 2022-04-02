package com.tundra.finelib.http.discord.builder;

import com.tundra.finelib.http.discord.Embed;

import java.util.List;

/**
 * Build Embed of Webhook
 */
public class EmbedBuilder {
    private final Embed embeds = new Embed();

    public EmbedBuilder setTitle(String title) {
        embeds.setTitle(title);
        return this;
    }

    public EmbedBuilder setColor(int color) {
        embeds.setColor(color);
        return this;
    }

    public EmbedBuilder setURL(String url) {
        embeds.setUrl(url);
        return this;
    }

    public EmbedBuilder setDescription(String description) {
        embeds.setDescription(description);
        return this;
    }

    public EmbedBuilder setAuthor(Embed.Author author) {
        embeds.setAuthor(author);
        return this;
    }

    public EmbedBuilder setFields(List<Embed.Field> fields) {
        embeds.setFields(fields);
        return this;
    }

    public EmbedBuilder setImage(String image) {
        embeds.setImage(image);
        return this;
    }

    public EmbedBuilder setThumbnail(Embed.Thumbnail thumbnail) {
        embeds.setThumbnail(thumbnail);
        return this;
    }

    public EmbedBuilder setFooter(Embed.Footer footer) {
        embeds.setFooter(footer);
        return this;
    }

    public Embed getEmbeds() {
        return embeds;
    }
}
