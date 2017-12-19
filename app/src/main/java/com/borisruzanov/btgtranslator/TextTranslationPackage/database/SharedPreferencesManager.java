package com.borisruzanov.btgtranslator.TextTranslationPackage.database;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.borisruzanov.btgtranslator.TextTranslationPackage.Contract;

import static com.borisruzanov.btgtranslator.TextTranslationPackage.Contract.LANGUAGE_LONG;
import static com.borisruzanov.btgtranslator.TextTranslationPackage.Contract.LANGUAGE_SHORT;

public class SharedPreferencesManager implements IPreferencesManager {

    SharedPreferences mSettings;
    SharedPreferences shortLanguage;

    public SharedPreferencesManager(Context context,String shortLanguage) {
        this.mSettings =  context.getSharedPreferences(Contract.SHARED_PREFERENCES, Context.MODE_PRIVATE);
        this.shortLanguage = context.getSharedPreferences(Contract.LANGUAGE_SHORT, Context.MODE_PRIVATE);
    }

    @Override
    public void saveSharedPreferencesForInputText(String translatedTextInput) {
        Log.v(Contract.TAG, "SharedPreferencesManager - In saveSharedPreferencesForInputText " + translatedTextInput.toString());
        SharedPreferences.Editor ed = mSettings.edit();
        ed.putString(Contract.INPUT_TEXT, translatedTextInput);
        ed.apply();
    }

    @Override
    public void saveSharedPreferencesForLanguages(String shortLanguage, String longLanguage) {
        Log.v(Contract.TAG, "SharedPreferencesManager - In saveSharedPreferencesForLanguages " + shortLanguage + longLanguage);
        SharedPreferences.Editor ed = mSettings.edit();
        ed.putString(LANGUAGE_LONG, longLanguage);
        ed.putString(LANGUAGE_SHORT, shortLanguage);
        ed.apply();
    }

    @Override
    public String getShortLanguage() {
        return mSettings.getString(Contract.LANGUAGE_SHORT,"");//DEFAULT
    }

    @Override
    public String getLongLanguage() {
        return mSettings.getString(Contract.LANGUAGE_LONG,"");//DEFAULT
    }

    @Override
    public String getTextForInputField() {
        return mSettings.getString(Contract.INPUT_TEXT,"");//DEFAULT
    }

    @Override
    public void cleanFields() {
        SharedPreferences.Editor ed = mSettings.edit();
        ed.remove(Contract.INPUT_TEXT);
        ed.remove(Contract.OUTPUT_TEXT);
        ed.apply();
    }

    @Override
    public void saveSharedPreferencesForOutputText(String outputText) {
        SharedPreferences.Editor ed = mSettings.edit();
        ed.putString(Contract.OUTPUT_TEXT, outputText);
        ed.apply();
        Log.v("Tag", "output preference = " + outputText);
    }

    @Override
    public String getTextForOutputField() {
        return mSettings.getString(Contract.OUTPUT_TEXT,"");//DEFAULT
    }
}
