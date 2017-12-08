package com.borisruzanov.btgtranslator.TextTranslationPackage;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;

import com.borisruzanov.btgtranslator.R;
import com.borisruzanov.btgtranslator.TextTranslationPackage.base.BaseActivity;
import com.borisruzanov.btgtranslator.TextTranslationPackage.http.HttpService;

public class ViewTextTranslate extends BaseActivity implements ViewTextTranslateInterface,IUiCallBack {


    AppCompatButton chooseLanguageButton;
    AppCompatButton cleanButton;
    AppCompatEditText translatedTextOutput;
    AppCompatEditText translatedTextInput;
    BottomNavigationView bottomNavigationView;
    Toolbar toolbar;
    PresenterMainInterface presenterMainImpl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenterMainImpl=new PresenterImplMain(getPreferenceManager(),new HttpService(this),this);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        translatedTextOutput = (AppCompatEditText) findViewById(R.id.translated_text_field);
        translatedTextInput = (AppCompatEditText) findViewById(R.id.translation_input_edit);

        chooseLanguageButton = (AppCompatButton) findViewById(R.id.choose_language_button);
        cleanButton = (AppCompatButton) findViewById(R.id.clean_button);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);


        TranslatetextWatcher watcher = new TranslatetextWatcher() {
            @Override
            public void textChange(String text) {
                presenterMainImpl.translateText(text);
            }
        };
        translatedTextInput.addTextChangedListener(watcher);
    }


    @Override
    public void textTranslated(String text, String result) {
        //TODO SET TEXT TO VIEw
    }
}
