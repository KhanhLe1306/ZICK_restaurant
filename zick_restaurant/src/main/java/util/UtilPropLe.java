package util;

import java.util.Properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class UtilPropLe {
   static final boolean _W = System.getProperty("os.name").toLowerCase().contains("windows");
   static String _PROP_FILENAME_WIN_LOCAL = "C:\\Users\\khanh\\Desktop\\UNO-Courses\\CSCI-4830 Intro to Software Engineering\\TermProject4830\\zick_restaurant\\src\\main\\webapp\\config.properties";
   static String _PROP_FILENAME_OSX_LOCAL = "/Users/khanhlee/4830/workspace4830/workspaceCSCI-4830-ex-0211-Le/webproject-ex-0211-Le/src/main/webapp/config.properties";
   // * Remote server path
   static String _PROP_FILENAME_REMOTE = "/var/lib/tomcat7/webapps/zick_restaurant/config.properties";
   static Properties prop = new Properties();

   public static void loadProperty() throws Exception {
	   //System.out.println("inside UtilProp.loadProperty()");
      FileInputStream inputStream = null;
      if (_W) {
         if (new File(_PROP_FILENAME_WIN_LOCAL).exists()) {
        	//System.out.println("inside prop_filename_remote win_local");
            //System.out.println("[DBG] Loaded: " + new File(_PROP_FILENAME_WIN_LOCAL).getAbsolutePath());
            inputStream = new FileInputStream(_PROP_FILENAME_WIN_LOCAL);
         }
      } else {
         if (new File(_PROP_FILENAME_OSX_LOCAL).exists()) {
        	System.out.println("inside prop_filename_remote osx_local");
            System.out.println("[DBG] Loaded: " + new File(_PROP_FILENAME_OSX_LOCAL).getAbsolutePath());
            inputStream = new FileInputStream(_PROP_FILENAME_OSX_LOCAL);
         }
      }
      
      if (new File(_PROP_FILENAME_REMOTE).exists()) {
    	 System.out.println("inside prop_filename_remote");
         System.out.println("[DBG] Loaded: " + new File(_PROP_FILENAME_REMOTE).getAbsolutePath());
         inputStream = new FileInputStream(_PROP_FILENAME_REMOTE);
      }
      if (inputStream == null) {
         throw new FileNotFoundException();
      }
      prop.load(inputStream);
   }

   public static String getProp(String key) {
      return prop.getProperty(key).trim();
   }
}
