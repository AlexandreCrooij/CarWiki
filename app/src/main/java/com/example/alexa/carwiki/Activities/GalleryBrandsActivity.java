package com.example.alexa.carwiki.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.alexa.carwiki.Adapter.BrandAdapter;
import com.example.alexa.carwiki.Model.CarBrand;
import com.example.alexa.carwiki.R;

import java.util.ArrayList;

public class GalleryBrandsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_gallerybrand);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setTitle("Car Wiki");

        ListView brandGallery = findViewById(R.id.galleryViewBrand);

        BrandAdapter carBrandAdapter;
        carBrandAdapter = new BrandAdapter(this, (ArrayList<CarBrand>) MainActivity.carBrands);
        brandGallery.setAdapter(carBrandAdapter);

        brandGallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), DetailsBrandsActivity.class);
                intent.putExtra("ContextItem",MainActivity.carBrands.get(i));
                startActivity(intent);
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_listbrands, menu);
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
            Intent intent = new Intent(getApplicationContext(), AddBrandActivity.class);
            startActivity(intent);
        }
        if(id==R.id.actions_seeCars){
            Intent intent = new Intent(getApplicationContext(), GalleryActivity.class);
            startActivity(intent);
        }
        if(id==R.id.actions_seeOwners){
            Intent intent = new Intent(getApplicationContext(), GalleryOwnersActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
