package com.miramicodigo.sqlite;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.miramicodigo.sqlite.db.DatabaseAdapter;

public class FormularioActivity extends AppCompatActivity {

    private DatabaseAdapter db;

    private EditText etNombre;
    private EditText etTelefono;
    private EditText etCorreo;
    private RadioButton rbMasculino;
    private RadioButton rbFemenino;

    private boolean edicion;

    private long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        etNombre = (EditText) findViewById(R.id.etNombre);
        etTelefono = (EditText) findViewById(R.id.etTelefono);
        etCorreo = (EditText) findViewById(R.id.etCorreo);
        rbMasculino = (RadioButton) findViewById(R.id.rbMasculino);
        rbFemenino = (RadioButton) findViewById(R.id.rbFemenino);

        db = new DatabaseAdapter(this);
        db.abrir();

        // onCreate, onStart, onResume
        // onStop, onDestroy

        if (getIntent().getExtras() != null) {
            edicion = true;
            setTitle("Editar persona");
            id = getIntent().getLongExtra("id", 0);
            Cursor cursor = db.obtenerPersona(id);
            if(cursor.moveToFirst()) {
                String nombre = cursor.getString(1);
                String telefono = cursor.getString(2);
                String correo = cursor.getString(3);
                String genero = cursor.getString(4);

                etNombre.setText(nombre);
                etTelefono.setText(telefono);
                etCorreo.setText(correo);
                if(genero.equalsIgnoreCase("m")) {
                    rbMasculino.setChecked(true);
                } else {
                    rbFemenino.setChecked(true);
                }
            }
        } else {
            edicion = false;
            setTitle("Nueva persona");
        }

    }

    public void aceptar(View view) {
        if(etNombre.getText().toString().equals("") ||
                etCorreo.getText().toString().equals("") ||
                etTelefono.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Hay campos vacios", Toast.LENGTH_LONG).show();
        } else {
            String nombre = etNombre.getText().toString();
            long telefono = Long.parseLong(etTelefono.getText().toString());
            String correo = etCorreo.getText().toString();
            String genero = rbMasculino.isChecked() ? "m" : "f";
            if (edicion) {
                db.actualizarPersona(id, nombre, telefono, correo, genero);
            } else {
                db.adicionarPersona(nombre, telefono, correo, genero);
            }
            finish();
        }
    }

    public void cancelar(View view) {
        finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
        db.cerrar();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
