package com.borisruzanov.btgtranslator.TextTranslationPackage.database;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.borisruzanov.btgtranslator.TextTranslationPackage.Contract;

public class SharedPreferencesManager implements IPreferencesManager {

    SharedPreferences mSettings;

    public SharedPreferencesManager(Context context) {
        this.mSettings =  context.getSharedPreferences(Contract.SHARED_PREFERENCES, Context.MODE_PRIVATE);
    }

    @Override
    public void saveSharedPreferencesForInputText(String translatedTextInput) {
        Log.v(Contract.TAG, "SharedPreferencesManager - In saveSharedPreferencesForInputText " + translatedTextInput.toString());
        SharedPreferences.Editor ed = mSettings.edit();
        ed.putString(Contract.INPUT_TEXT, translatedTextInput);
        ed.apply();
    }

    @Override
    public String getLanguage() {
        return mSettings.getString(Contract.Language,"en");//DEFAULT
    }

    @Override
    public void setLanguage(String language) {
        SharedPreferences.Editor ed = mSettings.edit();
        ed.putString(Contract.Language, language);
        ed.apply();
    }
}
