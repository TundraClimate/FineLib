package io.github.tundraclimate.finelib.http;

/**
 * It supports hexadecimal and decimal color codes
 */
public enum ColorCode {
    /**
     * ColorCode of RED
     */
    RED("ff0000"),
    /**
     * ColorCode of BLUE
     */
    BLUE("0000ff"),
    /**
     * ColorCode of YELLOW
     */
    YELLOW("ffff00"),
    /**
     * ColorCode of GREEN
     */
    GREEN("008000"),
    /**
     * ColorCode of CYAN
     */
    CYAN("00ffff"),
    /**
     * ColorCode of PURPLE
     */
    PURPLE("800080"),
    /**
     * ColorCode of MAGENTA
     */
    MAGENTA("ff00ff"),
    /**
     * ColorCode of PINK
     */
    PINK("ffc0cb"),
    /**
     * ColorCode of ORANGE
     */
    ORANGE("ff4500"),
    /**
     * ColorCode of DARK_RED
     */
    DARK_RED("8b0000"),
    /**
     * ColorCode of DARK_BLUE
     */
    DARK_BLUE("00008b"),
    /**
     * ColorCode of LIME
     */
    LIME("00ff00"),
    /**
     * ColorCode of GRAY
     */
    GRAY("808080"),
    /**
     * ColorCode of WHITE
     */
    WHITE("ffffff"),
    /**
     * ColorCode of Black
     */
    BLACK("000000"),
    /**
     * ColorCode of GOLD
     */
    GOLD("ffd700");

    private final String colorCode;

    /**
     * Init Color
     *
     * @param color colorCode
     */
    ColorCode(String color) {
        this.colorCode = color;
    }

    /**
     * Hexadecimal ColorCode Getter
     *
     * @return Hexadecimal ColorCode
     */
    public String getHexadecimal() {
        return colorCode;
    }

    /**
     * Decimal ColorCode Getter
     *
     * @return Decimal ColorCode
     */
    public int getDecimal() {
        return Integer.parseInt(this.colorCode, 16);
    }
}
