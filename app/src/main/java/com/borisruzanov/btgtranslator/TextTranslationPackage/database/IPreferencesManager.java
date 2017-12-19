package com.borisruzanov.btgtranslator.TextTranslationPackage.database;



public interface IPreferencesManager {
    void saveSharedPreferencesForInputText(String translatedTextInput);

    void saveSharedPreferencesForLanguages(String shortLanguage, String longLanguage);

    String getShortLanguage();

    String getLongLanguage();

    String getTextForInputField();

    void cleanFields();

    void saveSharedPreferencesForOutputText(String outputText);

    String getTextForOutputField();
}
