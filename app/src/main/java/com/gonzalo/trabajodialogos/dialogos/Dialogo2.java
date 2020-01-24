package com.gonzalo.trabajodialogos.dialogos;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.gonzalo.trabajodialogos.R;

public class Dialogo2 extends DialogFragment {
    View v;
    EditText nombreTxt;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        v = LayoutInflater.from(getContext()).inflate(R.layout.layout_dialogo2,null);
        nombreTxt = v.findViewById(R.id.nombreTxt);

    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder dialogo = new AlertDialog.Builder(getContext());
        dialogo.setTitle("Diálogo 2");
        dialogo.setMessage("Introduce tu nombre");
        dialogo.setPositiveButton("CONTINUAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Dialogo3 dialogo3 = Dialogo3.newInstance(nombreTxt.getText().toString());
                dialogo3.show(getFragmentManager(),"tres");
            }
        });
        dialogo.setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dismiss();
            }
        });
        dialogo.setView(v);
        return dialogo.create();
    }
}

