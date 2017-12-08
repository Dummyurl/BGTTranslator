package com.borisruzanov.btgtranslator.TextTranslationPackage.http;

/**
 * Created by Boris on 12/7/2017.
 */
public interface IHttpService {
    void translateText(String language,String text ,CallBack<String> callBack);
}
