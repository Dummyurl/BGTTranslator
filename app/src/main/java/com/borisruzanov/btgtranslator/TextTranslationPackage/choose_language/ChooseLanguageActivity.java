package com.borisruzanov.btgtranslator.TextTranslationPackage.choose_language;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.borisruzanov.btgtranslator.R;
import com.borisruzanov.btgtranslator.TextTranslationPackage.base.BaseActivity;
import com.borisruzanov.btgtranslator.TextTranslationPackage.text_translate_module.TextActivity;

public class ChooseLanguageActivity extends BaseActivity implements IChooseLanguageActivity {

    private ListView languagesListView;
    IChooseLanguagePresenter iChooseLanguagePresenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_language_page);
        languagesListView = (ListView) findViewById(R.id.language_list);
        final ChooseLanguageAdapter languagesAdapter = new ChooseLanguageAdapter(this, LanguageList.initData());

        languagesListView.setAdapter(languagesAdapter);
        iChooseLanguagePresenter = new ChooseLanguagePresenter(
                languagesListView, new ChooseLanguageInteractor(getPreferenceManager()));
        languagesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String shortLanguage = LanguageList.initData().get(i).getShortNameLanguage();
                String longLanguage = LanguageList.initData().get(i).getFullNameLanguage();
                iChooseLanguagePresenter.sendingChoosedLanguageToInteractor(shortLanguage, longLanguage);
                Intent myIntent = new Intent(view.getContext(), TextActivity.class);

                startActivity(myIntent);
            }
        });
    }



}
