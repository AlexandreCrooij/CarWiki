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

import com.example.alexa.carwiki.Adapter.OwnerAdapter;
import com.example.alexa.carwiki.Model.Owner;
import com.example.alexa.carwiki.R;

import java.util.ArrayList;

public class GalleryOwnersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_galleryowner);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setTitle("Car Wiki");

        ListView ownerGallery = findViewById(R.id.galleryViewOwner);

        OwnerAdapter carOwnerAdapter;
        carOwnerAdapter = new OwnerAdapter(this, (ArrayList<Owner>) MainActivity.carOwners);
        ownerGallery.setAdapter(carOwnerAdapter);

        ownerGallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), DetailsOwnersActivity.class);
                intent.putExtra("ContextItem",MainActivity.carOwners.get(i));
                startActivity(intent);
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_listowners, menu);
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
            Intent intent = new Intent(getApplicationContext(), AddOwnerActivity.class);
            startActivity(intent);
        }
        if(id==R.id.actions_seeCars){
            Intent intent = new Intent(getApplicationContext(), GalleryActivity.class);
            startActivity(intent);
        }
        if(id==R.id.actions_seeBrands){
            Intent intent = new Intent(getApplicationContext(), GalleryBrandsActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
