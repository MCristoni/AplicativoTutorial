package com.matheuscristoni.tutoriais.adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.matheuscristoni.tutoriais.R;

import com.matheuscristoni.tutoriais.constantes.Item;


public class CustomDialog
{
    Dialog dialog = null;

    public void ShowDialog(Activity context, Item item)
    {
        dialog = new Dialog(context, R.style.dialog_theme);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.custom_dialog);

        TextView txtTitulo = (TextView) dialog.findViewById(R.id.txtTituloDialog);
        txtTitulo.setText(item.tituloDialog);

        TextView txtMensagem = (TextView) dialog.findViewById(R.id.txtMensagemDialog);
        txtMensagem.setText(item.textoDialog);

        Button button = (Button) dialog.findViewById(R.id.btnOkDialog);
        button.setText(context.getString(R.string.entendi));
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dialog.dismiss();
            }
        });

        dialog.setOnKeyListener(new DialogInterface.OnKeyListener()
        {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event)
            {
                if (keyCode == KeyEvent.KEYCODE_BACK)
                {
                    dialog.dismiss();
                    return true;
                }
                else
                {
                    return false;
                }
            }
        });

        dialog.onBackPressed();
        dialog.show();
    }


}
