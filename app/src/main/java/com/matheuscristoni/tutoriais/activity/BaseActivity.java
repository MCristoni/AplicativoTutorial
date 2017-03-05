package com.matheuscristoni.tutoriais.activity;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.matheuscristoni.tutoriais.R;

public class BaseActivity extends AppCompatActivity
{
    protected void setUpToolbar()
    {
        Toolbar mToolbar = (Toolbar) findViewById(R.id.tb_main);
        if (mToolbar != null)
        {
            setSupportActionBar(mToolbar);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu)
    {
        menu.clear();
        getMenuInflater().inflate(R.menu.menu_actionbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        View view = findViewById(R.id.root_view);
        switch (item.getItemId())
        {
            case (R.id.teste):
                Snackbar.make(view, "Teste", Snackbar.LENGTH_INDEFINITE).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
