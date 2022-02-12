package prisoners_red_blue_hats;

import java.util.Random;

/**
 * Hat has a color
 * <p>
 * Red or Blue
 */
public enum HatColor {
    RED("RED"),
    BLUE("BLUE"),
    ;

    /**
     * String value of the enum values
     */
    private final String colorString;

    /**
     * Constructs an enum object
     *
     * @param colorString string value
     */
    HatColor(String colorString) {
        this.colorString = colorString;
    }

    /**
     * Makes a random color and returns it
     *
     * @return a random color
     */
    public static HatColor randomColor() {
        return (new Random().nextInt(2) == 0 ? RED : BLUE);
    }

    /**
     * Returns the string value of the enum object
     *
     * @return the string value of the enum object
     */
    public String getColorString() {
        return colorString;
    }
}
