package com.example.sagar.asynctaskproject;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    ImageView imgv1 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        imgv1 = (ImageView) findViewById(R.id.imgv1);
        new ImageLoading().execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public class ImageLoading extends AsyncTask<String, Void, Bitmap> {
        @Override
        protected Bitmap doInBackground(String... params) {
            Bitmap bmpa =null;
            try{

                URL url = new URL("https://raw.githubusercontent.com/Sagarpatil3339/CS6392017/master/Mumbai(BirthPlace).jpeg");
                HttpURLConnection con = (HttpURLConnection)url.openConnection();
                if(con.getResponseCode() != 200){
                    throw new Exception("Failed to connect");
                }

                InputStream is = con.getInputStream();
                is.close();
                bmpa = BitmapFactory.decodeStream(is);
            }catch (Exception e){
                Log.e("Image", "Failed to load image", e);
                Log.e("error", e.getMessage());
            }
            return bmpa;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            imgv1.setImageBitmap(result);

        }
    }
}