package com.android.mhn.rescuer;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class location extends AppCompatActivity {
    FusedLocationProviderClient mFusedLocationClient;
    Double lat, lng;
//    Button gomapper;
    Geocoder geocoder;
    List<Address> addresses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

/*
        gomapper=  findViewById(R.id.tomapper);
        gomapper.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent tomaps = new Intent(location.this, MapsActivity.class);
                startActivity(tomaps);
            }
        });
*/
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);


        mFusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        // Got last known location. In some rare situations this can be null.
                        if (location != null) {
                            // Logic to handle location object
                            System.out.println("location latitude" + location.getLatitude());
                            System.out.println("location longitude" + location.getLongitude());

                            geocoder = new Geocoder(com.android.mhn.rescuer.location.this, Locale.getDefault());

                            try {
                                addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(),1); // Here 1 represent max location result to returned, by documents it recommended 1 to 5
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                            String address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
                            TextView add = (TextView)findViewById(R.id.address);
                            add.setText(address);

                        }
                    }
                });


    }



}





