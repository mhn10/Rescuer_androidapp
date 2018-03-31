package com.android.mhn.rescuer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class assault_details extends AppCompatActivity {
    TextView text1,text2,text3,text4, text5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assault_details);
        text1=findViewById(R.id.text_loss);
        text2=findViewById(R.id.text_arm);
        text3=findViewById(R.id.text_inj);
        text4=findViewById(R.id.desc);
        text5=findViewById(R.id.people);


        Boolean check1 = getIntent().getExtras().getBoolean("loss");
        Boolean check2 = getIntent().getExtras().getBoolean("injury");
        Boolean check3 = getIntent().getExtras().getBoolean("armed");


        text1.setText("Suffered Loss:"+check1.toString());
        text2.setText("Suffered Injury:"+check2.toString());
        text3.setText("Armed: "+check3.toString());

        text4.setText("Desc:"+getIntent().getExtras().getString("descriptor"));
        text4.setText("Number of Assaulter:"+getIntent().getExtras().getString("no"));


    }
}
