package com.borisruzanov.btgtranslator.TextTranslationPackage;

public class PresenterImplMain implements PresenterMainInterface {

    @Override
    public void saveInputTextInStaticVariable(String toStaticStringInputText) {
        ModelImpl model = new ModelImpl();
        Contract.setInputText(toStaticStringInputText);
        model.saveInputTextInSharedPreferences();
    }
}
