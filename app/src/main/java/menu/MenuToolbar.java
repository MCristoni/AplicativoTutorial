package menu;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.matheuscristoni.tutoriais.R;

public class MenuToolbar extends AppCompatActivity
{
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
