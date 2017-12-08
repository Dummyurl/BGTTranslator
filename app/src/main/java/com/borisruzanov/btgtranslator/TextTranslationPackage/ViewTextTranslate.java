package com.borisruzanov.btgtranslator.TextTranslationPackage;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;

import com.borisruzanov.btgtranslator.R;

import java.util.Timer;
import java.util.TimerTask;

public class ViewTextTranslate extends AppCompatActivity implements ViewTextTranslateInterface {


    AppCompatButton chooseLanguageButton;
    AppCompatButton cleanButton;
    AppCompatEditText translatedTextOutput;
    AppCompatEditText translatedTextInput;
    BottomNavigationView bottomNavigationView;
    Toolbar toolbar;
    PresenterImplMain presenterMainImpl;
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        translatedTextOutput = (AppCompatEditText) findViewById(R.id.translated_text_field);
        translatedTextInput = (AppCompatEditText) findViewById(R.id.translation_input_edit);

        chooseLanguageButton = (AppCompatButton) findViewById(R.id.choose_language_button);
        cleanButton = (AppCompatButton) findViewById(R.id.clean_button);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        presenterMainImpl = new PresenterImplMain();

        translatedTextInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                            presenterMainImpl.saveInputTextInStaticVariable(translatedTextInput.getText().toString());

                    }
                },600);

            }
        });
    }
}
