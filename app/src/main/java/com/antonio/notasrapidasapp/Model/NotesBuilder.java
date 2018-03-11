package com.antonio.notasrapidasapp.Model;

/**
 * Created by Antonio on 10/03/2018.
 */

public class NotesBuilder {

    private String tittle;
    private String content;

    public NotesBuilder(){

    }

    public NotesBuilder(String tittle, String content) {
        this.tittle = tittle;
        this.content = content;
    }

    public String getTittle() {
        return tittle;
    }

    public String getContent() {
        return content;
    }


}
