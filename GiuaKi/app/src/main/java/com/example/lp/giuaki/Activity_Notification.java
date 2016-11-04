package com.example.lp.giuaki;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class Activity_Notification extends AppCompatActivity {
    Adapter_Notification adapter1;
    String[] tit={"Welcome","Hello", "You have new email !", "From your school", "Notification your deadline"};
    String[] des={"This is description of your notification !"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        ListView list2 = (ListView) findViewById(R.id.list_notification);
        adapter1 = new Adapter_Notification(this, tit, des);
        list2.setAdapter(adapter1);
    }
}
