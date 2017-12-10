package com.borisruzanov.btgtranslator.TextTranslationPackage.text_translate_module;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.borisruzanov.btgtranslator.R;
import com.borisruzanov.btgtranslator.TextTranslationPackage.Contract;
import com.borisruzanov.btgtranslator.TextTranslationPackage.base.BaseActivity;
import com.borisruzanov.btgtranslator.TextTranslationPackage.services.http.HttpService;
import com.borisruzanov.btgtranslator.TextTranslationPackage.utils.TextWatcherUtil;

public class TextActivity extends BaseActivity implements ITextActivity,IUiCallBack {


    AppCompatButton chooseLanguageButton;
    AppCompatButton cleanButton;
    AppCompatEditText translatedTextOutput;
    AppCompatEditText translatedTextInput;
    BottomNavigationView bottomNavigationView;
    Toolbar toolbar;
    ITextPresenter presenter;
    TextWatcherUtil watcher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v(Contract.TAG, "View - In OnCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        translatedTextOutput = (AppCompatEditText) findViewById(R.id.translated_text_field);
        translatedTextInput = (AppCompatEditText) findViewById(R.id.translation_input_edit);

        chooseLanguageButton = (AppCompatButton) findViewById(R.id.choose_language_button);
        cleanButton = (AppCompatButton) findViewById(R.id.clean_button);

        presenter =new TextPresenter(getPreferenceManager(),new HttpService(this),this);

        //Start working when text changed
        watcher = new TextWatcherUtil() {
            @Override
            public void callTextWatcherMethod(String text) {
                Log.v(Contract.TAG, "View - In callTextWatcherMethod");
                presenter.saveInputTextInSharedPreferences(text);
            }
        };
        translatedTextInput.addTextChangedListener(watcher);
    }


    @Override
    public void textTranslated(String text, String result) {
        //TODO SET TEXT TO VIEw
    }
}
