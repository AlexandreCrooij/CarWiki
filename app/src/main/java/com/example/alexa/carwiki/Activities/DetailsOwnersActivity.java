package com.example.alexa.carwiki.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alexa.carwiki.Helper.DownloadImageTask;
import com.example.alexa.carwiki.Model.CarBrand;
import com.example.alexa.carwiki.Model.Owner;
import com.example.alexa.carwiki.R;

import java.io.InputStream;

public class DetailsOwnersActivity extends AppCompatActivity {
    private Owner owner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_details_owners);

        setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
        getSupportActionBar().setTitle("Car Wiki");

        owner = (Owner) getIntent().getSerializableExtra("ContextItem");

        Resources resources = getResources();

        int idOwner = resources.getIdentifier(owner.getImageUrl(), "drawable", getPackageName());

        ImageView imageBrand = findViewById(R.id.imageViewOwner);
        imageBrand.setImageResource(idOwner);

        new DownloadImageTask((ImageView) findViewById(R.id.imageViewOwner)).execute("https://www.bmw.ch/content/dam/bmw/common/all-models/m-series/m4-coupe/2017/images-and-videos/images/BMW-m4-coupe-images-and-videos-1920x1200-01.jpg.asset.1487343850903.jpg");

        TextView brand = findViewById(R.id.textViewOwnerName);
        brand.setText(owner.getPrename()+" "+owner.getFamilyname());

        TextView brandDescription = findViewById(R.id.textViewOwnerDescription);
        brandDescription.setText(owner.getDescription());
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
            Intent intent = new Intent(getApplicationContext(), EditOwnerActivity.class);
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



