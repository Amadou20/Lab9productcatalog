package com.example.rayold.everydayneeds;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rayold.everydayneeds.R;
import com.example.rayold.everydayneeds.activities.DatabaseHelper;
import com.example.rayold.everydayneeds.activities.Displayfournisseurservice;
import com.example.rayold.everydayneeds.activities.Login;
import com.example.rayold.everydayneeds.activities.Register;
import com.example.rayold.everydayneeds.activities.addServiceProfil;

import static android.provider.AlarmClock.EXTRA_MESSAGE;


public class admin extends AppCompatActivity {
    EditText hourlyRate;
    TextView service ;
    Button edit,add,delete , list;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);


        db = new DatabaseHelper(this);
        String itemstring = getIntent().getStringExtra("A");
        service= (TextView) findViewById(R.id.textView10);
        service.setText(itemstring);

        hourlyRate = (EditText)findViewById(R.id.editHourlyPrice);
        edit = (Button)findViewById(R.id.buttonEdit);
        add = (Button)findViewById(R.id.buttonAdd);
        delete = (Button)findViewById(R.id.buttonDelete);
        list = (Button)findViewById(R.id.button) ;

        list.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(admin.this , Displayadminservices.class);
                startActivity(intent) ;
            }
        });

        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String s1 = service.getText().toString();
                String s2 = hourlyRate.getText().toString();

                if (s1.equals("") || s2.equals("")) {
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
                }else if(db.serviceNameHourlyRate(s1)==true){
                    Toast.makeText(getApplicationContext(), "This service already exists", Toast.LENGTH_SHORT).show();
                }else{
                    Boolean insert = db.insertService(s1, s2);
                    if (insert == true) {
                        Toast.makeText(getApplicationContext(), "Service Adding Successful", Toast.LENGTH_SHORT).show();
                        hourlyRate.setText("");
                    } else {
                        Toast.makeText(getApplicationContext(), "Service Adding Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = service.getText().toString();
                if(s1.equals("")){
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
                } else{
                    Boolean remove = db.deleteService(service.getText().toString(), hourlyRate.getText().toString());
                    if (remove == true) {
                        Toast.makeText(getApplicationContext(), "Service delete: Successful", Toast.LENGTH_SHORT).show();
                        hourlyRate.setText("");
                    } else {
                        Toast.makeText(getApplicationContext(), "Service delete: Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = service.getText().toString();
                if(s1.equals("")){
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
                } else{
                    Boolean edit = db.editService(service.getText().toString(), hourlyRate.getText().toString());
                    if (edit == true) {
                        Toast.makeText(getApplicationContext(), "Service Edit: Successful", Toast.LENGTH_SHORT).show();
                        hourlyRate.setText("");
                    } else {
                        Toast.makeText(getApplicationContext(), "Service Edit: Failed, no match found", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}


