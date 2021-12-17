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

public class ConvertiTemp extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conv_temp);
        EditText editText = findViewById(R.id.editTextNumberDecimal);
        Spinner spinner = findViewById(R.id.spinner);
        Spinner spinner2 = findViewById(R.id.spinner2);
        Button button = findViewById(R.id.button);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.temperature, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        spinner2.setAdapter(adapter);
        spinner2.setOnItemSelectedListener(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sym = "";
                if(spinner.getSelectedItem().toString().equals("°C")) {
                    String str = editText.getText().toString();
                    double temp = Float.parseFloat(str);
                    sym = "°C";
                    if (spinner2.getSelectedItem().toString().equals("°F")) {
                        temp = temp* 9/5 + 32;
                        sym = "°F";
                    }
                    else if (spinner2.getSelectedItem().toString().equals("K")) {
                        temp = temp + 273.15;
                        sym = "K";
                    }
                    Toast.makeText(getApplicationContext(),String.format("%.2f",temp) + sym,Toast.LENGTH_SHORT).show();
                }
                else if(spinner.getSelectedItem().toString().equals("°F")){
                    String str = editText.getText().toString();
                    double temp = Float.parseFloat(str);
                    sym = "°F";
                    if(spinner2.getSelectedItem().toString().equals("°C")) {
                        temp = (temp-32)* 5/9;
                        sym = "°C";
                    }
                    else if (spinner2.getSelectedItem().toString().equals("K")) {
                        temp = (temp-32)*5/9 + 273.15;
                        sym = "K";
                    }
                    Toast.makeText(getApplicationContext(),String.format("%.2f",temp) + sym,Toast.LENGTH_SHORT).show();
                }
                else {
                    String str = editText.getText().toString();
                    double temp = Float.parseFloat(str);
                    sym = "K";
                    if(spinner2.getSelectedItem().toString().equals("°C")) {
                        temp = temp - 273.15;
                        sym = "°C";
                    }
                    else if (spinner2.getSelectedItem().toString().equals("°F")) {
                        temp = (temp - 273.15) * 9/5 + 32;
                        sym = "°F";
                    }
                    Toast.makeText(getApplicationContext(),String.format("%.2f",temp) + sym,Toast.LENGTH_SHORT).show();
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
