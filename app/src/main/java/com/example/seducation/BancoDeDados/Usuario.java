package com.example.seducation.BancoDeDados;

import android.graphics.Bitmap;

public class Usuario {
       private int id;

    public Usuario(int id, String nome) {
        this.id = id;
        setNome(nome);
    }

    private String nome;
       private String email;
       private String senha;
       private Bitmap foto;

    public Usuario(int id,String nome, String email, String senha) {
        this.id = id;
        setNome(nome);
        setEmail(email);
        setSenha(senha);
    }

    public Usuario(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    public Bitmap getFoto() {
        return foto;
    }

    public void setFoto(Bitmap foto) {
        this.foto = foto;
    }
}
