package com.example.searchview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
SearchView mysearview;
ListView mylistview;

ArrayList<String> list;
//ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mysearview=(SearchView)findViewById(R.id.searview);
        mylistview=findViewById(R.id.list_view);
        list=new ArrayList<String>();


        list.add("Monday");
        list.add("Friday");
        list.add("Sunday");
        list.add("Nafas");
        list.add("Ali");



        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        mylistview.setAdapter(adapter);

        mysearview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });



    }
}