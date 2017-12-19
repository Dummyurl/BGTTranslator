package com.borisruzanov.btgtranslator.TextTranslationPackage.services;

import android.content.Context;
import android.util.Log;

import com.borisruzanov.btgtranslator.R;
import com.borisruzanov.btgtranslator.TextTranslationPackage.Contract;
import com.borisruzanov.btgtranslator.TextTranslationPackage.database.IPreferencesManager;

import java.net.URLEncoder;

public class UrlBuilder{

    String translatedTextInput;
    String language;
    Context context;
    IPreferencesManager iPreferencesManager;


    public UrlBuilder(Context context, String language, String translatedTextInput) {
        this.context = context;
        this.language = language;
        this.translatedTextInput = translatedTextInput;
//        this.iPreferencesManager = new SharedPreferencesManager(context, ) {
//        };
    }

    public String buildUrl (String translatedTextInput, String language){

//        iPreferencesManager.getShortLanguage();


        String url = String.format(context.getString(R.string.request_template),
                String.format(context.getString(R.string.query_Template), URLEncoder.encode(translatedTextInput), language ));
        Log.v(Contract.TAG,"First url " + url);
        Log.v(Contract.TAG,"Second url " + url);

        return url;
    }
}
