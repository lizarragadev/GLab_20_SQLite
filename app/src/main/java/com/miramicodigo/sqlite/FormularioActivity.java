package com.miramicodigo.sqlite;

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



        if (getIntent().getExtras() != null) {
            edicion = true;
            setTitle("Editar persona");



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


            finish();
        }
    }

    public void cancelar(View view) {
        finish();
    }

    @Override
    protected void onStop() {
        super.onStop();


    }

}
