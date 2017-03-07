package com.matheuscristoni.tutoriais.activity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import livroandroid.lib.utils.*;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.matheuscristoni.tutoriais.R;

public class BaseActivity extends livroandroid.lib.activity.BaseActivity
{
    protected DrawerLayout drawerLayout;

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
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        actionBar.setDisplayHomeAsUpEnabled(true);

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
        int[][] states = new int[][] {
                new int[] { android.R.attr.state_checked},
                new int[] {-android.R.attr.state_checked} // unchecked
        };

        int[] colors = new int[] {
                getColor(R.color.android_icon),
                Color.BLACK
        };


        int[] colors2 = new int[] {
                getColor(R.color.blue),
                Color.BLACK
        };

        // TODO: 06/03/17 - Parei aqui, realizar para os 4 icones

        //Cor Android
        ColorStateList myList = new ColorStateList(states, colors);

        //Cor iOS
        ColorStateList myList2 = new ColorStateList(states, colors2);

        switch (menuItem.getItemId())
        {
            case R.id.nav_item_android:
                toast("Clicou em Android");
                break;

            default:
                toast("Clicou em Android");
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
}
