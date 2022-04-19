package com.example.searchpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView Search_SMS;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Search_SMS = (ListView) findViewById(R.id.Search_SMS);

        ArrayList<String> arrayVendors = new ArrayList<>();
        arrayVendors.addAll(Arrays.asList(getResources().getStringArray(R.array.Vendor_Options)));

        adapter = new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                arrayVendors
        );

        Search_SMS.setAdapter(adapter);
        Search_SMS.setOnItemClickListener(new AdapterView.OnItemClickListener()

        {
            @Override
            public void onItemClick (AdapterView < ? > adapterView, View view, int i, long l){
                if (i == 0) {

                    startActivity(new Intent(MainActivity.this, CompRep.class));

                }
                else if (i == 1) {
                    startActivity(new Intent(MainActivity.this, Electric.class));
                }
                else if (i == 2) {
                    startActivity(new Intent(MainActivity.this, HomeCleaning.class));
                }
                else if (i == 3) {
                    startActivity(new Intent(MainActivity.this, Tutoring.class));
                }
                else if (i == 4) {
                    startActivity(new Intent(MainActivity.this, HomeRepairAndPainting.class));
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);
        MenuItem item = menu.findItem(R.id.Search_SMS);
        SearchView searchView = (SearchView)item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }

        });

        return super.onCreateOptionsMenu(menu);

    }

}