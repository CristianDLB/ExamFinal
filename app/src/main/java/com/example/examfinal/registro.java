package com.example.examfinal;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.examfinal.repositorio.reposito;
import com.example.examfinal.servicio.GitServicios;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class registro extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    private ImageView laImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        laImagen = findViewById(R.id.IMT);
        //Registrar
        Button btn1 = findViewById(R.id.reg);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retro = new Retrofit.Builder()
                        .baseUrl("https://funciona.free.beeceptor.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                GitServicios servis = retro.create((GitServicios.class));

                reposito rep = new reposito();

                EditText in1 = findViewById(R.id.nombre);
                String valNombre = String.valueOf(in1.getText());
                rep.setTitulo(valNombre);

                EditText in2 = findViewById(R.id.resumen);
                String valResumen = String.valueOf(in2.getText());
                rep.setResumen(valResumen);

                EditText in3 = findViewById(R.id.autor);
                String valAutor = String.valueOf(in3.getText());
                rep.setAutor(valAutor);

                EditText in4 = findViewById(R.id.fecha);
                String valFecha = String.valueOf(in4.getText());
                rep.setFecha(valFecha);

                EditText in5 = findViewById(R.id.latitud);
                String valLat= String.valueOf(in5.getText());
                rep.setLati(valLat);

                EditText in6 = findViewById(R.id.longitud);
                String valLongi = String.valueOf(in6.getText());
                rep.setLongi(valLongi);

                servis.crear(rep).enqueue(new Callback<reposito>() {
                    @Override
                    public void onResponse(Call<reposito> call, Response<reposito> response) {
                        Log.i("Main", new Gson().toJson(response.body()));
                    }

                    @Override
                    public void onFailure(Call<reposito> call, Throwable t) {
                        Log.i("Main", "No Hay conexion");
                    }
                });

            }
        });

        //Subir Imagen
        Button btn2 = findViewById(R.id.subir);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(registro.this.checkSelfPermission(Manifest.permission.CAMERA)!=PackageManager.PERMISSION_GRANTED){
                    registro.this.requestPermissions(new String[]{Manifest.permission.CAMERA},10001);
                }else   {
                    dispatchTakePictureIntent();
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            laImagen.setImageBitmap(imageBitmap);
        }
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }
}