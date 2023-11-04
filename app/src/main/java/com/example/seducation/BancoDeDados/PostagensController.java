package com.example.seducation.BancoDeDados;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class PostagensController {
    private final List<Postagens> postagens;
    private Context contexto;
    private static PostagensController instancia = null;

    private PostagensController(Context contexto)
    {
        this.contexto = contexto;
        postagens = new ArrayList<>();
    }

    public static PostagensController getInstancia(Context contexto){
        if (instancia == null)
            instancia = new PostagensController(contexto);
        return instancia;
    }

    public boolean cadastrar(Postagens postagem){
        PostagemRepositorio funcionarioRepositorio = new PostagemRepositorio(contexto);
        long resultado = funcionarioRepositorio.inserir(postagem);
        if (resultado != -1)
            return true;
        else
            return false;
    }

    public List<Postagens> buscarTodos(){
        PostagemRepositorio postagemRepositorio = new PostagemRepositorio(contexto);
        List<Postagens> funcionarios = postagemRepositorio.buscarTodasPostagens();
        return funcionarios;
    }

    public Postagens buscarPorPosicao(int posicao)
    {
        return postagens.get(posicao);
    }

    public void atualizarLista(){
        postagens.clear();
        postagens.addAll(buscarTodos());
    }
}
