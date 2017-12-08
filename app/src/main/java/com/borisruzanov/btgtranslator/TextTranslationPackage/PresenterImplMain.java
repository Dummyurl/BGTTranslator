package com.borisruzanov.btgtranslator.TextTranslationPackage;

import com.borisruzanov.btgtranslator.TextTranslationPackage.http.CallBack;
import com.borisruzanov.btgtranslator.TextTranslationPackage.http.IHttpService;

import DatabasePackage.IPreferencesManager;

public class PresenterImplMain implements PresenterMainInterface {


    private IPreferencesManager _pm;
    private IHttpService httpService;
    private IUiCallBack uiCallBack;
    public PresenterImplMain(IPreferencesManager _pm, IHttpService httpService,IUiCallBack uiCallBack) {
        this._pm = _pm;
        this.httpService = httpService;
        this.uiCallBack=uiCallBack;
    }

    @Override
    public void translateText(final  String text) {
        _pm.saveSharedPreferencesForInputText(text);
        httpService.translateText(_pm.getLanguage(), text, new CallBack<String>() {
            @Override
            public void call(String item) {
                uiCallBack.textTranslated(text,item);
            }
        });
    }


}
