package com.example.examfinal.servicio;

import com.example.examfinal.repositorio.reposito;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface GitServicios {

    @GET("prueba")
    Call<List<reposito>> muestroLib();

    @POST("N00026219/libros")
    Call<reposito>crear(@Body reposito rep);
}
