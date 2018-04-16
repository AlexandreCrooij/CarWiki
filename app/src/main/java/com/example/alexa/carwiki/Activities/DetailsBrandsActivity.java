package com.example.alexa.carwiki.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alexa.carwiki.Model.Car;
import com.example.alexa.carwiki.Model.CarBrand;
import com.example.alexa.carwiki.R;

public class DetailsBrandsActivity extends AppCompatActivity {
    private CarBrand carbrand;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_details_brands);

        setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
        getSupportActionBar().setTitle("Car Wiki");

        carbrand = (CarBrand) getIntent().getSerializableExtra("ContextItem");

        Resources resources = getResources();

        int idBrand = resources.getIdentifier(carbrand.getLogoUrl(), "drawable", getPackageName());

        ImageView imageBrand = findViewById(R.id.imageViewBrand);
        imageBrand.setImageResource(idBrand);

        TextView brand = findViewById(R.id.textViewBrandName);
        brand.setText(carbrand.getDescripion());

        TextView brandDescription = findViewById(R.id.textViewBrandDescription);
        brandDescription.setText(carbrand.getInformation());
    }

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
            Intent intent = new Intent(getApplicationContext(), EditBrandActivity.class);
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
