package com.example.spinner;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Spinner unitSpinner;
    Spinner unnitSpinner;
    TextView selectedUnitTextView;
    TextView selectedUnnitTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Upewnij się, że to jest Twój layout

        unitSpinner = findViewById(R.id.unitSpinner);
        unnitSpinner = findViewById(R.id.unnitSpinner);
        selectedUnitTextView = findViewById(R.id.selectedUnitTextView);
        selectedUnnitTextView = findViewById(R.id.selectedUnnitTextView);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.length_units_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        unitSpinner.setAdapter(adapter);

        adapter = ArrayAdapter.createFromResource(this,
                R.array.rodzaj_ciasta, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        unnitSpinner.setAdapter(adapter);

        unitSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedUnit = parent.getItemAtPosition(position).toString();
                selectedUnitTextView.setText("Rozmiar: " + selectedUnit);
            }







            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selectedUnitTextView.setText("Rozmiar: -");
            }

        });
        unnitSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedUnit = parent.getItemAtPosition(position).toString();
                selectedUnnitTextView.setText("Rodzaj: " + selectedUnit);
            }
            public void onNothingSelected(AdapterView<?> parent) {
                selectedUnnitTextView.setText("Rodzaj: -");
            }

        });
        }
    }
