package com.matheuscristoni.tutoriais.activity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import com.matheuscristoni.tutoriais.R;
import com.matheuscristoni.tutoriais.adapter.adapterListaAndroid;

import com.matheuscristoni.tutoriais.constantes.Item;

public class MainActivity extends BaseActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolbar();
        setupNavigationDrawer();

        ListView lista = (ListView) findViewById(R.id.listaTeste);
        List<Item> listaItens = new ArrayList<>();
        listaItens.add(new Item(this, R.string.titulo_Efeito_Pressionado, R.string.texto_Efeito_Pressionado));
        lista.setAdapter(new adapterListaAndroid(this, listaItens));
    }
}
