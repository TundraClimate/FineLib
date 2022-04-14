package io.github.tundraclimate.finelib.http.discord.builder;

import io.github.tundraclimate.finelib.http.discord.Embed;
import io.github.tundraclimate.finelib.http.discord.WebhookProperty;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * Build Webhook Property
 */
public class WebHookPropertyBuilder {
    private final WebhookProperty webhookProperty = new WebhookProperty();

    /**
     * set Content of Sending
     *
     * @param content Content of Sending
     * @return this
     */
    public WebHookPropertyBuilder setContent(@Nonnull String content) {
        String cont = content.length() <= 2000 ? content : content.substring(0, 2000);
        webhookProperty.setContent(cont);
        return this;
    }

    /**
     * set UserName of Webhook
     *
     * @param userName UserName of Webhook
     * @return this
     */
    public WebHookPropertyBuilder setUserName(String userName) {
        String user = userName.length() <= 32 ? userName : userName.substring(0, 32);
        webhookProperty.setUsername(user);
        return this;
    }

    /**
     * set UserAvatar of Webhook
     *
     * @param avatarURL UserAvatar of Webhook
     * @return this
     */
    public WebHookPropertyBuilder setAvatarURL(String avatarURL) {
        webhookProperty.setAvatar_url(avatarURL);
        return this;
    }

    /**
     * set Embeds of Message to Send
     *
     * @param embeds Embeds
     * @return this
     */
    public WebHookPropertyBuilder setEmbeds(List<Embed> embeds) {
        if (embeds.size() > 10) throw new IllegalArgumentException("embeds is max 10");
        webhookProperty.setEmbeds(embeds);
        return this;
    }

    /**
     * Property Getter
     *
     * @return Webhook Property
     */
    public WebhookProperty getWebhookProperty() {
        return webhookProperty;
    }
}
