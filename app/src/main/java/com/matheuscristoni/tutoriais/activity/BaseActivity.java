package com.matheuscristoni.tutoriais.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.util.Log;
import android.widget.Toast;

import com.matheuscristoni.tutoriais.R;

public class BaseActivity extends AppCompatActivity
{
    protected DrawerLayout drawerLayout;
    private static final String TAG = "Erros";

    //Configura Toolbar
    protected void setUpToolbar()
    {
        Toolbar mToolbar = (Toolbar) findViewById(R.id.tb_main);
        if (mToolbar != null)
        {
            setSupportActionBar(mToolbar);
        }
    }

    //Configura Navigation Drawer
    protected void setupNavigationDrawer()
    {
        //Drawer layout
        final ActionBar actionBar = getSupportActionBar();

        //Ícone
        try
        {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        catch (NullPointerException e)
        {
            Log.e(TAG, e.getMessage());
        }

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        final NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null && drawerLayout != null)
        {
            setNavViewValues(navigationView, R.string.nav_drawer_username, R.string.nav_drawer_email, R.mipmap.ic_launcher);
            navigationView.getMenu().getItem(0).setChecked(true);
            navigationView.setItemIconTintList(null);


            navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
            {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
                {
                    //Seleciona a linha
                    menuItem.setChecked(true);

                    //Fecha o menu
                    drawerLayout.closeDrawers();

                    //Trata evento menu
                    onNavDrawerItemSelected(menuItem, navigationView);

                    return true;
                }
            });
        }
    }

    //Atualiza os dados do header do Navigation View
    public  static void setNavViewValues(NavigationView navView, int nome, int email, int img)
    {
        View headerView = navView.getHeaderView(0);
        TextView txtNome = (TextView) headerView.findViewById(R.id.txtUserName);
        TextView txtEmail = (TextView) headerView.findViewById(R.id.txtUserEmail);
        ImageView imgNav = (ImageView) headerView.findViewById(R.id.imgUserPhoto);

        txtNome.setText(nome);
        txtEmail.setText(email);
        imgNav.setImageResource(img);
    }

    //Trata eventos do menu lateral
    private void onNavDrawerItemSelected(MenuItem menuItem, NavigationView navigationView)
    {
        switch (menuItem.getItemId())
        {
            case R.id.nav_item_android:
                Toast.makeText(this, "Clicou em Android", Toast.LENGTH_SHORT).show();
                break;

            default:
                Toast.makeText(this, "Clicou em Android", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        View view = findViewById(R.id.root_view);
        switch (item.getItemId())
        {
            case android.R.id.home:
                //Trata clique no botão menu
                if (drawerLayout != null)
                {
                    openDrawer();
                    return true;
                }

            case (R.id.teste):
                Snackbar.make(view, "Teste", Snackbar.LENGTH_INDEFINITE).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //Abre menu lateral
    protected void openDrawer()
    {
        if (drawerLayout != null)
        {
            drawerLayout.openDrawer(GravityCompat.START);
        }
    }

    //Fecha menu lateral
    protected void closeDrawer()
    {
        if (drawerLayout != null)
        {
            drawerLayout.closeDrawer(GravityCompat.START);
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
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Log.i(TAG, getClassName() + ".onCreate() chamado: " + savedInstanceState);
    }

    @Override
    protected void onStart()
    {
        super.onStart();
	    Log.i(TAG, getClassName() + ".onStart() chamado.");
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
	    Log.i(TAG, getClassName() + ".onRestart() chamado. ");
    }

    @Override
    protected void onResume()
    {
        super.onResume();
	    Log.i(TAG, getClassName() + ".onResume() chamado.");
    }

    @Override
    protected void onPause()
    {
        super.onPause();
	    Log.i(TAG, getClassName() + ".onPause() chamado. ");
    }
	
	@Override
	public void onSaveInstanceState(Bundle outState)
	{
		super.onSaveInstanceState(outState);
		Log.i(TAG, getClassName() + ".onSaveInstanceState() chamado. ");
	}
	
	@Override
	protected void onStop()
	{
		super.onStop();
		Log.i(TAG, getClassName() + ".onStop() chamado.");
	}
	
	@Override
	protected void onDestroy()
	{
		super.onDestroy();
		Log.i(TAG, getClassName() + ".onDestroy() chamado. ");
	}
	
	private String getClassName()
	{
		String s = getClass().getName();
		return s.substring(s.lastIndexOf(".")+1);
	}
}
