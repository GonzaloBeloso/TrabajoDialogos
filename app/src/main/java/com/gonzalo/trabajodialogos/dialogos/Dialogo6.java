package com.gonzalo.trabajodialogos.dialogos;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.gonzalo.trabajodialogos.R;

import java.util.ArrayList;

public class Dialogo6 extends DialogFragment {
    private View v;
    private Spinner spinnerNota;
    private ArrayList notas;
    private ArrayAdapter adaptadorNota;
    private OnDialogoSeisListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        v = LayoutInflater.from(getContext()).inflate(R.layout.layout_dialogo6,null);
        spinnerNota = v.findViewById(R.id.numeroNota);
        notas = new ArrayList();
        notas.add(1);notas.add(2);notas.add(3);notas.add(4);notas.add(5);
        notas.add(6);notas.add(7);notas.add(8);notas.add(9);notas.add(10);
        adaptadorNota = new ArrayAdapter(getContext(),android.R.layout.simple_spinner_item, notas);
        spinnerNota.setAdapter(adaptadorNota);
        listener = (OnDialogoSeisListener) context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder dialogo = new AlertDialog.Builder(getContext());
        dialogo.setTitle("Diálogo 6");
        dialogo.setMessage("Introduce la nota que consideras que vas a sacar en el examen");
        dialogo.setPositiveButton("CONTINUAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                listener.onDialogoSeis(String.valueOf(adaptadorNota.getItem(spinnerNota.getSelectedItemPosition())));
            }
        });
        dialogo.setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                dismiss();
            }
        });
        dialogo.setView(v);
        return dialogo.create();
    }

    public interface OnDialogoSeisListener{
        void onDialogoSeis(String item);
    }
}