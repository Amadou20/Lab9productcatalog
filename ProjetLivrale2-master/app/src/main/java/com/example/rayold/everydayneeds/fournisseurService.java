package com.example.rayold.everydayneeds;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.rayold.everydayneeds.activities.CustomListview;

public class fournisseurService extends AppCompatActivity {
    private ListView list ;
    private String[] services = {"Installation ou reparation","Nettoyage de tapis","Demenagement","Assemblement de meubles","Plomberie","Service de serrurerie","Peinture","Nettoyage de fenetre","Electricite","Service antiparasitaire"};
    private Integer[] imgid = {R.drawable.im1 ,R.drawable.im2 ,R.drawable.im3 ,R.drawable.im4 ,R.drawable.im5 ,R.drawable.im6 ,R.drawable.im7 ,R.drawable.im8 ,R.drawable.im9 ,R.drawable.im10 , } ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fournisseur_service);

        list = (ListView) findViewById(R.id.listview) ;
        CustomListview customListview = new CustomListview(this , services , imgid) ;
        list.setAdapter(customListview);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }


}
