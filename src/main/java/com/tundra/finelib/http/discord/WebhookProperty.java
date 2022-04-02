package com.tundra.finelib.http.discord;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * Property Data class
 */
public class WebhookProperty {
    /**
     * null Property
     */
    public WebhookProperty() {
        this.content = "Hi!";
        this.username = null;
        this.avatar_url = null;
        this.embeds = null;
    }

    /**
     * Property set All
     *
     * @param content    content
     * @param username   userName
     * @param avatar_url Avatar
     * @param embeds     Embed List
     */
    public WebhookProperty(@Nonnull String content, String username, String avatar_url, List<Embed> embeds) {
        this.content = content;
        this.username = username;
        this.avatar_url = avatar_url;
        this.embeds = embeds;
    }

    private String content;
    private String username;
    private String avatar_url;
    private List<Embed> embeds;

    /**
     * content getter
     *
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * set content
     *
     * @param content content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * get Username
     *
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * set Username
     *
     * @param username username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * get avatar URL
     *
     * @return avatar URL
     */
    public String getAvatar_url() {
        return avatar_url;
    }

    /**
     * set avatar URL
     *
     * @param avatar_url avatar URL
     */
    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    /**
     * get EmbedList
     *
     * @return EmbedList
     */
    public List<Embed> getEmbeds() {
        return embeds;
    }

    /**
     * set EmbedList
     *
     * @param embeds EmbedList
     */
    public void setEmbeds(List<Embed> embeds) {
        this.embeds = embeds;
    }
}
