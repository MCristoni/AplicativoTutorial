package adapters;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.matheuscristoni.tutoriais.R;

import constantes.Item;


public class CustomDialog
{
    Dialog dialog = null;

    public void ShowDialog(final Activity activity, Item item)
    {
        dialog = new Dialog(activity, R.style.dialog_theme);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.custom_dialog);

        TextView txtTitulo = (TextView) dialog.findViewById(R.id.txtTituloDialog);
        if (item.tituloInfo.isEmpty())
        {
            txtTitulo.setVisibility(View.GONE);
        }
        else
        {
            txtTitulo.setText(item.tituloInfo);
        }

        TextView txtMensagem = (TextView) dialog.findViewById(R.id.txtMensagemDialog);
        if (item.mensagemInfo.isEmpty())
        {
            txtMensagem.setVisibility(View.GONE);
        }
        else
        {
            txtMensagem.setText(item.mensagemInfo);
        }

        Button button = (Button) dialog.findViewById(R.id.btnOkDialog);
        button.setText(activity.getString(R.string.entendi));
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
