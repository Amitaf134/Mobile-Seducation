package com.example.seducation.BancoDeDados;

public class Postagens {
    private long id;
    private String texto;

    public Postagens(long id, String texto) {
        this.id = id;
        setTexto(texto);
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

}
