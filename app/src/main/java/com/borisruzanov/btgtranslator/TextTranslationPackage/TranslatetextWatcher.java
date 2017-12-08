package com.borisruzanov.btgtranslator.TextTranslationPackage;

import android.text.Editable;
import android.text.TextWatcher;

import java.util.Timer;
import java.util.TimerTask;

public abstract class  TranslatetextWatcher implements TextWatcher {
    Timer timer;

    public TranslatetextWatcher() {
        this.timer = new Timer();
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(final Editable editable) {

        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                textChange(editable.toString());

            }
        }, 600);

    }

    public abstract void textChange(String text);
}