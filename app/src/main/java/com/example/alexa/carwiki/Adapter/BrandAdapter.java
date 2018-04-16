package com.example.alexa.carwiki.Adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alexa.carwiki.Model.CarBrand;
import com.example.alexa.carwiki.R;

import java.util.ArrayList;

/**
 * Created by alexa on 14.04.2018.
 */

public class BrandAdapter extends ArrayAdapter<CarBrand>{

    private Context mContext;
    private ArrayList<CarBrand> carBrandList = new ArrayList<>();


    public BrandAdapter(Context context, ArrayList<CarBrand> list) {
        super(context, 0 , list);
        mContext = context;
        carBrandList = list;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.list_itembrands,parent,false);

        CarBrand currentBrand = carBrandList.get(position);

        Resources resources = getContext().getResources();
        int id = resources.getIdentifier(currentBrand.getLogoUrl(), "drawable", getContext().getPackageName());

        ImageView imageBrand = listItem.findViewById(R.id.imageView_Brand);
        imageBrand.setImageResource(id);

        TextView brand = listItem.findViewById(R.id.textView_Brand);
        brand.setText(currentBrand.getDescripion());

        TextView brandDescription = listItem.findViewById(R.id.textView_BrandDescription);
        brandDescription.setText(getContext().getResources().getString(R.string.information)+"\n"+currentBrand.getInformation());

        return listItem;

    }

}
