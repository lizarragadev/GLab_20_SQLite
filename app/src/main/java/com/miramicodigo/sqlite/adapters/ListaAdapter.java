package com.miramicodigo.sqlite.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.miramicodigo.sqlite.R;

import java.util.ArrayList;

public class ListaAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private ArrayList<Integer> imagenes;
    private ArrayList<String> textosPrincipales;
    private ArrayList<String> textosSecundarios;

    public ListaAdapter(Context contexto) {
        inflater = LayoutInflater.from(contexto);
        imagenes = new ArrayList<Integer>();
        textosPrincipales = new ArrayList<String>();
        textosSecundarios = new ArrayList<String>();
    }

    @Override
    public int getCount() {
        return textosPrincipales.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = inflater.inflate(R.layout.item_lista, null);
            holder = new ViewHolder();
            holder.ivImagen = (ImageView) view.findViewById(R.id.ivImageItem);
            holder.tvTitulo = (TextView) view.findViewById(R.id.tvPrincipalItem);
            holder.tvSubtitulo = (TextView) view.findViewById(R.id.tvSecundarioItem);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.ivImagen.setImageResource(imagenes.get(i));
        holder.tvTitulo.setText(textosPrincipales.get(i));
        holder.tvSubtitulo.setText(textosSecundarios.get(i));
        return view;
    }


    static class ViewHolder {
        ImageView ivImagen;
        TextView tvTitulo;
        TextView tvSubtitulo;
    }

    public void adicionarItem(int idRecurso, String textoPrincipal,
                              String textoSecundario) {
        imagenes.add(idRecurso);
        textosPrincipales.add(textoPrincipal);
        textosSecundarios.add(textoSecundario);
        notifyDataSetChanged();
    }

    public void eliminarTodo() {
        imagenes.clear();
        textosPrincipales.clear();
        textosSecundarios.clear();
        notifyDataSetChanged();
    }
}