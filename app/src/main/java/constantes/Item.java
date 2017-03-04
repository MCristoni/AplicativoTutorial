package constantes;

import android.app.Activity;

/**
 * Created by matheuscristoni on 28/02/17.
 */

public class Item
{
    public String tituloAdapter;
    public String tituloDialog;
    public String textoDialog;

    public Item(){ }

    public Item(Activity activity, int titulos, int textoDialog)
    {
        this.tituloAdapter =  activity.getString(titulos);
        this.tituloDialog = activity.getString(titulos);
        this.textoDialog = activity.getString(textoDialog);
    }
}
