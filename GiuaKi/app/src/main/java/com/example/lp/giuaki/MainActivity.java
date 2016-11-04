package com.example.lp.giuaki;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    String[] ten={"Man Utd","Man City","Chelsea","Arsenal","Liverpool","Totenham"};
    ListView lv;
    String[] tit={"Hồ Chí Minh","Hà Nội"};
    String[] des={"Hồ Chí Minh tổng số 23 người tham gia cuộc trò chuyện","Hà Nội tổng số 11 người tham gia cuộc trò chuyện"};
    ArrayAdapter<String> adapter1;

    TabHost tabHost;
    Adapter_ListviewTabreport adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        GetIndexFragment();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        HanderIndex();


                /*

        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("Thực Đơn");
        spec.setContent(R.id.tab_report);
        spec.setIndicator("Thực Đơn");
        host.addTab(spec);

        //Tab 2
        spec = host.newTabSpec("Loại Món");
        spec.setContent(R.id.tab_me);
        spec.setIndicator("Loại Món");
        host.addTab(spec);

        Adapter_ListviewTabreport adapter = new Adapter_ListviewTabreport(this, ten);
        ListView list_Report = (ListView) findViewById(R.id.list_tabreport);
        list_Report.setAdapter(adapter);

         */
    }


    public void HanderIndex(){
        //UI Grid and ViewPager
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                //Gridview
                MyAsyncTask myAsyncTask = new MyAsyncTask(MainActivity.this);

                //Gọi hàm execute để kích hoạt tiến trình
                myAsyncTask.execute();
                //
            }
        });
    }

    public class MyAsyncTask extends AsyncTask<Void, Integer, Void> {

        Activity contextParent;

        public MyAsyncTask(Activity contextParent) {
            this.contextParent = contextParent;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //Hàm này sẽ chạy đầu tiên khi AsyncTask này được gọi
            //Ở đây mình sẽ thông báo quá trình load bắt đâu "Start"
        }

        @Override
        protected Void doInBackground(Void... params) {
            //Hàm được được hiện tiếp sau hàm onPreExecute()
            //Hàm này thực hiện các tác vụ chạy ngầm
            //Tuyệt đối k vẽ giao diện trong hàm này
            for (int i = 0; i <= 2; i++) {
                SystemClock.sleep(200);
                //khi gọi hàm này thì onProgressUpdate sẽ thực thi
                publishProgress(i);
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            //Hàm thực hiện update giao diện khi có dữ liệu từ hàm doInBackground gửi xuống
            super.onProgressUpdate(values);
            //Thông qua contextCha để lấy được control trong MainActivity
            int number = values[0];
            if (number == 0) {
                TabHost host = (TabHost) findViewById(R.id.tabHostDetail);
                host.setup();

                //Tab 1
                TabHost.TabSpec spec = host.newTabSpec("REPORT");
                spec.setContent(R.id.tab_report);
                spec.setIndicator("REPORT");
                host.addTab(spec);

                //Tab 2
                spec = host.newTabSpec("ME");
                spec.setContent(R.id.tab_me);
                spec.setIndicator("ME");
                host.addTab(spec);

                //Tab 3
                spec = host.newTabSpec("BUDDY");
                spec.setContent(R.id.tab_buddy);
                spec.setIndicator("BUDDY");
                host.addTab(spec);


            }
            if (number == 1) {
                ListView list = (ListView) findViewById(R.id.list_tabreport);
                adapter = new Adapter_ListviewTabreport(contextParent, ten);
                list.setAdapter(adapter);

                ListView list2 = (ListView) findViewById(R.id.list_buddy);
                adapter1 = new Adapter_ListViewBuddy(contextParent, tit, des);
                list2.setAdapter(adapter1);

                list2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position,
                                            long id) {
                        Intent intent = new Intent(MainActivity.this, Activiy_Chat.class);
                        startActivity(intent);
                    }
                });

                ImageView imgbt1 = (ImageView) findViewById(R.id.btn_1);
                imgbt1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this, Activity_Calendar.class);
                        startActivity(intent);
                    }
                });
                ImageView imgbt2 = (ImageView) findViewById(R.id.btn_2);
                imgbt2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent1 = new Intent(MainActivity.this, Activty_Record.class);
                        startActivity(intent1);
                    }
                });
                ImageView imgnotif = (ImageView) findViewById(R.id.notif);
                imgnotif.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent3 = new Intent(MainActivity.this, Activity_Notification.class);
                        startActivity(intent3);
                    }
                });
            }
            if (number == 2) {

            }
        }


        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            //Hàm này được thực hiện khi tiến trình kết thúc
            //Ở đây mình thông báo là đã "Finshed" để người dùng biết
            Toast.makeText(contextParent, "Okie, Finished", Toast.LENGTH_SHORT).show();
        }
    }


    public void GetIndexFragment(){
        Fragment_Index index_fragment = new Fragment_Index();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, index_fragment);
        fragmentTransaction.commit();
    }
    public void GetSettingsFragment(){
        Fragment_Settings fragment_settings = new Fragment_Settings();
        android.support.v4.app.FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
        fragmentTransaction1.replace(R.id.fragment_container, fragment_settings);
        fragmentTransaction1.commit();
    }
    public void GetProfileFragment(){
        Fragment_Profile fragment_profile = new Fragment_Profile();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment_profile);
        fragmentTransaction.commit();
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.notif) {

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public class ViewDialog {

        public void showDialog(Activity activity){
            final Dialog dialog = new Dialog(activity);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.dialog);
            dialog.show();
            Button dialogButton = (Button) dialog.findViewById(R.id.btcancel);
            dialogButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });


        }
    }

    public class ViewDialogLogout {

        public void showDialog(Activity activity){
            final Dialog dialog = new Dialog(activity);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.logout_dialog);
            dialog.show();
            Button dialogButton = (Button) dialog.findViewById(R.id.btcancel1);
            dialogButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });


        }
    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_export) {
            GetIndexFragment();
            HanderIndex();
            // Handle the camera action
        } else if (id == R.id.nav_feedback) {
            ViewDialog alert = new ViewDialog();
            alert.showDialog(this);
        } else if (id == R.id.nav_uses) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
            startActivity(browserIntent);
        } else if (id == R.id.nav_about) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
            startActivity(browserIntent);
        } else if (id == R.id.nav_rateus) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
            startActivity(browserIntent);

        } else if (id == R.id.nav_settings) {
            GetSettingsFragment();

        } else if (id == R.id.nav_profile) {
            GetProfileFragment();

        } else if (id == R.id.nav_logout) {
            ViewDialogLogout alert = new ViewDialogLogout();
            alert.showDialog(this);

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
