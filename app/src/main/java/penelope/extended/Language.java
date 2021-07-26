package penelope.extended;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.prefs.Preferences;

/**
 * Provides multi-language support.
 */
public class Language {

    // Available languages
    public static Map<String, String> available = new HashMap<String, String>();

    // Same as the system by default
    public static String lang = "same_as_the_system";

    // Dictionary
    private static Map<Integer, String> dict = new HashMap<Integer, String>();

    // User preferences
    private static Preferences preferences = Preferences.userRoot();
    
    /**
     * <p> Initialize the language related things.
     * <p> Currently the following values are supported: same_as_the_system, en, es.
     * @throws IOException
     */
    public static void init() throws IOException{
        // Reads the language preference
        lang = preferences.get("penelope_extended_language", lang);
        // Same as the system?
        if (lang.equals("same_as_the_system")){
            lang = Locale.getDefault().getLanguage();
            // Only supported languages
            boolean c1 = lang.equals("en");
            boolean c2 = lang.equals("es");
            // If it is not supported, then select english
            if (!c1 && !c2){
                lang = "en";
            }
        }
        // Fill dictionary
        dict.put(0, "PENELOPE Extended")
        if (lang.equals("en")){
            dict.put(-1, "Same as the system");
            dict.put(-2, "English");
            dict.put(-3, "Spanish");
            dict.put(1, "Language");
            dict.put(2, "You need to restart the application");
        }
        else if (lang.equals("es")){
            dict.put(-1, "Igual que el sistema");
            dict.put(-2, "Inglés");
            dict.put(-3, "Español");
            dict.put(1, "Idioma");
            dict.put(2, "Necesita reiniciar la aplicación");
        }
        // Fill available languages map
        available.put("same_as_the_system", dict.get(-1));
        available.put("en", dict.get(-2));
        available.put("es", dict.get(-3));
    }

    /**
     * Get text in the selected language.
     * @param i (int) Text index.
     */
    public static String get(int i){
        return dict.get(i);
    }
}
