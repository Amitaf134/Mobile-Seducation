package com.example.seducation.BancoDeDados;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class UsuarioController{
    private final List<Usuario> usuarios;
    private Context contexto;
    private static UsuarioController instancia = null;

    public UsuarioController(Context contexto)
    {
        this.contexto = contexto;
        usuarios = new ArrayList<>();
    }

    public static UsuarioController getInstancia(Context contexto){
        if (instancia == null)
            instancia = new UsuarioController(contexto);
        return instancia;
    }

    public boolean cadastrar(Usuario usuario){
        UsuarioRepositorio usuarioRepositorio = new UsuarioRepositorio(contexto);
        long resultado = usuarioRepositorio.inserirUsuario(usuario);
        if (resultado != -1)
            return true;
        else
            return false;
    }

    public int buscarUsuario(String email){
        int valor;
        Usuario user = new Usuario();
        UsuarioRepositorio usuarioRepositorio = new UsuarioRepositorio(contexto);
        List<Usuario> usuarios = usuarioRepositorio.buscarUsuario(email);
         if(usuarios.size() >0){
             valor = 1;
         }else{
             valor = 0;
         }
         return valor;
    }

    public Usuario buscarPorPosicao(int posicao)
    {
        return usuarios.get(posicao);
    }

}
