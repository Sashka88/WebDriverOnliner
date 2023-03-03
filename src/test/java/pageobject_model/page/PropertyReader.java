package pageobject_model.page;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    public static String tv;
    public static String price;
    public static String diagonalfrom;
    public static String diagonalto;
    public static String resolution;
    public static String titleCatalogPage;
    public static String titleTvPage;
    public static void propertyConfig(String args[]) {
        FileInputStream fis;
        Properties property = new Properties();
        try {
            fis = new FileInputStream("src/test/resources/tvFilterTestData.properties");
            property.load(fis);

            tv = property.getProperty("testdata.tvMaker");
            price = property.getProperty("testdata.price");
            diagonalfrom = property.getProperty("testdata.diagonalfrom");
            diagonalto = property.getProperty("testdata.diagonalto");
            resolution = property.getProperty("testdata.resolution");
            titleCatalogPage = property.getProperty("testdata.catalogtitle");
            titleTvPage = property.getProperty("testdata.tvtitle");
            System.out.println(tv);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
