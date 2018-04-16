package com.example.alexa.carwiki.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.alexa.carwiki.Adapter.CarAdapter;
import com.example.alexa.carwiki.Model.Car;
import com.example.alexa.carwiki.R;

import java.util.ArrayList;

public class GalleryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_gallery);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setTitle("Car Wiki");

        ListView oldTimerGallery = findViewById(R.id.galleryView);

        CarAdapter carAdapter;
        carAdapter = new CarAdapter(this, (ArrayList<Car>) MainActivity.cars);
        oldTimerGallery.setAdapter(carAdapter);

        oldTimerGallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
                intent.putExtra("ContextItem",MainActivity.cars.get(i));
                startActivity(intent);
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if(id==R.id.actions_settings){
            Toast.makeText(this,"Setting",Toast.LENGTH_LONG).show();
        }
        if(id==R.id.actions_search){
            Toast.makeText(this,"Search",Toast.LENGTH_LONG).show();
        }
        if(id==R.id.actions_add){
            Intent intent = new Intent(getApplicationContext(), AddCarActivity.class);
            startActivity(intent);
        }
        if(id==R.id.actions_seeBrands){
            Intent intent = new Intent(getApplicationContext(), GalleryBrandsActivity.class);
            startActivity(intent);
        }
        if(id==R.id.actions_seeOwners){
            Intent intent = new Intent(getApplicationContext(), GalleryOwnersActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
