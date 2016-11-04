package com.example.lp.giuaki;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class Activty_Record extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        TabHost host = (TabHost) findViewById(R.id.tabHostDetail);
        host.setup();

        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("MIGRAINE");
        spec.setContent(R.id.tab_migraine);
        spec.setIndicator("MIGRAINE");
        host.addTab(spec);

        //Tab 2
        spec = host.newTabSpec("SLEEP");
        spec.setContent(R.id.tab_sleep);
        spec.setIndicator("SLEEP");
        host.addTab(spec);
    }
}
