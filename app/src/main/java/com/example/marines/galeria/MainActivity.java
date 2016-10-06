package com.example.marines.galeria;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

/**
 * Created by Marines on 13/09/2016.
 */
public class MainActivity extends AppCompatActivity {

    Button boton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton=(Button) findViewById(R.id.postres);


       boton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               FragmentManager manager = getSupportFragmentManager();
               DialogFragmentComidas miscuartos = new DialogFragmentComidas();
               miscuartos.setStyle(DialogFragment.STYLE_NO_FRAME, R.style.transparente);
               miscuartos.show(manager, "");
           }
       });

    }
}
