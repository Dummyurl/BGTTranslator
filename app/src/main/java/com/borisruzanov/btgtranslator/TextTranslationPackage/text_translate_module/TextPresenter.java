package com.borisruzanov.btgtranslator.TextTranslationPackage.text_translate_module;

public class TextPresenter implements ITextPresenter {

    ITextInteractor iTextInteractor;

    public TextPresenter(ITextInteractor iTextInteractor) {
        this.iTextInteractor = iTextInteractor;
    }


    @Override
    public void forwardTextToInteractor(final String text) {
        iTextInteractor.saveTextInputInSharedPreferences(text);
    }

    @Override
    public String forwardLongLanguageFromInteractor() {
        return iTextInteractor.getLongLanguageFromSharedPreferences();
    }

    @Override
    public String getInputTextFromInteractor() {
        return iTextInteractor.getInputTextFromSharedPreferences();
    }

    @Override
    public String getOutputTextFromInteractor() {
        return iTextInteractor.getOutputTextFromSharedPreferences();
    }

    @Override
    public void callCleanerFromInteractor() {
        iTextInteractor.callCleanerFromSharedPreferenceManager();

    }

}
