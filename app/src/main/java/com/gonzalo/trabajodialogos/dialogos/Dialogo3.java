package com.gonzalo.trabajodialogos.dialogos;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class Dialogo3 extends DialogFragment {
    final static String TAG_ARG1 = "clave";
    private String nombre;

    public static Dialogo3 newInstance(String nombre){
        Dialogo3 dialogoPerso = new Dialogo3();
        Bundle bundle = new Bundle();
        bundle.putString(TAG_ARG1,nombre);
        dialogoPerso.setArguments(bundle);
        return dialogoPerso;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        nombre = getArguments().getString(TAG_ARG1);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder dialogo = new AlertDialog.Builder(getContext());
        dialogo.setTitle("Diálogo 3");
        dialogo.setMessage("Perfecto "+nombre+", ahora tendrás que introducir una fecha y una hora, ¿OK?");
        dialogo.setPositiveButton("CONTINUAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Dialogo4 dialogo4 = new Dialogo4();
                dialogo4.show(getFragmentManager(),"cuatro");
            }
        });
        dialogo.setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dismiss();
            }
        });
        return dialogo.create();
    }
}