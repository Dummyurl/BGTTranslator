package com.borisruzanov.btgtranslator.TextTranslationPackage.text_translate_module;

import android.util.Log;

import com.borisruzanov.btgtranslator.TextTranslationPackage.Contract;
import com.borisruzanov.btgtranslator.TextTranslationPackage.database.IPreferencesManager;
import com.borisruzanov.btgtranslator.TextTranslationPackage.services.http.CallBack;
import com.borisruzanov.btgtranslator.TextTranslationPackage.services.http.IHttpService;

public class TextInteractor implements ITextInteractor {

    private IPreferencesManager iPreferenceManager;
    private IHttpService httpService;
    private IUiCallBack uiCallBack;

    public TextInteractor(IPreferencesManager iPreferenceManager, IHttpService httpService, IUiCallBack uiCallBack) {
        this.iPreferenceManager = iPreferenceManager;
        this.httpService = httpService;
        this.uiCallBack=uiCallBack;
    }


    @Override
    public void saveTextInputInSharedPreferences(final String text) {
        Log.v(Contract.TAG, "TextPresenter - In forwardTextToInteractor");
        iPreferenceManager.saveSharedPreferencesForInputText(text);
        httpService.translateText(iPreferenceManager.getShortLanguage(), text, new CallBack<String>() {
            @Override
            public void call(String outputText) {
                uiCallBack.textTranslated(text,outputText);
                saveTextOutputInSharedPreferences(outputText);
            }
        });
    }

    @Override
    public void saveTextOutputInSharedPreferences(String outputText) {
        iPreferenceManager.saveSharedPreferencesForOutputText(outputText);
    }

    @Override
    public String getOutputTextFromSharedPreferences() {
        return iPreferenceManager.getTextForOutputField();
    }

    @Override
    public String getLongLanguageFromSharedPreferences() {
        return iPreferenceManager.getLongLanguage();
    }

    @Override
    public String getInputTextFromSharedPreferences() {
        return iPreferenceManager.getTextForInputField();

    }

    @Override
    public void callCleanerFromSharedPreferenceManager() {
        iPreferenceManager.cleanFields();
        uiCallBack.cleanTextFields();
    }


}
