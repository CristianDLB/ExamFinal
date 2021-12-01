package com.example.examfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.examfinal.adaptador.adaptar;
import com.example.examfinal.repositorio.reposito;
import com.example.examfinal.servicio.GitServicios;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class mostrando extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrando);

        RecyclerView r=findViewById(R.id.reciclear);
        r.setHasFixedSize(true);
        r.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        Retrofit retro = new Retrofit.Builder()
                .baseUrl("https://funciona.free.beeceptor.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitServicios servi = retro.create((GitServicios.class));
        servi.muestroLib().enqueue(new Callback<List<reposito>>() {
            @Override
            public void onResponse(Call<List<reposito>> call, Response<List<reposito>> response) {
                Log.i("Main", String.valueOf(response.code()));
                Log.i("Main", new Gson().toJson(response.body()));

                adaptar adaptador = new adaptar(response.body());
                r.setAdapter(adaptador);
            }

            @Override
            public void onFailure(Call<List<reposito>> call, Throwable t) {
                Log.i("Main","No hay conexion");
            }
        });

    }
}