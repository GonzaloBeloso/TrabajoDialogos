package com.gonzalo.trabajodialogos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.gonzalo.trabajodialogos.dialogos.Dialogo1;
import com.gonzalo.trabajodialogos.dialogos.Dialogo5;
import com.gonzalo.trabajodialogos.dialogos.Dialogo6;

public class MainActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener,
        DatePickerDialog.OnDateSetListener, Dialogo6.OnDialogoSeisListener {

    TextView nota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
    }

    private void instancias() {
        nota = findViewById(R.id.notaView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principio,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()== R.id.lanzar){
            Dialogo1 dialogo1 = new Dialogo1();
            dialogo1.show(getSupportFragmentManager(),"uno");
        }
        return true;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Dialogo5 dialogo5 = new Dialogo5();
        dialogo5.show(getSupportFragmentManager(),"cinco");
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Dialogo6 dialogo6 = new Dialogo6();
        dialogo6.show(getSupportFragmentManager(),"seis");
    }

    @Override
    public void onDialogoSeis(String item) {
        nota.setText(item);
    }
}
