package com.tundra.finelib.http.discord;

import java.util.List;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Footer getFooter() {
        return footer;
    }

    public void setFooter(Footer footer) {
        this.footer = footer;
    }

    public static class Author{
        public Author(String name, String url, String icon_url){
            this.name = name;
            this.url = url;
            this.icon_url = icon_url;
        }
        private final String name;
        private final String url;
        private final String icon_url;
    }
    public static class Field{
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
    public static class Thumbnail{
        public Thumbnail(String url) {
            this.url = url;
        }
        private final String url;
    }
    public static class Footer{
        public Footer(String text, String icon_url) {
            this.text = text;
            this.icon_url = icon_url;
        }
        private final String text;
        private final String icon_url;
    }
}
