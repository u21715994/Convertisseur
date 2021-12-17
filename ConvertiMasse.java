package com.example.convertisseur;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class ConvertiMasse extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conv_masse);
        EditText editText = findViewById(R.id.editTextNumberDecimal);
        Spinner spinner = findViewById(R.id.spinner);
        Spinner spinner2 = findViewById(R.id.spinner2);
        Button button = findViewById(R.id.button);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.masse, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        spinner2.setAdapter(adapter);
        spinner2.setOnItemSelectedListener(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sym = "";
                if(spinner.getSelectedItem().toString().equals("g")) {
                    String str = editText.getText().toString();
                    double ms = Float.parseFloat(str);
                    sym = "g";
                    if (spinner2.getSelectedItem().toString().equals("lb")) {
                        ms = ms * 0.0022;
                        sym = "lb";
                    }
                    else if (spinner2.getSelectedItem().toString().equals("kg")) {
                        ms = ms / 1000;
                        sym = "kg";
                    }
                    Toast.makeText(getApplicationContext(),Float.toString(new Float(ms)) + sym,Toast.LENGTH_SHORT).show();
                }
                else if (spinner.getSelectedItem().toString().equals("lb")){
                    String str = editText.getText().toString();
                    double ms = Float.parseFloat(str);
                    sym = "lb";
                    if(spinner2.getSelectedItem().toString().equals("g")) {
                        ms = ms * 453.592;
                        sym = "g";
                    }
                    else if (spinner2.getSelectedItem().toString().equals("kg")) {
                        ms = ms * 0.453592;
                        sym = "kg";
                    }
                    Toast.makeText(getApplicationContext(),Float.toString(new Float(ms)) + sym,Toast.LENGTH_SHORT).show();
                }
                else{
                    String str = editText.getText().toString();
                    double ms = Float.parseFloat(str);
                    sym = "kg";
                    if(spinner2.getSelectedItem().toString().equals("g")) {
                        ms = ms * 1000;
                        sym = "g";
                    }
                    else if (spinner2.getSelectedItem().toString().equals("lb")) {
                        ms = ms * 2.20462;
                        sym = "lb";
                    }
                    Toast.makeText(getApplicationContext(),Float.toString(new Float(ms)) + sym,Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}