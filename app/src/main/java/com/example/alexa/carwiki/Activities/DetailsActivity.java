package com.example.alexa.carwiki.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alexa.carwiki.Model.Car;
import com.example.alexa.carwiki.R;

public class DetailsActivity extends AppCompatActivity {
    private Car car;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        car = (Car)getIntent().getSerializableExtra("ContextItem");

        Resources resources = getResources();
        int idBrand = resources.getIdentifier(car.getCarBrand().getLogoUrl(), "drawable", getPackageName());
        int idCar = resources.getIdentifier(car.getImageUrl(), "drawable", getPackageName());
        int idOwner = resources.getIdentifier(car.getOwner().getImageUrl(), "drawable", getPackageName());

        ImageView imageBrand = (ImageView)findViewById(R.id.imageView_Brand);
        imageBrand.setImageResource(idBrand);

        ImageView imageCar = (ImageView)findViewById(R.id.imageView_Car);
        imageCar.setImageResource(idCar);

        ImageView imageOwner = (ImageView)findViewById(R.id.imageView_Owner);
        imageOwner.setImageResource(idOwner);

        TextView brandCar = (TextView)findViewById(R.id.textView_BrandCar);
        brandCar.setText(car.getCarBrand().getDescripion()+" "+car.getModel());

        TextView descriptionCar = (TextView)findViewById(R.id.textView_DescriptionCar);
        descriptionCar.setText(getResources().getString(R.string.aufbauTitle)+": "+car.getAufbau()+"\n"+getResources().getString(R.string.hubraumTitle)+": "+car.getHubraum()+"\n"+getResources().getString(R.string.baujahrTitle)+": "+car.getBaujahr()+"\n"+getResources().getString(R.string.priceTitle)+": "+car.getPrice());

        TextView brand = (TextView)findViewById(R.id.textView_Brand);
        brand.setText(car.getCarBrand().getDescripion());

        TextView brandDescription = (TextView)findViewById(R.id.textView_BrandDescription);
        brandDescription.setText("Information: \n"+car.getCarBrand().getInformation());

    }

    public void standortAnzeigen(View view){
        Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
        intent.putExtra("ContextItem", car);
        startActivity(intent);
    }

}

