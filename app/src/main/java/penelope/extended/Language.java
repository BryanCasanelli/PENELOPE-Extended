package penelope.extended;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Provides multi-language support.
 */
public class Language {

    // Available languages
    public static Map<String, String> available = new HashMap<String, String>();

    // English by default
    private static String lang = "en";

    // Dictionary
    private static Map<Integer, String> dict = new HashMap<Integer, String>();
    
    /**
     * <p> Reads the language config file in search of the configured language.
     * <p> This file is located under the resources folder and is named "language".
     * <p> Currently the following values are supported: same_as_the_system, en, es.
     * @throws IOException
     */
    public static void init() throws IOException{
        // Reads the file
        String configFileContent = new String(App.class.getClassLoader().getResourceAsStream("language").readAllBytes());
        // Same as the system?
        if (configFileContent.equals("same_as_the_system")){
            configFileContent = Locale.getDefault().getLanguage();
        }
        // Support only permitted configurations
        boolean c1 = configFileContent.equals("en");
        boolean c2 = configFileContent.equals("es");
        if (c1 || c2){
            lang = configFileContent;
        }
        // Fill dictionary
        if (lang.equals("en")){
            dict.put(-1, "Same as the system");
            dict.put(-2, "English");
            dict.put(-3, "Spanish");
            dict.put(0, "Language");
        }
        else if (lang.equals("es")){
            dict.put(-1, "Igual que el sistema");
            dict.put(-2, "Inglés");
            dict.put(-3, "Español");
            dict.put(0, "Idioma");
        }
        // Fill available languages map
        available.put("en", dict.get(-1));
        available.put("es", dict.get(-2));
        available.put("same_as_the_system", dict.get(-3));
    }

    /**
     * Get text in the selected language.
     * @param i (int) Text index.
     */
    public static String get(int i){
        return dict.get(i);
    }
}
