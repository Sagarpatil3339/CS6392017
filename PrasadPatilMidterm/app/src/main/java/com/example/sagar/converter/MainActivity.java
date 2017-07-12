package com.example.sagar.converter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText dollars = (EditText) findViewById(R.id.Dollars);
        final EditText francs = (EditText) findViewById(R.id.Francs);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double dollar = Double.valueOf(dollars.getText().toString());
                double franc = dollar * 586.84;
                francs.setText(String.valueOf(franc));
            }
        });

    }
}
