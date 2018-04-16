package com.example.alexa.carwiki.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.alexa.carwiki.Model.Car;
import com.example.alexa.carwiki.Model.CarBrand;
import com.example.alexa.carwiki.Model.Owner;
import com.example.alexa.carwiki.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static List<Car>cars;
    public static List<CarBrand>carBrands;
    public static List<Owner>carOwners;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setTitle("Car Wiki");
        ImageView start = findViewById(R.id.mainImage);
        start.animate().alpha(1f).setDuration(4000);

        CarBrand carBrand1 = new CarBrand(1,"BMW", "BMW","Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua.", "bmw");
        CarBrand carBrand2 = new CarBrand(2,"Audi", "Audi","Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua.","audi");
        CarBrand carBrand3 = new CarBrand(3,"Chrysler", "Chrysler", "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua.","maserati");
        CarBrand carBrand4 = new CarBrand(4,"Ford", "Ford","Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua." ,"bmw");
        CarBrand carBrand5 = new CarBrand(5,"Daimler", "Daimler","Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua." ,"mercedes");
        CarBrand carBrand6 = new CarBrand(6,"Tesla", "Tesla","Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua." ,"audi");
        CarBrand carBrand7 = new CarBrand(7,"Ferrari", "Ferrari","Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua." ,"bmw");

        carBrands = new ArrayList<CarBrand>(Arrays.asList(carBrand1,carBrand2,carBrand3,carBrand4,carBrand5,carBrand6,carBrand7));

        Owner owner1 = new Owner(1, "Alex", "Crooij", "ownerpic", "dawdawadwa");
        Owner owner2 = new Owner(2, "Danilo", "Marty", "ownerpic", "dawdawadwa");
        Owner owner3 = new Owner(3, "Mathis", "Fux", "ownerpic", "dawdawadwa");
        Owner owner4 = new Owner(4, "Anthony", "Ritz", "ownerpic", "dawdawadwa");
        Owner owner5 = new Owner(5, "Alex", "Crooij", "ownerpic", "dawdawadwa");
        Owner owner6 = new Owner(6, "Danilo", "Marty", "ownerpic", "dawdawadwa");
        carOwners = new ArrayList<Owner>(Arrays.asList(owner1, owner2, owner3, owner4, owner5, owner6));

        Car car1 = new Car(1,1,1,owner1, carBrand1, "X12", 12200, "4000 cm3", 52, 13, "Cabrio", 12, 12, "old6");
        Car car2 = new Car(2,1,3,owner1, carBrand3, "X13", 12200, "2000 cm3", 12, 12, "Limousine", 12, 12, "old7");
        Car car3 = new Car(3,1,4,owner1, carBrand4, "X14", 12200, "1400 cm3", -9, -55, "Coupe", 12, 12, "old8");
        Car car4 = new Car(4,2,1,owner2, carBrand2, "X15", 12200, "2341 cm3", -19, 124, "Cabrio", 12, 12, "old9");
        Car car5 = new Car(5,3,5,owner3, carBrand3, "X16", 12200, "4111 cm3", 36, 138, "PickUp", 12, 12, "old10");
        Car car6 = new Car(6,4,1,owner4, carBrand4, "X17", 12200, "2322 cm3", 48, 12, "Limousine", 12, 12, "old6");
        Car car7 = new Car(7,5,1,owner5, carBrand5, "X18", 12200, "1324 cm3", 46, 12, "Coupe", 12, 12, "old7");

        cars = new ArrayList<Car>(Arrays.asList(car1, car2, car3, car4, car5, car6, car7)){};

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
            Toast.makeText(this,"Setting",Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }
}

    /*
        try {
            SQLiteDatabase database = this.openOrCreateDatabase("Oldtimers", MODE_PRIVATE, null);

            database.execSQL("CREATE TABLE IF NOT EXISTS Owner " +
                    "(idOwner int PRIMARY KEY AUTOINCREMENT not null, prename nvarchar not null, familyname nvarchar not null, imageUrl nvarchar not null)");
            database.execSQL("CREATE TABLE IF NOT EXISTS CarBrand " +
                    "(IdCarBrand int PRIMARY KEY AUTOINCREMENT not null, category nvarchar not null, description nvarchar not null, imageUrl nvarchar not null)");
            database.execSQL("CREATE TABLE IF NOT EXISTS Car " +
                    "(idCar int PRIMARY KEY AUTOINCREMENT not null, idOwner int not null, idBrand int not null, nvarchar model not null, price float not null, hubraum nvarchar not null, xcoor float not null, ycoor float not null, " +
                    "aufbau nvarchar not null, zylinder int not null, baujahr int not null, imageUrl not null, FOREIGN KEY (idOwner) REFERENCES Owner(idOwner), FOREIGN KEY (idBrand)REFERENCES CarBrand(idCarBrand))");
            database.execSQL("INSERT INTO CarBrand (category, description, imageUrl)VALUES('BMW', 'BMW','bmw.jpg')");
            database.execSQL("INSERT INTO CarBrand (category, description, imageUrl)VALUES('Audi', 'Audi','audi.jpg')");
            database.execSQL("INSERT INTO CarBrand (category, description, imageUrl)VALUES('Porsche', 'Porsche','porsche.jpg')");
            database.execSQL("INSERT INTO CarBrand (category, description, imageUrl)VALUES('Ferrari', 'Ferrari','ferrari.jpg')");
            database.execSQL("INSERT INTO CarBrand (category, description, imageUrl)VALUES('VW', 'Volkswagen','volkswagen.jpg')");
            database.execSQL("INSERT INTO CarBrand (category, description, imageUrl)VALUES('Toyota', 'Toyota','toyota.jpg')");
            database.execSQL("INSERT INTO CarBrand (category, description, imageUrl)VALUES('Cadillac', 'Cadillac','cadillac.jpg')");
            database.execSQL("INSERT INTO CarBrand (category, description, imageUrl)VALUES('Maserati', 'Maserati','maserati.jpg')");
            database.execSQL("INSERT INTO CarBrand (category, description, imageUrl)VALUES('Chrysler', 'Chrysler','chrysler.jpg')");
            database.execSQL("INSERT INTO CarBrand (category, description, imageUrl)VALUES('Nissan', 'Nissan','nissan.jpg')");


        }
        catch(Exception e){

        }
        */