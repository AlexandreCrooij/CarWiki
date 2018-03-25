package com.example.alexa.carwiki.Adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alexa.carwiki.Model.Car;
import com.example.alexa.carwiki.R;

import java.util.ArrayList;

/**
 * Created by alexa on 24.03.2018.
 */

public class CarAdapter extends ArrayAdapter<Car> {

    private Context mContext;
    private ArrayList<Car> carList = new ArrayList<>();

    public CarAdapter(Context context, ArrayList<Car> list) {
        super(context, 0 , list);
        mContext = context;
        carList = list;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.list_item,parent,false);

        Car currentCar = carList.get(position);

        Resources resources = getContext().getResources();
        int id = resources.getIdentifier(currentCar.getImageUrl(), "drawable", getContext().getPackageName());

        ImageView image = listItem.findViewById(R.id.imageView_car);
        image.setImageResource(id);

        TextView brand = listItem.findViewById(R.id.textView_brand);
        brand.setText(currentCar.getCarBrand().getDescripion()+" "+currentCar.getModel());

        TextView owner = listItem.findViewById(R.id.textView_owner);
        owner.setText(getContext().getResources().getString(R.string.besitzer)+": "+currentCar.getOwner().getPrename()+" "+currentCar.getOwner().getFamilyname());

        TextView description = listItem.findViewById(R.id.textView_description);
        description.setText(getContext().getResources().getString(R.string.aufbau)+": "+currentCar.getAufbau()+"\n"+getContext().getResources().getString(R.string.hubraum)+": "+currentCar.getHubraum()+"\n"+getContext().getResources().getString(R.string.baujahr)+": "+currentCar.getBaujahr()+"\n"+getContext().getResources().getString(R.string.preis)+": "+currentCar.getPrice());

        return listItem;

    }

}
