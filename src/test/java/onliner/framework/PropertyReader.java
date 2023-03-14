package onliner.framework;

import java.util.ResourceBundle;

public class PropertyReader {

  public static String getTestData(String fileName, String key) {
    ResourceBundle resourceBundle = ResourceBundle.getBundle(fileName);
    return resourceBundle.getString(key);
  }
}
