package com.example.alexa.carwiki.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

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

}

