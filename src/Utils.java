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
}
