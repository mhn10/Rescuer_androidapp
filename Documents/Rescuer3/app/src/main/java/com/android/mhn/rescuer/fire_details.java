package com.android.mhn.rescuer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class fire_details extends AppCompatActivity {
    TextView text1,text2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire_details);

        text1=findViewById(R.id.inj);
        text2=findViewById(R.id.time);
        Boolean check1 = getIntent().getExtras().getBoolean("injury");
        text1.setText("Suffered injury:"+check1.toString());

        text2.setText("Time:"+getIntent().getExtras().getString("time"));
    }
}
