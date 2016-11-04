package com.example.lp.giuaki;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Adapter_ListviewTabreport extends ArrayAdapter {
    String[] Ten;
    Context context;

    public Adapter_ListviewTabreport(Activity context, String[] ten) {
        super(context, R.layout.item_tabreport, ten);
        this.Ten = ten;
        this.context = context;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewRow = layoutInflater.inflate(R.layout.item_tabreport, null,
                true);
        TextView ten = (TextView) viewRow.findViewById(R.id.txt_ten);
        ten.setText(Ten[i]);
        return viewRow;
    }
}