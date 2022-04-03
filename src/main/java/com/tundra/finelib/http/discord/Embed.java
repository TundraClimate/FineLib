package com.tundra.finelib.http.discord;

import java.util.List;

/**
 * Embed Data class
 */
public class Embed {
    private String title;
    private int color;
    private String url;
    private String description;
    private Author author;
    private List<Field> fields;
    private String image;
    private Thumbnail thumbnail;
    private Footer footer;

    /**
     * Title getter
     *
     * @return Title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Title setter
     *
     * @param title Title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Color getter
     *
     * @return Color
     */
    public int getColor() {
        return color;
    }

    /**
     * Color setter
     *
     * @param color Color
     */
    public void setColor(int color) {
        this.color = color;
    }

    /**
     * URL getter
     *
     * @return URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * URL setter
     *
     * @param url URL
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Description getter
     *
     * @return Description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Description setter
     *
     * @param description Description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Author getter
     *
     * @return Author
     */
    public Author getAuthor() {
        return author;
    }

    /**
     * Author setter
     *
     * @param author Author
     */
    public void setAuthor(Author author) {
        this.author = author;
    }

    /**
     * Fields getter
     *
     * @return Fields
     */
    public List<Field> getFields() {
        return fields;
    }

    /**
     * Fields setter
     *
     * @param fields Fields
     */
    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    /**
     * Image getter
     *
     * @return Image
     */
    public String getImage() {
        return image;
    }

    /**
     * Image setter
     *
     * @param image Image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Thumbnail getter
     *
     * @return Thumbnail
     */
    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    /**
     * Thumbnail setter
     *
     * @param thumbnail Thumbnail
     */
    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    /**
     * Footer getter
     *
     * @return Footer
     */
    public Footer getFooter() {
        return footer;
    }

    /**
     * Footer setter
     *
     * @param footer Footer
     */
    public void setFooter(Footer footer) {
        this.footer = footer;
    }

    /**
     * Embed isEmpty
     *
     * @return isEmpty
     */
    public boolean isEmpty() {
        return title == null && color == 0 && url == null && description == null && author == null && fields.isEmpty() && image == null && thumbnail == null && footer == null;
    }

    /**
     * Author Data class
     */
    public static class Author {
        /**
         * init
         *
         * @param name     name
         * @param url      url
         * @param icon_url icon
         */
        public Author(String name, String url, String icon_url) {
            this.name = name;
            this.url = url;
            this.icon_url = icon_url;
        }

        private final String name;
        private final String url;
        private final String icon_url;
    }

    /**
     * Field Data class
     */
    public static class Field {
        /**
         * construct EmbedField
         *
         * @param name   Field Name
         * @param value  Field Value
         * @param inline is Field Inline
         */
        public Field(String name, String value, boolean inline) {
            this.name = name;
            this.value = value;
            this.inline = inline;
        }

        private final String name;
        private final String value;
        private final boolean inline;
    }

    /**
     * Thumbnail Data class
     */
    public static class Thumbnail {
        /**
         * init
         *
         * @param url url
         */
        public Thumbnail(String url) {
            this.url = url;
        }

        private final String url;
    }

    /**
     * Footer Data class
     */
    public static class Footer {
        /**
         * init
         *
         * @param text     text
         * @param icon_url icon
         */
        public Footer(String text, String icon_url) {
            this.text = text;
            this.icon_url = icon_url;
        }

        private final String text;
        private final String icon_url;
    }
}
