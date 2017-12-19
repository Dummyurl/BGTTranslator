package com.borisruzanov.btgtranslator.TextTranslationPackage.choose_language;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.borisruzanov.btgtranslator.R;

import java.util.List;

public class ChooseLanguageAdapter extends BaseAdapter{


    private List<ChooseLanguageConstructor> languages;
    private LayoutInflater layoutInflater;

    public ChooseLanguageAdapter(Context context, List<ChooseLanguageConstructor> languages) {
        this.languages = languages;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return languages.size();
    }

    @Override
    public Object getItem(int position) {
        return languages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        View view = convertView;
        if (view == null){
            view = layoutInflater.inflate(R.layout.language_item, viewGroup, false);
        }

        ChooseLanguageConstructor currentLanguage = getLanguage(position);
        TextView textView =  (TextView) view.findViewById(R.id.language_item_textview);
        textView.setText(currentLanguage.getFullNameLanguage());
        return view;
    }

    private ChooseLanguageConstructor getLanguage(int position){
        return (ChooseLanguageConstructor) getItem(position);
    }
}
