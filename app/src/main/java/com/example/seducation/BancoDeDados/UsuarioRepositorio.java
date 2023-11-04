package com.example.seducation.BancoDeDados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;

import android.graphics.BitmapFactory;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepositorio {
    private DBHelperUser helperUser;

    public UsuarioRepositorio(Context contexto) {
        helperUser = new DBHelperUser(contexto);
    }

    public long inserirUsuario(Usuario usuario) {
        SQLiteDatabase db = helperUser.getWritableDatabase();
        ContentValues valores = new ContentValues();

        valores.put(DBHelperUser.NOME_USER, usuario.getNome());
        valores.put(DBHelperUser.EMAIL_USUARIO, usuario.getEmail());
        valores.put(DBHelperUser.SENHA_USUARIO, usuario.getSenha());

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        usuario.getFoto().compress(Bitmap.CompressFormat.PNG, 100, stream);
        valores.put(DBHelperUser.FOTO_USUARIO, stream.toByteArray());
        long id = db.insert(DBHelperUser.TABELA_USUARIO, null, valores);
        db.close();
        return id;

    }

    public int verificar(String email) {
        int sim;
        SQLiteDatabase db = helperUser.getReadableDatabase();
        String sql = "Select * FROM " + DBHelperUser.TABELA_USUARIO + " WHERE email=" + email;

        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToNext()) {
            sim = 1;
        } else {
            sim = 0;
        }
        return sim;

    }


    public List<Usuario> buscarUsuario(String email){
        SQLiteDatabase db = helperUser.getReadableDatabase();
        String sql="Select id,nome, foto FROM "+DBHelperUser.TABELA_USUARIO +" WHERE email="+email;
        Cursor cursor = db.rawQuery(sql, null);
        List<Usuario> usuarios = new ArrayList<>();
        while(cursor.moveToNext()){
            int id = cursor.getInt(0);
            String nome = cursor.getString(1);
            byte[] stream = cursor.getBlob(2);
            Bitmap foto = BitmapFactory.decodeByteArray(stream, 0, stream.length);
            Usuario user = new Usuario(id, nome);
            usuarios.add(user);
        }
        cursor.close();
        db.close();
        return usuarios;
    }

}
