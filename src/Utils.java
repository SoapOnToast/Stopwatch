import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class Utils {
    public static Font loadCustomFont(String fontFileName, int size) {
        try (InputStream inputStream = Utils.class.getClassLoader().getResourceAsStream(fontFileName)) {
            assert inputStream != null;
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, inputStream);
            return customFont.deriveFont(Font.PLAIN, size);
        } catch (IOException | FontFormatException e) {
            System.err.println("Error loading custom font: " + e.getMessage());
            return null;
        }
    }
    public static Color hexToColor(String hexColor){
        return new Color(
                Integer.valueOf(hexColor.substring(1, 3), 16), // Red
                Integer.valueOf(hexColor.substring(3, 5), 16), // Green
                Integer.valueOf(hexColor.substring(5, 7), 16)  // Blue
        );
    }
}
