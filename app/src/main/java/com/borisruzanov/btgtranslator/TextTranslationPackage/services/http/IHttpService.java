package com.borisruzanov.btgtranslator.TextTranslationPackage.services.http;

public interface IHttpService {
    void translateText(String language,String text ,CallBack<String> callBack);
}
