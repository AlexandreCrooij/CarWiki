package com.example.alexa.carwiki.Activities;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.alexa.carwiki.Entities.AppDatabase;
import com.example.alexa.carwiki.Entities.CarBrandEntity;
import com.example.alexa.carwiki.Entities.CarEntity;
import com.example.alexa.carwiki.Entities.OwnerEntity;
import com.example.alexa.carwiki.Model.Car;
import com.example.alexa.carwiki.Model.CarBrand;
import com.example.alexa.carwiki.Model.Owner;
import com.example.alexa.carwiki.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public static List<Car>cars;
    public static List<CarBrand>carBrands;
    public static List<Owner>carOwners;
    public List<OwnerEntity> ownerEntities;
    public List<CarEntity> carEntities;
    public List<CarBrandEntity> carBrandEntities;
    public AppDatabase db;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Looks into the sharedPreferences in order to determine preferred language
        sharedPreferences = this.getSharedPreferences("sharedPreferences", Context.MODE_PRIVATE);
        String language = sharedPreferences.getString("lang", "empty");

        //Sets language to preferred language
        Locale myLocale;
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        myLocale = new Locale(language);
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);

        //Setting the content and making a fading in effect for the main image
        setContentView(R.layout.activity_main);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setTitle("Car Wiki");
        ImageView start = findViewById(R.id.mainImage);
        start.animate().alpha(1f).setDuration(4000);

        //Deletes all owners and Brands and Cars
        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "production").fallbackToDestructiveMigration().build();
        db.ownerDao().deleteAllOwners();
        db.carBrandDao().deleteAllBrands();
        ownerEntities = db.ownerDao().getAllOwners();
        carEntities = db.carDao().getAllCars();
        carBrandEntities = db.carBrandDao().getAllBrands();
    }

    public void goToGallery(View view){
        Intent i = new Intent(getApplicationContext(), GalleryActivity.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.actions_settings){
            Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
