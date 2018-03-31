package com.android.mhn.rescuer;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class fire extends AppCompatActivity {
    Button callb, submit_fire;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire);

        callb = findViewById(R.id.call);
        submit_fire= findViewById(R.id.submit_button_fire);

        submit_fire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                Intent fireintent = new Intent(fire.this, fire_details.class);
                startActivity(fireintent);
            }
        });

        callb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:911"));
                startActivity(callIntent);


            }
        });
    }
}
