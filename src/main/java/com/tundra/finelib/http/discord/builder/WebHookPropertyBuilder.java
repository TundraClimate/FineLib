package com.tundra.finelib.http.discord.builder;

import javax.annotation.Nonnull;
import java.util.*;

/**
 * Build Webhook Property
 */
public class WebHookPropertyBuilder {
    private final Map<String, Object> postMap = new HashMap<>();

    /**
     * set Content of Sending
     *
     * @param content Content of Sending
     * @return this
     */
    public WebHookPropertyBuilder setContent(@Nonnull String content) {
        if (postMap.containsKey("content")) return this;
        String cont = content.length() <= 2000 ? content : content.substring(0, 2000);
        postMap.put("content", cont);
        return this;
    }

    /**
     * set UserName of Webhook
     *
     * @param userName UserName of Webhook
     * @return this
     */
    public WebHookPropertyBuilder setUserName(String userName) {
        if (postMap.containsKey("username")) return this;
        String user = userName.length() <= 32 ? userName : userName.substring(0, 32);
        postMap.put("username", user);
        return this;
    }

    /**
     * set UserAvatar of Webhook
     *
     * @param avatarURL UserAvatar of Webhook
     * @return this
     */
    public WebHookPropertyBuilder setAvatarURL(String avatarURL) {
        if (postMap.containsKey("avatar_url")) return this;
        postMap.put("avatar_url", avatarURL);
        return this;
    }

    /**
     * set Embeds of Message to Send
     *
     * @param builder EmbedBuilder
     * @return this
     */
    public WebHookPropertyBuilder setEmbeds(EmbedBuilder... builder) {
        if (postMap.containsKey("embeds")) return this;
        if (builder.length > 10) return this;
        List<Map<String, Object>> mapList = new ArrayList<>();
        Arrays.stream(builder).forEach(embed -> mapList.add(embed.getEmbeds()));
        postMap.put("embeds", mapList);
        return this;
    }

    /**
     * get PostMap
     *
     * @return PostMap
     */
    public Map<String, Object> getPostMap() {
        return postMap;
    }
}
