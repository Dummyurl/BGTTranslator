package com.borisruzanov.btgtranslator.TextTranslationPackage;


import DatabasePackage.SharedPreferencesManager;

public class ModelImpl implements ModelInterface {
    SharedPreferencesManager sharedPreferencesManager = new SharedPreferencesManager();

    @Override
    public void saveInputTextInSharedPreferences() {
        sharedPreferencesManager.saveSharedPreferencesForInputText(Contract.getInputText());
    }
}
