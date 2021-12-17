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

public class ConvertiMonnaie extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conv_monnaie);
        EditText editText = findViewById(R.id.editTextNumberDecimal);
        Spinner spinner = findViewById(R.id.spinner);
        Spinner spinner2 = findViewById(R.id.spinner2);
        Button button = findViewById(R.id.button);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.monnaie, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        spinner2.setAdapter(adapter);
        spinner2.setOnItemSelectedListener(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sym = "";
                if(spinner.getSelectedItem().toString().equals("€")) {
                    String str = editText.getText().toString();
                    double arg = Float.parseFloat(str);
                    sym = "€";
                    if (spinner2.getSelectedItem().toString().equals("$")) {
                        arg = arg * 1.17;
                        sym = "$";
                    }
                    else if (spinner2.getSelectedItem().toString().equals("£")) {
                        arg = arg * 0.86;
                        sym = "£";
                    }
                    else if (spinner2.getSelectedItem().toString().equals("¥")) {
                        arg = arg * 128.35;
                        sym = "¥";
                    }
                    Toast.makeText(getApplicationContext(),String.format("%.2f",arg) + sym,Toast.LENGTH_SHORT).show();
                }
                else if(spinner.getSelectedItem().toString().equals("£")){
                    String str = editText.getText().toString();
                    double arg = Float.parseFloat(str);
                    sym = "£";
                    if(spinner2.getSelectedItem().toString().equals("€")) {
                        arg = arg * 1.16;
                        sym = "€";
                    }
                    else if (spinner2.getSelectedItem().toString().equals("$")) {
                        arg = arg * 1.37;
                        sym = "$";
                    }
                    else if (spinner2.getSelectedItem().toString().equals("¥")) {
                        arg = arg * 149.36;
                        sym = "¥";
                    }
                    Toast.makeText(getApplicationContext(),String.format("%.2f",arg) + sym,Toast.LENGTH_SHORT).show();
                }
                else if(spinner.getSelectedItem().toString().equals("$")){
                    String str = editText.getText().toString();
                    double arg = Float.parseFloat(str);
                    sym = "$";
                    if(spinner2.getSelectedItem().toString().equals("€")) {
                        arg = arg * 0.85;
                        sym = "€";
                    }
                    else if (spinner2.getSelectedItem().toString().equals("£")) {
                        arg = arg * 0.73;
                        sym = "£";
                    }
                    else if (spinner2.getSelectedItem().toString().equals("¥")) {
                        arg = arg * 109.41;
                        sym = "¥";
                    }
                    Toast.makeText(getApplicationContext(),String.format("%.2f",arg) + sym,Toast.LENGTH_SHORT).show();
                }
                else {
                    String str = editText.getText().toString();
                    double arg = Float.parseFloat(str);
                    sym = "¥";
                    if(spinner2.getSelectedItem().toString().equals("€")) {
                        arg = arg * 0.0078;
                        sym = "€";
                    }
                    else if (spinner2.getSelectedItem().toString().equals("£")) {
                        arg = arg * 0.0067;
                        sym = "£";
                    }
                    else if (spinner2.getSelectedItem().toString().equals("$")) {
                        arg = arg * 0.0091;
                        sym = "$";
                    }
                    Toast.makeText(getApplicationContext(),String.format("%.2f",arg) + sym,Toast.LENGTH_SHORT).show();
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