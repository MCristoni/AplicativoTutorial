package com.matheuscristoni.tutoriais;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import adapters.adapterListaAndroid;
import constantes.Constantes;
import constantes.Item;
import menu.MenuToolbar;

public class MainActivity extends MenuToolbar
{
    private Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.tb_main);
        setSupportActionBar(mToolbar);

        ListView lista = (ListView) findViewById(R.id.listaTeste);

        List<Item> listaItens = new ArrayList<>();
        listaItens.add(new Item(this, R.string.tituloEfeitoPressionado, R.string.textoEfeitoPressionado));
        lista.setAdapter(new adapterListaAndroid(this, listaItens));
    }
}
