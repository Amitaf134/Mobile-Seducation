package com.example.seducation.BancoDeDados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class PostagemRepositorio {
    private DBHelperPostagens helper;
    static long id;
    public PostagemRepositorio(Context context){
        helper = new DBHelperPostagens(context);
    }

    public long inserir(Postagens postagens){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put(DBHelperPostagens.TEXTO_POSTAGENS, postagens.getTexto());
        id = db.insert(DBHelperPostagens.TABELA_POSTAGENS, null, valores);
        db.close();
        return id;
    }

    public List<Postagens> buscarTodasPostagens(){
        SQLiteDatabase db = helper.getReadableDatabase();
        String sql = "Select * FROM " +DBHelperPostagens.TABELA_POSTAGENS;
        Cursor cursor = db.rawQuery(sql, null);

        List<Postagens> postagens = new ArrayList<>();
        while(cursor.moveToNext()){
            long id = cursor.getLong(0);
            String texto = cursor.getString(1);
            Postagens postagem = new Postagens(id, texto);
            postagens.add(postagem);
        }
        cursor.close();
        db.close();
        return postagens;
    }
}
