package com.example.lp.giuaki;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by LP on 11/3/2016.
 */

public class Adapter_ListViewBuddy extends ArrayAdapter<String> {

    String[] title;
    String[] description;
    Context context;

    public Adapter_ListViewBuddy(Activity context, String[] title, String[] description) {
        super(context, R.layout.item_tabreport, title);
        this.title = title;
        this.description = description;
        this.context = context;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewRow = layoutInflater.inflate(R.layout.item_tabbuddy, null,
                true);
        TextView Title = (TextView) viewRow.findViewById(R.id.titlebuddy);
        Title.setText(title[i]);
        TextView Des = (TextView) viewRow.findViewById(R.id.descriptionbuddy);
        Des.setText(description[i]);
        return viewRow;

    }
}