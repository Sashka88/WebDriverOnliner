package onliner.services;

import java.util.ResourceBundle;

public class OnlinerTvData {
  private ResourceBundle resourceBundle;

  public OnlinerTvData() {
    this.resourceBundle = ResourceBundle.getBundle("tvFilterTestData");
  }

  public String getTestData(String key) {
    return resourceBundle.getString(key);
  }
}
