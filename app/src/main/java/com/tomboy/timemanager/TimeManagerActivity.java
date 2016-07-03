package com.tomboy.timemanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.tomboy.fragment.DayRecordFragment;
import com.tomboy.fragment.HomeFragment;
import com.tomboy.fragment.TaskFragment;
import com.tomboy.fragment.WeekStatisticFragment;
import com.tomboy.fragment.dummy.DummyContent;

public class TimeManagerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        TaskFragment.OnListFragmentInteractionListener{

    String[] menuItems = new String[]{"DayRecordFragment", "WeekStatisticFragment"};

    HomeFragment fragHome;
    DayRecordFragment fragDayRecord;
    TaskFragment fragTask;
    WeekStatisticFragment fragWeekStatistic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_manager);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fragHome = new HomeFragment().newInstance();
        fragDayRecord = new DayRecordFragment().newInstance();
        fragTask = new TaskFragment().newInstance();
        fragWeekStatistic = new WeekStatisticFragment().newInstance();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_activity_main, fragHome).commit();
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
        getMenuInflater().inflate(R.menu.time_manager, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this.getApplicationContext(),SettingsActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fl_activity_main, fragHome).commit();
        }
        if (id == R.id.nav_day_record) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fl_activity_main, fragDayRecord).commit();
        } else if(id == R.id.nav_task){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fl_activity_main, fragTask).commit();
        } else if(id == R.id.nav_label){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fl_activity_main, fragDayRecord).commit();
        } else if (id == R.id.nav_statistics){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fl_activity_main, fragWeekStatistic).commit();
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_about) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }
}
