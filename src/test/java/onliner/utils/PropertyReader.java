package onliner.utils;

import java.util.ResourceBundle;

public class PropertyReader {

  public static String getTestData(String key) {
    ResourceBundle resourceBundle = ResourceBundle.getBundle("tvFilterTestData");
    return resourceBundle.getString(key);
  }
}
