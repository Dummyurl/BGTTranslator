package com.borisruzanov.btgtranslator.TextTranslationPackage.text_translate_module;


public interface ITextInteractor {
    void saveTextInputInSharedPreferences(String textInput);
    String getLongLanguageFromSharedPreferences();
    String getInputTextFromSharedPreferences();
    void callCleanerFromSharedPreferenceManager();
    void saveTextOutputInSharedPreferences(String outputText);

    String getOutputTextFromSharedPreferences();
}
