package com.matheuscristoni.tutoriais.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.matheuscristoni.tutoriais.R;

import java.util.List;

import com.matheuscristoni.tutoriais.constantes.Constantes;
import com.matheuscristoni.tutoriais.constantes.Item;

public class adapterListaAndroid extends BaseAdapter
{
    private List<Item> itens;
    private Activity context;

    public adapterListaAndroid(Activity mainActivity, List<Item> listaItens)
    {
        this.context = mainActivity;
        this.itens = listaItens;
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

        verificaPosicoes(position, itens.get(position),titulo, btnInfo, btnPrevia, btnCodigo);

        return view;
    }

    private void verificaPosicoes(int pos, final Item item, TextView titulo, ImageView btnInfo, Button btnPrevia, Button btnCodigo)
    {
        if (pos == Constantes.EFEITO_PRESSIONADO)
        {
            titulo.setText(item.tituloAdapter);
            btnInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CustomDialog dialog = new CustomDialog();
                    dialog.ShowDialog(context, item);
                }
            });
        }
    }
}