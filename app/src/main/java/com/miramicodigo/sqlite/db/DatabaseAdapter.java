package com.miramicodigo.sqlite.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseAdapter{

    private PersonasDatabaseHelper databaseHelper;
    private SQLiteDatabase db;

    public DatabaseAdapter(Context context) {

    }

    public void abrir() {

    }

    public void cerrar() {

    }

    public long adicionarPersona(String nombre, long telefono, String correo, String genero) {

        return 0;
    }

    public int actualizarPersona(long id, String nombre, long telefono, String correo, String genero) {


        return 0;
    }

    public boolean eliminarPersona(long id) {

        return false;
    }

    public Cursor obtenerPersona(long id) {

        return null;
    }

    public Cursor obtenerTodasPersonas() {

        return null;
    }

    private static class PersonasDatabaseHelper extends SQLiteOpenHelper {

        public PersonasDatabaseHelper(Context context) {
            super(context, "dbpersonas.db", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {



        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS persona");
            onCreate(db);
        }
    }
}
