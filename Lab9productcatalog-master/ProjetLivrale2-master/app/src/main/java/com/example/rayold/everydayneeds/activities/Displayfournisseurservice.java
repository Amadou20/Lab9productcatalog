package com.example.rayold.everydayneeds.activities;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.rayold.everydayneeds.R;

import java.util.ArrayList;

public class Displayfournisseurservice extends AppCompatActivity {
    DatabaseHelper db ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displayfournisseurservice);

        ListView listview = (ListView) findViewById(R.id.list) ;
        db = new DatabaseHelper(this);
        ArrayList<String> thelist = new ArrayList<String>() ;
        Cursor data = db.getListContents() ;

        if (data.getCount()==0){
            Toast.makeText(Displayfournisseurservice.this , "No service added" , Toast.LENGTH_LONG).show() ;
        }
        else{
            while(data.moveToNext()){
                thelist.add(data.getString(1));
                ListAdapter listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,thelist) ;
                listview.setAdapter(listAdapter);
            }
        }
    }
}
