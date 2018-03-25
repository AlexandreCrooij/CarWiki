package com.example.alexa.carwiki.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;

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

        ListView oldTimerGallery = findViewById(R.id.galleryView);

        /*
        final ArrayList<String> oldtimers;
        oldtimers = new ArrayList<String>();
        oldtimers.add("Alex");
        oldtimers.add("Peter");
        oldtimers.add("Alex");
        oldtimers.add("Peter");
        oldtimers.add("Alex");
        oldtimers.add("Peter");
        oldtimers.add("Peter");
        oldtimers.add("Alex");
        oldtimers.add("Peter");
        oldtimers.add("Alex");
        oldtimers.add("Peter");
        oldtimers.add("Alex");
        oldtimers.add("Peter");
        oldtimers.add("Alex");
        oldtimers.add("Peter");
        oldtimers.add("Alex");
        oldtimers.add("Peter");
        oldtimers.add("Alex");
        oldtimers.add("Peter");
        oldtimers.add("Alex");
        oldtimers.add("Peter");
        oldtimers.add("Alex");
        oldtimers.add("Peter");
        */

        CarAdapter carAdapter;
        carAdapter = new CarAdapter(this, (ArrayList<Car>) MainActivity.cars);
        oldTimerGallery.setAdapter(carAdapter);
/*
        ArrayAdapter<String>arrayAdapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, oldtimers);

        oldTimerGallery.setAdapter(arrayAdapter);
*/
        oldTimerGallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
                intent.putExtra("ContextItem",MainActivity.cars.get(i));
                startActivity(intent);
            }
        });
    }
}
