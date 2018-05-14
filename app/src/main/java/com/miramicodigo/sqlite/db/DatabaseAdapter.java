package com.miramicodigo.sqlite.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseAdapter{

    private PersonasDatabaseHelper databaseHelper;
    private SQLiteDatabase db;

    public DatabaseAdapter(Context context) {
        databaseHelper = new PersonasDatabaseHelper(context);
    }

    public void abrir() {
        db = databaseHelper.getWritableDatabase();
    }

    public void cerrar() {
        databaseHelper.close();
    }

    public long adicionarPersona(String nombre, long telefono, String correo, String genero) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("nombre", nombre);
        contentValues.put("telefono", telefono);
        contentValues.put("correo", correo);
        contentValues.put("genero", genero);
        return db.insert("persona", null, contentValues);
    }

    public int actualizarPersona(long id, String nombre, long telefono,
                                 String correo, String genero) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("nombre", nombre);
        contentValues.put("telefono", telefono);
        contentValues.put("correo", correo);
        contentValues.put("genero", genero);
        return db.update("persona", contentValues, "_id=?", new String[]{id+""});
    }

    public boolean eliminarPersona(long id) {
        return db.delete("persona", "_id="+id, null) > 0;
    }

    public Cursor obtenerPersona(long id) {
        System.out.println(" ******************* > "+ id);
        return db.query("persona",
                new String[]{"_id", "nombre", "telefono", "correo", "genero"},
                "_id=?", new String[]{id+""}, null, null, null);
    }

    public Cursor obtenerTodasPersonas() {
        return db.query("persona",
                new String[]{"_id", "nombre", "telefono", "correo", "genero"},
                null, null, null, null, null);
    }

    private static class PersonasDatabaseHelper extends SQLiteOpenHelper {

        public PersonasDatabaseHelper(Context context) {
            super(context, "dbpersonas.db", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE persona (" +
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT NOT NULL, " +
                    "telefono INTEGER, correo TEXT, genero TEXT)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS persona");
            onCreate(db);
        }
    }
}
