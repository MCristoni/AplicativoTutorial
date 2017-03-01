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


public class CustomDialog
{
    Dialog dialog = null;

    public void ShowDialog(final Activity activity, String titulo, String mensagem, String txtBotao)
    {
        dialog = new Dialog(activity, R.style.dialog_theme);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.custom_dialog);

        TextView txtTitulo = (TextView) dialog.findViewById(R.id.txtTituloDialog);
        if (titulo.isEmpty())
        {
            txtTitulo.setVisibility(View.GONE);
        }
        else
        {
            txtTitulo.setText(titulo);
        }

        TextView txtMensagem = (TextView) dialog.findViewById(R.id.txtMensagemDialog);
        if (mensagem.isEmpty())
        {
            txtMensagem.setVisibility(View.GONE);
        }
        else
        {
            txtMensagem.setText(mensagem);
        }

        Button button = (Button) dialog.findViewById(R.id.btnOkDialog);
        button.setText(txtBotao);
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
