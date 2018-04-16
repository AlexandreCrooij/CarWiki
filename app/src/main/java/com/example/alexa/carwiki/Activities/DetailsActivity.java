package com.example.alexa.carwiki.Activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alexa.carwiki.Model.Car;
import com.example.alexa.carwiki.R;

public class DetailsActivity extends AppCompatActivity {
    private Car car;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_details);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setTitle("Car Wiki");

        car = (Car)getIntent().getSerializableExtra("ContextItem");

        Resources resources = getResources();
        int idBrand = resources.getIdentifier(car.getCarBrand().getLogoUrl(), "drawable", getPackageName());
        int idCar = resources.getIdentifier(car.getImageUrl(), "drawable", getPackageName());
        int idOwner = resources.getIdentifier(car.getOwner().getImageUrl(), "drawable", getPackageName());

        ImageView imageBrand = findViewById(R.id.imageView_Brand);
        imageBrand.setImageResource(idBrand);

        ImageView imageCar = findViewById(R.id.imageView_Car);
        imageCar.setImageResource(idCar);

        ImageView imageOwner = findViewById(R.id.imageView_Owner);
        imageOwner.setImageResource(idOwner);

        TextView descriptionOwner = findViewById(R.id.textView_DescriptionOwner);
        descriptionOwner.setText(getResources().getString(R.string.vorname)+": "+car.getOwner().getPrename()+"\n"+getResources().getString(R.string.nachname)+": "+car.getOwner().getFamilyname());

        TextView brandCar = findViewById(R.id.textView_BrandCar);
        brandCar.setText(car.getCarBrand().getDescripion()+" "+car.getModel());

        TextView descriptionCar = findViewById(R.id.textView_DescriptionCar);
        descriptionCar.setText(getResources().getString(R.string.aufbau)+": "+car.getAufbau()+"\n"+getResources().getString(R.string.hubraum)+": "+car.getHubraum()+"\n"+getResources().getString(R.string.baujahr)+": "+car.getBaujahr()+"\n"+getResources().getString(R.string.preis)+": "+car.getPrice());

        TextView brand = findViewById(R.id.textView_Brand);
        brand.setText(car.getCarBrand().getDescripion());

        TextView brandDescription = findViewById(R.id.textView_BrandDescription);
        brandDescription.setText(getResources().getString(R.string.information)+"\n"+car.getCarBrand().getInformation());

    }

    public void standortAnzeigen(View view){
        Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
        intent.putExtra("ContextItem", car);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.actions_settings){
            Toast.makeText(this,"Setting",Toast.LENGTH_LONG).show();
        }
        if(id==R.id.actions_edit){
            Intent intent = new Intent(getApplicationContext(), EditCarActivity.class);
            startActivity(intent);
        }
        if(id==R.id.actions_remove){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(true);
            builder.setTitle(getResources().getString(R.string.löschen));
            builder.setMessage(getResources().getString(R.string.sicher));
            builder.setPositiveButton(getResources().getString(R.string.bestätigen),
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
            builder.setNegativeButton(getResources().getString(R.string.abbrechen), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();
        }
        return super.onOptionsItemSelected(item);
    }


}

