package DatabasePackage;

/**
 * Created by Boris on 12/7/2017.
 */

public interface IPreferencesManager {
    void saveSharedPreferencesForInputText(String translatedTextInput);

    String getLanguage();
    void  setLanguage(String language);

}
