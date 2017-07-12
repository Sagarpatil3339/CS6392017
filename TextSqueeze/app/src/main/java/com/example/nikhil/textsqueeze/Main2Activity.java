package com.example.nikhil.textsqueeze;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    EditText editText2;
    public final static String Data_Key = "com.example.nikhil.textsqueeze.data_key";
    private ClipboardManager cpm;
    private ClipData cd;
    Button CpyBtn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        String data = intent.getStringExtra(Data_Key);

        editText2 = (EditText) findViewById(R.id.Edtxt2);
        editText2.setText(data);

        CpyBtn1 = (Button) findViewById(R.id.CpyBtn);

        cpm = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);

        CpyBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String datacopy = editText2.getText().toString();
                cd = ClipData.newPlainText("datacopy", datacopy);
                cpm.setPrimaryClip(cd);

                Toast.makeText(getApplicationContext(), "Copied to Clipboard", Toast.LENGTH_SHORT).show();
            }
        });




        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    public void ShareBtn(View view){
        final Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        editText2 = (EditText) findViewById(R.id.Edtxt2);
        String datashare = editText2.getText().toString();
        startActivity(Intent.createChooser(intent, datashare));
    }



}
