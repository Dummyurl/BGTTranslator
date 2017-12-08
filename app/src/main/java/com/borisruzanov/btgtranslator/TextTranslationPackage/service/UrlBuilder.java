package com.borisruzanov.btgtranslator.TextTranslationPackage.service;

public class UrlBuilder{


    public String buildUrl (String translatedTextInput, String language){
        String urlTemplate = "https://translation.googleapis.com/language/translate/"+ "v2?q=\"%s\"&amp;target=\"%s\"&amp;key=AIzaSyBYruIXzvIXCkITbzUIQ1TlQJoOmNERnrw";
        String url = String.format(urlTemplate, translatedTextInput, language );
        return url;
    };
}
