package com.bdjobs.navigationdrawer;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import static com.bdjobs.navigationdrawer.R.id.drawerList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    DrawerLayout drawerLayout;
    String[] day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializer();
    }

    private void initializer() {
        listView = (ListView) findViewById(drawerList);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        day = getResources().getStringArray(R.array.day);

        ArrayAdapter listAdapter = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,day);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listView.setItemChecked(position,true);
                getSupportActionBar().setTitle(day[position]);
            }
        });
    }
}
