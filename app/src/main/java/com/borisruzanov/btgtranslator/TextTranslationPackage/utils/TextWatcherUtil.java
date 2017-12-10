package com.borisruzanov.btgtranslator.TextTranslationPackage.utils;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

import com.borisruzanov.btgtranslator.TextTranslationPackage.Contract;

import java.util.Timer;
import java.util.TimerTask;

public abstract class TextWatcherUtil implements TextWatcher {
    Timer timer;

    public TextWatcherUtil() {
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
                Log.v(Contract.TAG, "Util TextWatcher - In afterTextChange");
                callTextWatcherMethod(editable.toString());

            }
        }, 600);

    }

    public abstract void callTextWatcherMethod(String text);
}