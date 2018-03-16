package com.example.zeeshan.dublincycle;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zeeshan on 3/11/2018.
 */

public class MeetAdapter extends ArrayAdapter {

    // creating array for list
    List list = new ArrayList();

    public MeetAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    //adding objects from contacts to list
    public void add(Contacts object) {
        super.add(object);
        list.add(object);


    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //read each line
        View row;
        row = convertView;
        ContactHolder contactHolder;

        //condition
        if(row==null)
        {
            LayoutInflater layoutInflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            row = layoutInflater.inflate(R.layout.parse_layout,parent,false);

            contactHolder = new ContactHolder();
            contactHolder.number = (TextView) row.findViewById(R.id.tx_number);
            contactHolder.name = (TextView) row.findViewById(R.id.tx_name);
            contactHolder.address = (TextView) row.findViewById(R.id.tx_address);
            contactHolder.posLat = (TextView) row.findViewById(R.id.tx_posLat);
            contactHolder.posLng = (TextView) row.findViewById(R.id.tx_posLng);
            contactHolder.banking = (TextView) row.findViewById(R.id.tx_banking);
            contactHolder.bonus = (TextView) row.findViewById(R.id.tx_bonus);
            contactHolder.status = (TextView) row.findViewById(R.id.tx_status);
            contactHolder.contract_name = (TextView) row.findViewById(R.id.tx_contract_name);
            contactHolder.bike_stands = (TextView) row.findViewById(R.id.tx_bike_stands);
            contactHolder.available_bike_stands = (TextView) row.findViewById(R.id.tx_available_bike_stands);
            contactHolder.available_bikes = (TextView) row.findViewById(R.id.tx_available_bikes);
            contactHolder.last_update = (TextView) row.findViewById(R.id.tx_last_update);

            row.setTag(contactHolder);

        }

        else{

            contactHolder = (ContactHolder) row.getTag();
        }

        Contacts contacts = (Contacts) this.getItem(position);

        contactHolder.number.setText(contacts.getNumber());
        contactHolder.name.setText(contacts.getName());
        contactHolder.address.setText(contacts.getAddress());
        contactHolder.posLat.setText(contacts.getPosLat());
        contactHolder.posLng.setText(contacts.getPosLng());
        contactHolder.banking.setText(contacts.getBanking());
        contactHolder.bonus.setText(contacts.getBonus());
        contactHolder.status.setText(contacts.getStatus());
        contactHolder.contract_name.setText(contacts.getContract_name());
        contactHolder.bike_stands.setText(contacts.getBike_stands());
        contactHolder.available_bike_stands.setText(contacts.getAvailable_bike_stands());
        contactHolder.available_bikes.setText(contacts.getAvailable_bikes());
        contactHolder.last_update.setText(contacts.getLast_update());


        return row;
    }

    static class ContactHolder
    {
        TextView number,name,address,posLat,posLng,banking,bonus,
                status,contract_name,bike_stands,available_bike_stands,available_bikes,last_update;
    }
}