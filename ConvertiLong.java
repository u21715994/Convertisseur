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


public class ConvertiLong extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conv_long);
        EditText editText = findViewById(R.id.editTextNumberDecimal);
        Spinner spinner = findViewById(R.id.spinner);
        Spinner spinner2 = findViewById(R.id.spinner2);
        Button button = findViewById(R.id.button);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.longueur, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        spinner2.setAdapter(adapter);
        spinner2.setOnItemSelectedListener(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sym = "";
                if(spinner.getSelectedItem().toString().equals("m")) {
                    String str = editText.getText().toString();
                    double ms = Float.parseFloat(str);
                    sym = "m";
                    if (spinner2.getSelectedItem().toString().equals("km")) {
                        ms = ms / 1000;
                        sym = "km";
                    }
                    else if (spinner2.getSelectedItem().toString().equals("yd")) {
                        ms = ms * 1.094;
                        sym = "yd";
                    }
                    else if (spinner2.getSelectedItem().toString().equals("mi")) {
                        ms = ms * 0.000621;
                        sym = "mi";
                    }
                    Toast.makeText(getApplicationContext(),Float.toString(new Float(ms)) + sym,Toast.LENGTH_SHORT).show();
                }
                else if(spinner.getSelectedItem().toString().equals("yd")){
                    String str = editText.getText().toString();
                    double ms = Float.parseFloat(str);
                    sym = "yd";
                    if(spinner2.getSelectedItem().toString().equals("m")) {
                        ms = ms * 0.914;
                        sym = "m";
                    }
                    else if (spinner2.getSelectedItem().toString().equals("km")) {
                        ms = ms * 0.0009144;
                        sym = "km";
                    }
                    else if (spinner2.getSelectedItem().toString().equals("mi")) {
                        ms = ms * 0.000568;
                        sym = "mi";
                    }
                    Toast.makeText(getApplicationContext(),Float.toString(new Float(ms)) + sym,Toast.LENGTH_SHORT).show();
                }
                else if (spinner.getSelectedItem().toString().equals("mi")){
                    String str = editText.getText().toString();
                    double ms = Float.parseFloat(str);
                    sym = "mi";
                    if(spinner2.getSelectedItem().toString().equals("m")) {
                        ms = ms * 1609.344;
                        sym = "m";
                    }
                    if (spinner2.getSelectedItem().toString().equals("km")) {
                        ms = ms * 1.60934;
                        sym = "km";
                    }
                    else if (spinner2.getSelectedItem().toString().equals("yd")) {
                        ms = ms * 1760;
                        sym = "yd";
                    }
                    Toast.makeText(getApplicationContext(),Float.toString(new Float(ms)) + sym,Toast.LENGTH_SHORT).show();
                }
                else{
                    String str = editText.getText().toString();
                    double ms = Float.parseFloat(str);
                    sym = "km";
                    if(spinner2.getSelectedItem().toString().equals("m")) {
                        ms = ms * 1000;
                        sym = "m";
                    }
                    if (spinner2.getSelectedItem().toString().equals("mi")) {
                        ms = ms * 0.621371;
                        sym = "mi";
                    }
                    else if (spinner2.getSelectedItem().toString().equals("yd")) {
                        ms = ms * 1093.61;
                        sym = "yd";
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
