package com.borisruzanov.btgtranslator.TextTranslationPackage.text_translate_module;

import com.borisruzanov.btgtranslator.TextTranslationPackage.database.IPreferencesManager;
import com.borisruzanov.btgtranslator.TextTranslationPackage.services.http.IHttpService;

public class TextModel implements ITextModel{

    private IPreferencesManager _pm;
    private IHttpService httpService;
    private IUiCallBack uiCallBack;
    public TextModel (IPreferencesManager _pm, IHttpService httpService, IUiCallBack uiCallBack) {
        this._pm = _pm;
        this.httpService = httpService;
        this.uiCallBack=uiCallBack;
    }
//
//    @Override
//    public void saveTextInputInSharedPreferences(String textInput) {
//        Log.v(Contract.TAG, "TextPresenter - In saveInputTextInSharedPreferences");
//        _pm.saveSharedPreferencesForInputText(text);
//        httpService.translateText(_pm.getLanguage(), text, new CallBack<String>() {
//            @Override
//            public void call(String item) {
//                uiCallBack.textTranslated(text,item);
//            }
//        });
//    }
}
