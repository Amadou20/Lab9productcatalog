package com.example.rayold.everydayneeds.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rayold.everydayneeds.AvailabilityFournisseur;
import com.example.rayold.everydayneeds.R;
import com.example.rayold.everydayneeds.fournisseurService;


public class addServiceProfil extends AppCompatActivity {
    String serviceName;
    TextView serviceNameView;
    DatabaseHelper db;
    Button btnAdd, btndel, btnListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_service_profil);
        final ListView listView = (ListView) findViewById(R.id.listview2);
        db = new DatabaseHelper(this);
        serviceName = getIntent().getStringExtra("SERVICE");
        serviceNameView = findViewById((R.id.ServiceName));

        serviceNameView.setText(serviceName);

        btnAdd = findViewById(R.id.buttonAddService);
        btndel = findViewById(R.id.buttonDeleteService);
        btnListView = findViewById(R.id.buttonServiceList);


        btnListView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(addServiceProfil.this , Displayfournisseurservice.class);
                startActivity(intent) ;
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = serviceNameView.getText().toString();

                if(db.serviceNameforfournisseur(s1)==true){
                    Toast.makeText(getApplicationContext(), "This service already exists", Toast.LENGTH_SHORT).show();
                }
                else if (db.serviceNameforfournisseur(s1)==false ){
                    boolean insert = db.insertServiceFournisseur(getIntent().getStringExtra("EMAIL"),s1);
                    if(insert==true){
                    Intent i = new Intent(addServiceProfil.this, AvailabilityFournisseur.class);
                    Toast.makeText(getApplicationContext(), "service saved: successful ", Toast.LENGTH_SHORT).show();
                    startActivity(i);}
                }
                else
                    Toast.makeText(getApplicationContext(), "service saved: fail", Toast.LENGTH_SHORT).show();
            }
        });


        btndel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = serviceNameView.getText().toString();
                boolean remove = db.deleteServiceFournisseur(serviceNameView.toString());
                if (remove = true ){
                    Toast.makeText(getApplicationContext(), "service delete: successful ", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getApplicationContext(), "service saved: fail", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /*listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            serviceName =(String) listView.getItemAtPosition(position);
            boolean insert = db.insertServiceFournisseur(getIntent().getStringExtra("EMAIL"),(String) listView.getItemAtPosition(position));
            if (insert = true ){
                Intent j = new Intent (fournisseurService.this,addServiceProfil.class );
                //Toast.makeText(getApplicationContext(), "service saved: successful ", Toast.LENGTH_SHORT).show();
                j.putExtra("SERVICE" ,(String) listView.getItemAtPosition(position) );
                startActivity(j);
            }
            else{
                Toast.makeText(getApplicationContext(), "service saved: fail", Toast.LENGTH_SHORT).show();
            }

        }
    });*/
}

