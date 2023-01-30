package com.rzaninelli.spinner03;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerPaises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerPaises = findViewById(R.id.spinnerPaises);

        popularSpinnerPaises();
    }

    public void popularSpinnerPaises(){
        String[] nomes = getResources().getStringArray(R.array.nomes_paises);
        TypedArray bandeiras = getResources().obtainTypedArray(R.array.bandeiras_paises);

        ArrayList<Pais> paises = new ArrayList<>();

        for (int cont = 0; cont < nomes.length; cont++) {
            paises.add(new Pais(nomes[cont], bandeiras.getDrawable(cont)));
        }

        PaisAdapter paisAdapter = new PaisAdapter(this, paises);

        spinnerPaises.setAdapter(paisAdapter);
    }

    public void mostrarSelecionado(View view) {
        Pais pais = (Pais) spinnerPaises.getSelectedItem();

        Toast.makeText(this, "O País " + pais.getNome() + " foi selecionado!", Toast.LENGTH_SHORT).show();
    }
}