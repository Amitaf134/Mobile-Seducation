package com.example.seducation.BancoDeDados;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.seducation.R;

import java.util.List;

public class ListaPostagemAdapter extends BaseAdapter {
    Context context;
    PostagensController postagensController;
    public List<Postagens> postagens;

    public ListaPostagemAdapter(Context context){
        this.context = context;
        postagensController = PostagensController.getInstancia(context);
        postagens = postagensController.buscarTodos();
        atualizarLista();
    }
    @Override
    public int getCount() {
        return postagens.size();
    }

    @Override
    public Object getItem(int position) {
        return postagens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return postagens.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = LayoutInflater.from(context)
                .inflate(
                        R.layout.lista_postagens,
                        parent,
                        false);
        TextView textViewNome = v.findViewById(R.id.text_nome_user);
        TextView texto = v.findViewById(R.id.text_postagem);
        ImageView imageViewFoto = v.findViewById(R.id.img_usuario);

        Postagens postagem = postagens.get(position);
        texto.setText(postagem.getTexto());

        return v;
    }
    public void atualizarLista(){
        postagens.clear();
        postagens.addAll(postagensController.buscarTodos());
        notifyDataSetChanged();
    }
}
