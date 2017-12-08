package DatabasePackage;

import android.content.Context;
import android.content.SharedPreferences;

import com.borisruzanov.btgtranslator.TextTranslationPackage.Contract;

public class SharedPreferencesManager {

    Context context;

    public void saveSharedPreferencesForInputText(String translatedTextInput) {
        SharedPreferences mSettings = context.getSharedPreferences(Contract.SHARED_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = mSettings.edit();
        ed.putString(Contract.INPUT_TEXT, Contract.getInputText());
        ed.apply();
    }
}
