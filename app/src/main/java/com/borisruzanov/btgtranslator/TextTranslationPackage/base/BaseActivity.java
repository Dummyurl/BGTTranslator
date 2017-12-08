package com.borisruzanov.btgtranslator.TextTranslationPackage.base;

import android.support.v7.app.AppCompatActivity;

import DatabasePackage.IPreferencesManager;
import DatabasePackage.SharedPreferencesManager;

/**
 * Created by Boris on 12/7/2017.
 */

public class BaseActivity extends AppCompatActivity {
    private IPreferencesManager _pm;


    public IPreferencesManager getPreferenceManager() {
        if(_pm==null)
            _pm=new SharedPreferencesManager(this);
        return _pm;
    }
}
