package com.borisruzanov.btgtranslator.TextTranslationPackage.text_translate_module;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.borisruzanov.btgtranslator.R;
import com.borisruzanov.btgtranslator.TextTranslationPackage.Contract;
import com.borisruzanov.btgtranslator.TextTranslationPackage.base.BaseActivity;
import com.borisruzanov.btgtranslator.TextTranslationPackage.choose_language.ChooseLanguageActivity;
import com.borisruzanov.btgtranslator.TextTranslationPackage.services.http.HttpService;
import com.borisruzanov.btgtranslator.TextTranslationPackage.utils.TextWatcherUtil;

public class TextActivity extends BaseActivity implements ITextActivity,IUiCallBack {


    AppCompatButton chooseLanguageButton;
    AppCompatButton cleanButton;
    AppCompatEditText translatedTextOutput;
    AppCompatEditText translatedTextInput;
    Toolbar toolbar;
    String longLanguage;
    String translatedInputString;


    ITextPresenter presenter;
    TextWatcherUtil watcher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v(Contract.TAG, "View - In OnCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        translatedTextOutput = (AppCompatEditText) findViewById(R.id.translated_text_field);
        translatedTextInput = (AppCompatEditText) findViewById(R.id.translation_input_edit);

        chooseLanguageButton = (AppCompatButton) findViewById(R.id.choose_language_button);
        chooseLanguageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TextActivity.this, ChooseLanguageActivity.class);
                startActivity(intent);
            }
        });
        cleanButton = (AppCompatButton) findViewById(R.id.clean_button);
        cleanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.callCleanerFromInteractor();
            }
        });

        translatedInputString = translatedTextInput.getText().toString().replace(" ","+");

        presenter = new TextPresenter(new TextInteractor(getPreferenceManager(),new HttpService(this, "ru", translatedInputString),this));


        //Start working when text changed
        watcher = new TextWatcherUtil() {
            @Override
            public void callTextWatcherMethod(String text) {
                Log.v(Contract.TAG, "View - In callTextWatcherMethod");
                presenter.forwardTextToInteractor(text);
            }
        };
        translatedTextInput.addTextChangedListener(watcher);
        translatedTextInput.setSelection(translatedTextInput.getText().length());
        translatedTextInput.setText(presenter.getInputTextFromInteractor());
        translatedTextOutput.setText(presenter.getOutputTextFromInteractor());

        longLanguage = presenter.forwardLongLanguageFromInteractor();
       if (longLanguage == "") {
           chooseLanguageButton.setText(getString(R.string.main_choose_language));
           Log.v(Contract.TAG, "Language NOT null");
        } else {
           Log.v(Contract.TAG, "Language NULL");
           chooseLanguageButton.setText(longLanguage);

       }
    }


    @Override
    public void textTranslated(String inputText, String result) {
        translatedTextOutput.setText(result);
        Log.d("Translated", "Translated:" + result);
    }

    @Override
    public void cleanTextFields() {
        translatedTextInput.setText("");
        translatedTextOutput.setText("");
    }
}
