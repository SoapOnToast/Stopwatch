import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesManager {
    private static PropertiesManager instance;
    private final Properties props;
    private PropertiesManager() {
        props = new Properties();
        String filePath = "config.properties";
        loadProperties(filePath);
    }
    private void loadProperties(String filePath) {
        try (InputStream inputStream = Utils.class.getClassLoader().getResourceAsStream(filePath))
        {
            props.load(inputStream);
        }
        catch (IOException e){
            System.err.println("Error loading properties file: " + e.getMessage());
        }
    }
    public String getStr(String property){
        return this.props.getProperty(property);
    }
    public int getInt(String property){
        return Integer.parseInt(props.getProperty(property));
    }
    public Image getImage(String property){
        String icon_path = props.getProperty(property);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource(icon_path));
        if (icon != null){
            return icon;
        }
        throw new IllegalArgumentException("Error loading image: " + icon_path);
    }
    public Color getColor(String property){
        String hex_color = props.getProperty(property);
        return Utils.hexToColor(hex_color);
    }
    public Font getFont(String property){
        String font_file_name = props.getProperty(property+".name");
        int font_size = getInt(property+".size");
        return Utils.loadCustomFont(font_file_name, font_size);
    }
    public Font getFont(String property, int font_size){
        String font_file_name = props.getProperty(property+".name");
        return Utils.loadCustomFont(font_file_name, font_size);
    }
    public static PropertiesManager getInstance() {
        if (instance == null) {
            instance = new PropertiesManager();
        }
        return instance;
    }
}
