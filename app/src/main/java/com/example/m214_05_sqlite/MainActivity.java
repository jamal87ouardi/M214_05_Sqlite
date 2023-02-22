package com.example.m214_05_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_add,btn_list;

    EditText Nom,Prix,Url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_add=findViewById(R.id.button);
        btn_list=findViewById(R.id.button2);


        Nom=findViewById(R.id.ed_nom);
        Prix=findViewById(R.id.ed_prix);
        Url=findViewById(R.id.ed_url);


        btn_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ListerActivity.class);
                startActivity(i);
            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Molinet m = new Molinet();

                DB db = new DB(getApplicationContext());

                m.setNom(Nom.getText().toString());
                m.setPrix(Float.parseFloat(Prix.getText().toString()));
                m.setUrl(Url.getText().toString());

                long r = db.add_Molinet(m);

                if (r != -1) {
                    Toast.makeText(getApplicationContext(), "Molinet Ajouté avec succée", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Echec", Toast.LENGTH_LONG).show();
                }

            }
        });


    }
}