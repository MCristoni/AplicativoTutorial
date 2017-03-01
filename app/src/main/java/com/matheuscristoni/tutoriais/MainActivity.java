package com.matheuscristoni.tutoriais;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import adapters.adapterLista;
import constantes.Constantes;
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

        List<String> listaItens = new ArrayList<>();
        lista.setAdapter(new adapterLista(this, listaItens, Constantes.ANDROID));
    }
}
