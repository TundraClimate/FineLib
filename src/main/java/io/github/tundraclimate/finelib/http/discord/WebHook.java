package io.github.tundraclimate.finelib.http.discord;

import com.google.gson.Gson;
import io.github.tundraclimate.finelib.FineLib;
import io.github.tundraclimate.finelib.http.discord.builder.WebHookPropertyBuilder;
import org.bukkit.Bukkit;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * Discord WebHook Sender
 */
public class WebHook {
    private String webhookURL = null;
    private HttpURLConnection connection = null;

    /**
     * set WebhookURL
     *
     * @param webhookURL Webhook URL to send
     */
    public WebHook(@Nonnull String webhookURL) {
        if (!webhookURL.isEmpty()) {
            this.webhookURL = webhookURL;
            try {
                connection = (HttpURLConnection) new URL(webhookURL).openConnection();
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setRequestProperty("User-Agent", "Mozilla/5.0 (X11; U; Linux i686) Gecko/20071127 Firefox/2.0.0.11");
                connection.setDoOutput(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * set Post Property
     *
     * @param property Property
     */
    public void setProperty(WebhookProperty property) {
        try (OutputStream os = connection.getOutputStream()) {
            os.write(new Gson().toJson(property).getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * set Post Property
     *
     * @param builder Property Builder
     */
    public void setProperty(WebHookPropertyBuilder builder) {
        try (OutputStream os = connection.getOutputStream()) {
            os.write(new Gson().toJson(builder.getWebhookProperty()).getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Posting Message to Webhook
     */
    public void postWebHook() {
        Bukkit.getScheduler().runTaskAsynchronously(FineLib.getPlugin(), () -> {
            try {
                connection.getInputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * WebhookURL getter
     *
     * @return WebhookURL
     */
    public String getWebhookURL() {
        return webhookURL;
    }
}
