package com.borisruzanov.btgtranslator.TextTranslationPackage.text_translate_module;

import android.util.Log;

import com.borisruzanov.btgtranslator.TextTranslationPackage.Contract;
import com.borisruzanov.btgtranslator.TextTranslationPackage.services.http.CallBack;
import com.borisruzanov.btgtranslator.TextTranslationPackage.services.http.IHttpService;

import com.borisruzanov.btgtranslator.TextTranslationPackage.database.IPreferencesManager;

public class TextPresenter implements ITextPresenter {

    private IPreferencesManager iPreferenceManager;
    private IHttpService httpService;
    private IUiCallBack uiCallBack;
    public TextPresenter(IPreferencesManager iPreferenceManager, IHttpService httpService, IUiCallBack uiCallBack) {
        this.iPreferenceManager = iPreferenceManager;
        this.httpService = httpService;
        this.uiCallBack=uiCallBack;
    }

    @Override
    public void saveInputTextInSharedPreferences(final String text) {
        Log.v(Contract.TAG, "TextPresenter - In saveInputTextInSharedPreferences");
        iPreferenceManager.saveSharedPreferencesForInputText(text);
        httpService.translateText(iPreferenceManager.getLanguage(), text, new CallBack<String>() {
            @Override
            public void call(String item) {
                uiCallBack.textTranslated(text,item);
            }
        });
    }
}
