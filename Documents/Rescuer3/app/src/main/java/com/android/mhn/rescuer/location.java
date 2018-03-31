package com.android.mhn.rescuer;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.Uri;
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
    Double lat, longi;
    Button gomapper;
    Geocoder geocoder;
    List<Address> addresses;
    //Double lat,longi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {




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
                            lat=location.getLatitude();
                            longi= location.getLongitude();
                            geocoder = new Geocoder(com.android.mhn.rescuer.location.this, Locale.getDefault());

                            try {
                                addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(),1); // Here 1 represent max location result to returned, by documents it recommended 1 to 5
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                            gomapper=  findViewById(R.id.tomapper);
                            gomapper.setOnClickListener(new View.OnClickListener(){
                                @Override
                                public void onClick(View v){


                                    // Create a Uri from an intent string. Use the result to create an Intent.
                                  Uri gmmIntentUri = Uri.parse("geo:"+lat+","+longi);
                                    //Uri gmmIntentUri = Uri.parse("geo:"+lat+","+"0.013988");
                                    //Uri gmmIntentUri = Uri.parse("google.streetview:cbll=46.414382,10.013988");

                                    // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
                                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                                    // Make the Intent explicit by setting the Google Maps package
                                    mapIntent.setPackage("com.google.android.apps.maps");

                                    // Attempt to start an activity that can handle the Intent
                                    startActivity(mapIntent);
                                }
                            });

                            String address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
                            TextView add = (TextView)findViewById(R.id.address);
                            add.setText(address);

                        }
                    }
                });


    }



}





