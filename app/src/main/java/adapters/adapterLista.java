package adapters;

import android.app.Activity;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.matheuscristoni.tutoriais.MainActivity;
import com.matheuscristoni.tutoriais.R;

import java.util.List;

import constantes.Constantes;
import constantes.Item;

public class adapterLista extends BaseAdapter
{
    private List<Item> itens;
    private Activity context;
    private int plataforma;

    public adapterLista(MainActivity mainActivity, List<Item> listaItens, int plat)
    {
        this.itens = listaItens;
        this.context = mainActivity;
        this.plataforma = plat;
    }

    @Override
    public int getCount()
    {
        return itens.size();
    }

    @Override
    public Object getItem(int position)
    {
        return itens.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(final int position, final View convertView, ViewGroup parent)
    {
        final View view = context.getLayoutInflater().inflate(R.layout.adapter, parent, false);
        TextView titulo = (TextView) view.findViewById(R.id.txtTituloAdapter);
        //TODO: 26/02/17 - setOnClickListener para gerar o modal - CustomDialog dialog = new CustomDialog();
        ImageView btnInfo = (ImageView) view.findViewById(R.id.btnInfo);
        // TODO: 26/02/17 - Fazer evento de clique de acordo com o tutorial
        Button btnPrevia = (Button) view.findViewById(R.id.btnPrevia);
        // TODO: 26/02/17 -  Fazer evento de clique de acordo com o tutorial
        Button btnCodigo = (Button) view.findViewById(R.id.btnCodigo);


        if (plataforma == Constantes.ANDROID)
        {
            verificaPosicoesAndroid(position, titulo, btnInfo, btnPrevia, btnPrevia);
        }
        else if (plataforma == Constantes.IOS)
        {
            verificaPosicoesIOS(position);
        }
        else if (plataforma == Constantes.XAMARIN_ANDROID)
        {
            verificaPosicoesXamarinAndroid(position);
        }
        else if (plataforma == Constantes.XAMARIN_IOS)
        {
            verificaPosicoesXamarinIOS(position);
        }

        return view;
    }

    private void verificaPosicoesAndroid(int pos, TextView titulo, ImageView btnInfo, Button previa, Button btnPrevia)
    {
        Item obj = new Item();
        if (pos == Constantes.EFEITO_PRESSIONADO)
        {
            obj.titulo = context.getString(R.string.tituloEfeitoPressionado);
            obj.mensagem = context.getString(R.string.textoEfeitoPressionado);
        }
    }

    private void verificaPosicoesIOS(int pos)
    {
        Objeto obj = new Objeto();
        if (pos == Constantes.EFEITO_PRESSIONADO)
        {

        }
    }

    private void verificaPosicoesXamarinAndroid(int pos)
    {
        Objeto obj = new Objeto();
        if (pos == Constantes.EFEITO_PRESSIONADO)
        {
            if (pos == Constantes.EFEITO_PRESSIONADO)
            {
                obj.titulo = context.getString(R.string.tituloEfeitoPressionado);
                obj.mensagem = context.getString(R.string.textoEfeitoPressionado);
            }
        }
    }

    private void verificaPosicoesXamarinIOS(int pos)
    {
        Objeto obj = new Objeto();
        if (pos == Constantes.EFEITO_PRESSIONADO)
        {

        }
    }
}