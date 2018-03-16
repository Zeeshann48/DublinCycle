package com.example.zeeshan.dublincycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Zeeshan Nasir(15438) on 3/09/2018.
 */


public class ListView extends AppCompatActivity {

    //variables
    String json_string;

    MeetAdapter meetAdapter;
    android.widget.ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listView = (android.widget.ListView) findViewById(R.id.listView);


        //adding adapter for list view
        meetAdapter = new MeetAdapter(this,R.layout.parse_layout);
        listView.setAdapter(meetAdapter);

        json_string = getIntent().getExtras().getString("json_data");

        //try and catch method
        try {


            JSONArray json = new JSONArray(json_string);


            int count = 0;

            String number,name,address,position,position1,banking,bonus,status,contract_name,bike_stands,available_bike_stands,available_bikes,last_update;

            while (count<json.length())
            {
                JSONObject JO = json.getJSONObject(count);

                //split position into latitude and longitude
                JSONObject lb = JO.getJSONObject("position");

                lb.get("lat");
                lb.get("lng");

                //connecting to contacts activity
                Contacts.myLat.add((double)lb.get("lat"));
                Contacts.myLng.add((double)lb.get("lng"));
                Contacts.myName.add((String)JO.get("name"));



                //getting string from api
                number = JO.getString("number");
                name = JO.getString("name");
                address = JO.getString("address");
                position= lb.getString("lat");
                position1 = lb.getString("lng");
                banking = JO.getString("banking");
                bonus = JO.getString("bonus");
                status = JO.getString("status");
                contract_name = JO.getString("contract_name");
                bike_stands = JO.getString("bike_stands");
                available_bike_stands = JO.getString("available_bike_stands");
                available_bikes = JO.getString("available_bikes");
                last_update = JO.getString("last_update");

                Contacts contacts = new Contacts("Station No: "+ number,"Name: "+name,
                        "Address: "+address,"Latitude: "+position,"Longitude: "+position1,
                        "Banking: "+banking,"Bonus: "+bonus,"status: "+status,
                        "contractName: "+contract_name, "bikeStands: "+bike_stands,
                        "availableStands: "+available_bike_stands,
                        "availableBikes: "+available_bikes, "lastUpdate: "+last_update);

                meetAdapter.add(contacts);


                count++;
            }

        }catch (JSONException e){
            e.printStackTrace();
        }
    }


}
