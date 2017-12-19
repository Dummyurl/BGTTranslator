package com.borisruzanov.btgtranslator.TextTranslationPackage.choose_language;

import android.widget.ListView;

public class ChooseLanguagePresenter implements IChooseLanguagePresenter {

    ListView languageList;
    IChooseLanguageInteractor iChooseLanguageInteractor;

    public ChooseLanguagePresenter(ListView languageList, IChooseLanguageInteractor iChooseLanguageInteractor) {
        this.languageList = languageList;
        this.iChooseLanguageInteractor = iChooseLanguageInteractor;
    }

    @Override
    public void sendingChoosedLanguageToInteractor(String shortLanguage, String longLanguage) {
        iChooseLanguageInteractor.putLanguagesInSharedPreferences(shortLanguage,longLanguage);
//        Intent myIntent = new Intent(view.getContext(), TextActivity.class);
//        String shortLanguage = languageList.initData().get(i).getShortNameLanguage();
//        String longLanguage = languageList.initData().get(i).getFullNameLanguage();
//        myIntent.putExtra("long", longLanguage);
//        myIntent.putExtra("short", shortLanguage);
//        view.getContext().startActivity(myIntent);


    }
}
