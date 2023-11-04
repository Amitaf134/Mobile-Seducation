package com.example.seducation.BancoDeDados;

import static com.example.seducation.BancoDeDados.DBHelperUser.DB_USER;
import static com.example.seducation.BancoDeDados.DBHelperUser.VERSAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelperPostagens extends SQLiteOpenHelper {

    private static final String DB_POSTAGENS = DB_USER;
    public static final String TABELA_POSTAGENS = "postagens";
    public static final String ID_POSTAGENS = "id_post";
    public static final String TEXTO_POSTAGENS = "texto_post";

    public DBHelperPostagens(Context context) {
        super(context, DB_POSTAGENS, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+TABELA_POSTAGENS+"("+
                ID_POSTAGENS+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                TEXTO_POSTAGENS+" TEXT NOT NULL"+
                ");";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS "+TABELA_POSTAGENS+";";
        db.execSQL(sql);
        onCreate(db);
    }
}
