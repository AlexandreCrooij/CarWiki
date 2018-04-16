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
import com.example.alexa.carwiki.Model.Owner;
import com.example.alexa.carwiki.R;

import java.util.ArrayList;

/**
 * Created by alexa on 14.04.2018.
 */

public class OwnerAdapter extends ArrayAdapter<Owner>{

    private Context mContext;
    private ArrayList<Owner> carOwnerList = new ArrayList<>();


    public OwnerAdapter(Context context, ArrayList<Owner> list) {
        super(context, 0 , list);
        mContext = context;
        carOwnerList = list;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.list_itemowners,parent,false);

        Owner currentOwner = carOwnerList.get(position);

        Resources resources = getContext().getResources();
        int id = resources.getIdentifier(currentOwner.getImageUrl(), "drawable", getContext().getPackageName());

        String idW = currentOwner.getImageUrl();

        ImageView imageOwner = listItem.findViewById(R.id.imageView_Owners);
        imageOwner.setImageResource(id);

        TextView owner = listItem.findViewById(R.id.textView_Owners);
        owner.setText(currentOwner.getPrename()+" "+currentOwner.getFamilyname());

        TextView ownerDescription = listItem.findViewById(R.id.textView_OwnersDescription);
        ownerDescription.setText(currentOwner.getDescription());

        return listItem;

    }

}
