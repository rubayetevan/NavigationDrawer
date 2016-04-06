package com.bdjobs.navigationdrawer;

import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SlidingDrawer;

import static com.bdjobs.navigationdrawer.R.id.drawerList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    DrawerLayout drawerLayout;
    String[] day;
    android.support.v4.app.ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializer();
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    private void initializer() {
        listView = (ListView) findViewById(drawerList);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        day = getResources().getStringArray(R.array.day);

        ArrayAdapter listAdapter = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,day);
        listView.setAdapter(listAdapter);

        drawerToggle = new android.support.v4.app.ActionBarDrawerToggle(this,drawerLayout,R.drawable.menu,
                R.string.drawer_open,R.string.drawer_close);
        drawerLayout.setDrawerListener(drawerToggle);
        //getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);






        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listView.setItemChecked(position,true);
                getSupportActionBar().setTitle(day[position]);
            }
        });
    }
}
