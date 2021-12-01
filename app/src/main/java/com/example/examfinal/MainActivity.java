package com.example.examfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //CAMBIO CON BOTON 1
        Button boton1 =findViewById(R.id.btn1);
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), registro.class);
                startActivity(intent);
            }
        });
        //CAMBIO CON BOTON 2
        Button boton2 =findViewById(R.id.btn2);
        boton2 .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), mostrando.class);
                startActivity(intent);
            }
        });
    }
}