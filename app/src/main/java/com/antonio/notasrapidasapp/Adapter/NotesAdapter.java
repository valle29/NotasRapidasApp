package com.antonio.notasrapidasapp.Adapter;

/**
 * Created by Antonio on 10/03/2018.
 */

public class NotesAdapter {

    String Titulo;

    public NotesAdapter(){

    }

    public NotesAdapter(String titulo) {
        Titulo = titulo;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }
}
