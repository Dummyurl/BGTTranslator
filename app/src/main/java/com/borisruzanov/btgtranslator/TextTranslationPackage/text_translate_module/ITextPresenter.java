package com.borisruzanov.btgtranslator.TextTranslationPackage.text_translate_module;

public interface ITextPresenter {
        void forwardTextToInteractor(String text);
        String forwardLongLanguageFromInteractor();
        String getInputTextFromInteractor();
        String getOutputTextFromInteractor();
        void callCleanerFromInteractor();
}
