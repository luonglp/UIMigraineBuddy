package com.example.lp.giuaki;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class Adapter_Notification extends ArrayAdapter<String> {

    String[] title;
    String[] description;
    Context context;

    public Adapter_Notification(Activity context, String[] title, String[] description) {
        super(context, R.layout.item_tabreport, title);
        this.title = title;
        this.description = description;
        this.context = context;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewRow = layoutInflater.inflate(R.layout.item_notif, null,
                true);
        TextView Title = (TextView) viewRow.findViewById(R.id.title);
        Title.setText(title[i]);
        TextView Descrip = (TextView) viewRow.findViewById(R.id.descrip);
        return viewRow;

    }
}