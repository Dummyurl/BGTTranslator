package com.borisruzanov.btgtranslator.TextTranslationPackage.base;

import android.support.v7.app.AppCompatActivity;

import com.borisruzanov.btgtranslator.TextTranslationPackage.database.IPreferencesManager;
import com.borisruzanov.btgtranslator.TextTranslationPackage.database.SharedPreferencesManager;

public class BaseActivity extends AppCompatActivity {
    private IPreferencesManager _pm;
    String shortLanguage;


    public IPreferencesManager getPreferenceManager() {
        if(_pm==null)
            _pm=new SharedPreferencesManager(this, shortLanguage );
        return _pm;
    }
}
