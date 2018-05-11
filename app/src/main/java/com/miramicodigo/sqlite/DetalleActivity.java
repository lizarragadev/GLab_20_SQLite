package com.miramicodigo.sqlite;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.miramicodigo.sqlite.db.DatabaseAdapter;

import java.text.Normalizer;

public class DetalleActivity extends AppCompatActivity {


    private ImageView ivImagen;
    private TextView tvNombre;
    private TextView tvTelefono;
    private TextView tvCorreo;
    private TextView tvGenero;

    private long id;
    private DatabaseAdapter db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        setTitle("Detalle");

        ivImagen = (ImageView) findViewById(R.id.ivImagen);
        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvCorreo = (TextView) findViewById(R.id.tvCorreo);
        tvGenero = (TextView) findViewById(R.id.tvGenero);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_detalle, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_editar:


                break;
            case R.id.menu_eliminar:


                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStop() {
        super.onStop();


    }

}
