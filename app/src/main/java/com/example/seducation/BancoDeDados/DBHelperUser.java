package com.example.seducation.BancoDeDados;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelperUser extends SQLiteOpenHelper {

    protected static final String DB_USER = "Seducation";
    public static final int VERSAO = 1;

    public static final String TABELA_USUARIO = "usuario";
    public static final String ID_USUARIO = "id";
    public static final String NOME_USER = "nome";
    public static final String EMAIL_USUARIO = "email";
    public static final String SENHA_USUARIO = "senha";

    public static final String FOTO_USUARIO = "foto";
    public DBHelperUser(Context context) {
        super(context, DB_USER, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+TABELA_USUARIO+"("+ID_USUARIO+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                NOME_USER+" TEXT NOT NULL, "+
                EMAIL_USUARIO+" TEXT NOT NULL UNIQUE, "+
                SENHA_USUARIO+" TEXT NOT NULL, "+
                FOTO_USUARIO+" BLOB "+");";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
     String sql = "DROP TABLE IF EXISTS "+TABELA_USUARIO+";";
     db.execSQL(sql);
     onCreate(db);
    }
}
