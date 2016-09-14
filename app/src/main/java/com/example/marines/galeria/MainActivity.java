package com.example.marines.galeria;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Ver tutorial android gratis video 18
        Comidas comidas_data[]=new Comidas[]{
          new Comidas(R.drawable.crepa,"Crepas"),
          new Comidas(R.drawable.jugos,"Jugos"),
          new Comidas(R.drawable.c1,"Pizzas")
        };

        ComidasAdapter adaptador=new ComidasAdapter(this,R.layout.listview_item_row,comidas_data);
        lv=(ListView)findViewById(R.id.lv);
        lv.setAdapter(adaptador);



        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position,long id){

                FragmentManager manager = getSupportFragmentManager();
                DialogFragmentComidas miscuartos = new DialogFragmentComidas();
                miscuartos.setStyle(DialogFragment.STYLE_NO_FRAME, R.style.Theme_Transparent);
                miscuartos.show(manager, "");

            }

        });

    }
}
