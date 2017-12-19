package com.borisruzanov.btgtranslator.TextTranslationPackage.choose_language;

import com.borisruzanov.btgtranslator.TextTranslationPackage.database.IPreferencesManager;

public class ChooseLanguageInteractor implements IChooseLanguageInteractor {
    private IPreferencesManager iPreferenceManager;

    public ChooseLanguageInteractor(IPreferencesManager iPreferenceManager) {
        this.iPreferenceManager = iPreferenceManager;
    }

    @Override
    public void putLanguagesInSharedPreferences(String shortLanguage, String longLanguage) {
        iPreferenceManager.saveSharedPreferencesForLanguages(shortLanguage,longLanguage);
    }
}
