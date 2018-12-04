package com.example.rayold.everydayneeds.activities;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.rayold.everydayneeds.R;
import com.example.rayold.everydayneeds.fournisseurService;

import java.util.ArrayList;

public class ProprietaireService extends AppCompatActivity {
    DatabaseHelper db;
    String serviceName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displayfournisseurservice);
        //super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_displayfournisseurservice);

        ListView listview = (ListView) findViewById(R.id.list) ;
        db = new DatabaseHelper(this);
        ArrayList<String> thelist = new ArrayList<String>() ;
        Cursor data = db.getListContents() ;

        if (data.getCount()==0){
            Toast.makeText(ProprietaireService.this , "No service added" , Toast.LENGTH_LONG).show() ;
        }
        else{
            while(data.moveToNext()){
                thelist.add(data.getString(1));
                ListAdapter listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,thelist) ;
                listview.setAdapter(listAdapter);
            }
        }
        /*final ListView listView = (ListView) findViewById(R.id.listview);
        db = new DatabaseHelper(this);

        ArrayList<String> theList = new ArrayList<>();
        Cursor data = db.getFournisseurService();
        if(data.getCount() == 0) {
            Toast.makeText(this, "There are no service available. Fournisseur didn't add any yet", Toast.LENGTH_LONG).show();
        }else{
            while(data.moveToNext()){
                theList.add(data.getString(0));
                ListAdapter listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,theList);
                listView.setAdapter(listAdapter);
            }
        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                serviceName =(String) listView.getItemAtPosition(position);
                Intent j = new Intent (ProprietaireService.this,proprietaireEdit.class );
                //Toast.makeText(getApplicationContext(), "service saved: successful ", Toast.LENGTH_SHORT).show();
                j.putExtra("SERVICE" ,(String) listView.getItemAtPosition(position) );
                startActivity(j);
            }
        });*/
    }
}
