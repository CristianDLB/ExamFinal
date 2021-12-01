package com.example.examfinal.repositorio;

public class reposito {
    private  int id;
    private String titulo;
    private  String resumen;
    private String autor;
    private String fecha;
    private String tienda;
    private String lati;
    private  String longi;
    private String imagen;

    public reposito() {
    }

    public reposito(int id, String titulo, String resumen, String autor, String fecha, String tienda, String lati, String longi, String imagen) {
        this.id = id;
        this.titulo = titulo;
        this.resumen = resumen;
        this.autor = autor;
        this.fecha = fecha;
        this.tienda = tienda;
        this.lati = lati;
        this.longi = longi;
        this.imagen = imagen;
    }

    public reposito(String titulo) {
        this.titulo = titulo;
    }

    public reposito(String titulo, String imagen) {
        this.titulo = titulo;
        this.imagen = imagen;
    }

    public reposito(String titulo, String resumen, String autor, String fecha, String lati, String longi) {
        this.titulo = titulo;
        this.resumen = resumen;
        this.autor = autor;
        this.fecha = fecha;
        this.lati = lati;
        this.longi = longi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLati() {
        return lati;
    }

    public void setLati(String lati) {
        this.lati = lati;
    }

    public String getLongi() {
        return longi;
    }

    public void setLongi(String longi) {
        this.longi = longi;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTienda() {
        return tienda;
    }

    public void setTienda(String tienda) {
        this.tienda = tienda;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
